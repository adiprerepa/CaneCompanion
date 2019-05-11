import base64
from google.cloud import vision
from google.cloud.vision import types
import io
import os

client = vision.ImageAnnotatorClient()

def getImageLabels(imageContent):
    return client.label_detection(image=types.Image(content=imageContent)).label_annotations

with open("cat.jpg", 'rb') as f:
  contents = f.read()

print(getImageLabels(contents))
