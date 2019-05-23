import geocoder
import grpc
import vision_pb2, vision_pb2_grpc
from RPi import GPIO
import os
from picamera import PiCamera
from time import sleep
import time
import io
from multiprocessing import Process
import traceback

butpin = 2

ip = "canecompaniont420.ddns.net"
myusername = "aditya"

print("initializing")
GPIO.setmode(GPIO.BCM)
GPIO.setup(butpin, GPIO.IN)
vision_channel = grpc.insecure_channel(ip + ":50055")
vision_stub = vision_pb2_grpc.VisionMicroserviceStub(vision_channel)
camera = PiCamera()
camera.resolution = (640, 480)
camera.framerate = 80
sleep(2)
print("ready")


def key_pressed():
    return not GPIO.input(butpin)

def camera_capture():
    stream = io.BytesIO()
    camera.capture(stream, "png")
    return stream.getvalue()

def cane_call(image_content):
    return vision_stub.CaneCall(vision_pb2.CaneRequest(username=myusername, png_data=image_content))

last_state = False

try:
    while True:
        cur_state = key_pressed()

        if (last_state != cur_state):
            last_state = cur_state

            if (cur_state):
                print("pressed")
                print("taking pic")
                stream = camera_capture()
                print("taken")
                print("calling")
                response = cane_call(stream)
                print("called")
                rfile = io.open("response.mp3", "wb")
                rfile.write(response.wav_data)
                rfile.close()
                print("saved response")
                os.system("omxplayer -o local response.mp3")
except:
    traceback.print_exc()
    print("closing")
    camera.close()
    GPIO.cleanup()
