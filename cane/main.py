import geocoder

import grpc, gps_pb2, gps_pb2_grpc, time

channel = grpc.insecure_channel('10.0.1.16:48162')

stub = gps_pb2_grpc.GpsServiceStub(channel)
g = geocoder.ip('me')

latitude = g.latlng[0]
longitude = g.latlng[1]

timenow = int(time.time()) + 1

while (int(time.time()) < timenow):
    pass

count = 0

while (int(time.time()) == timenow):
    response = stub.CaneInsert(gps_pb2.CaneCoordinates(username="akshay", latitude=latitude, longitude=longitude))
    print("Greeter client received: " + str(response.insertStatus))
    count += 1

print(count)
