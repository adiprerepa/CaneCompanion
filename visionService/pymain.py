from concurrent import futures
from datetime import datetime
from google.cloud import vision
from google.cloud.vision import types
import grpc
from gtts import gTTS
import io
import MySQLdb
import vision_pb2
import vision_pb2_grpc

insertsql = "insert into %s_vision (objectDetected, insertTime) values ('%s', '%s')"

class Application(vision_pb2_grpc.VisionMicroserviceServicer):
    def __init__(self):
        self.vision_client = vision.ImageAnnotatorClient()
        self.database = MySQLdb.connect(host="10.0.1.202",port=3306,user="aditya",passwd="adityapc",db="uservision")
        self.cursor = self.database.cursor()

    def image2text(self, image_content):
        #return self.vision_client.label_detection(image=types.Image(content=image_content)).label_annotations[0].description
        return '. '.join(map(lambda a: a.description, self.vision_client.label_detection(image=types.Image(content=image_content)).label_annotations))
    def text2speech(self, text):
        tts = gTTS(text)
        tts.save("tts.mp3")
        b = io.open("tts.mp3", "rb")
        return b.read()

    def image2speech(self, image_content):
        return self.text2speech(self.image2text(image_content))

    def mysqlAddEntry(self, user, obj, time):
        isql =insertsql % (user, obj, time)
        print(isql)
        self.cursor.execute(isql)
        self.database.commit()
        print("done commit")

    def AppCall(self, request, context):
        return AppReply(object_name="to be implemented", time="to be implemented")

    def CaneCall(self, request, context):
        text = self.image2text(request.png_data)
        print(request.username, text, str(datetime.now()))
        self.mysqlAddEntry(request.username, text, str(datetime.now()))
        return vision_pb2.CaneReply(wav_data=self.text2speech(text))

    def main(self):
        server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
        vision_pb2_grpc.add_VisionMicroserviceServicer_to_server(self, server)
        server.add_insecure_port("[::]:50055")
        server.start()
        try:
            while True:
                pass

        except KeyboardInterrupt:
            server.stop(0)

if __name__ == "__main__":
    Application().main()
