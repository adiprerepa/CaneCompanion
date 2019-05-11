import base64
from google.cloud import vision
from google.cloud.vision import types
import io
import os


os.system("export GOOGLE_APPLICATION_CREDENTIALS='%s'" % os.getcwd() + "/cred.json")

client = vision.ImageAnnotatorClient()

file_name = os.path.join(os.path.dirname(__file__), 'png.jpg')

with io.open(file_name, 'rb') as image_file:
    content = image_file.read()

image = types.Image(content=content)

response = client.label_detection(image=image)
labels = response.label_annotations

print('Labels:')
for label in labels:
    print(label.description)
