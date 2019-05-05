import grpc, greet_pb2_grpc, greet_pb2
def run():
  channel = grpc.insecure_channel('10.0.1.16:35156')
  stub = greet_pb2_grpc.GreeterStub(channel)
  response = stub.SayHello(greet_pb2.HelloRequest(name='bobby'))
  print("Greeter client received: " + response.message)


run()
