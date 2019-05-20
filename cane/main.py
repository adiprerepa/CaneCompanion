import geocoder
import grpc
import gps_pb2, gps_pb2_grpc, vision_pb2, vision_pb2_grpc
from RPi import GPIO
import os
from picamera import PiCamera
from time import sleep
from io import BytesIO
import io
from multiprocessing import Process

butpin = 2
GPIO.setmode(GPIO.BCM)
GPIO.setup(butpin, GPIO.IN)

ip = "canecompaniont420.ddns.net"

vision_channel = grpc.insecure_channel(ip + ":50055")
vision_stub = vision_pb2_grpc.VisionMicroserviceStub(vision_channel)
gps_channel = grpc.insecure_channel(ip + ":11612")
gps_stub = gps_pb2_grpc.GpsServiceStub(gps_channel)

camera = PiCamera()
sleep(2)
print("Ready")

def keypressed():
    return not GPIO.input(butpin)

def caneCall(username, image_content):
    return
def coordThread():
        while True:
            print("send location")
            latitude, longitude = geocoder.ip("me").latlng
            print(latitude, longitude)
            gps_stub.CaneInsert(gps_pb2.CaneCoordinates(username="aditya", latitude=latitude, longitude=longitude))
            sleep(60)

lastState = False

try:
    thread = Process(target=coordThread, args=())
    thread.start()

    while True:
        curState = keypressed()

        if (lastState != curState):
            lastState = curState

            if (curState):
                print("pressed")
                stream = BytesIO()
                print("taking pic")
                camera.capture("image.png")
                print("taken")
                print("calling")
                response = vision_stub.CaneCall(vision_pb2.CaneRequest(username="aditya", png_data=io.open("image.png", "rb").read()))
                print("called")
                rfile = io.open("response.mp3", "wb")
                rfile.write(response.wav_data)
                rfile.close()
                os.system("omxplayer -o local response.mp3")

except:
    camera.close()
    thread.terminate()
    GPIO.cleanup()
