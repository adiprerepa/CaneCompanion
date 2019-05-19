import grpc
import io
import Canecompanion/visionService/vision_pb2
import Canecompanion/visionService/vision_pb2_grpc

channel = grpc.insecure_channel("localhost:50051")
stub = vision_pb2_grpc.VisionMicroserviceStub(channel)

image = io.open("cat.png", "rb").read()
response = stub.CaneCall(vision_pb2.CaneRequest(username="aditya", png_data=image))
print("1")
fd = io.open("result.mp3", "wb")
print("1")
fd.write(response.wav_data)
print("1")
fd.close()
print("1")

