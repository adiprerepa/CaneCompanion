# CaneCompanion

# Update 5/12/19
After a few months of restructuring everything, we completely refactored and remade the project (Redundant I know). This time, we made an IoS app, a new cane, and restructured the servers to microservice architecture with grpc, and new database schema.

## IoS app
 - We implemented an IoS app in swift with functionality to retrieve coordinates from the cane from the gps microservice, under the directory `gpsService`. 
 - The app used `gRPC` and the google maps api to pin the coordinates of the cane in real time.
 - There is also a login screen, and a create account screen that would converse with the `accountsService`, and the users would own different canes which could be tracked through the app. We added support for as many canes as you could want or get running the cane software. You could also view the pictures taken through the cane.

## Servers
### Accounts Microservice
This service would both insert into a database when a new user was created, authenticate users, or set expiry limits on users. The service was in Java and used `gRPC`, and the database was in mysql. See files : `accountsService/src/main/java/com/prerepa/accounts/AccountsDatabase.java` and `accountsService/src/main/java/com/prerepa/accounts/LoginServer.java`

### GPS Microservice
This service would retrieve coordinates on one thread from the cane which updated every 10 seconds to the server, and would send to the IoS app which would display the realtime coordinates on the map. The mySql schema was fairly simple, and the proto file was also simple. See Files :
`gpsService/src/main/java/com/prerepa/gps/GpsDatabase.java` and 
`gpsService/src/main/java/com/prerepa/gps/RequestServer.java` for the src.

### Vision Microservice
This service would use the google vision API with our pre-programmed model for identifying images. The service recieve a byte array of image data and send back what the model thought the image had in it. This service was written in python for simplicity, and inserts data about the API call into the database. It also has the capability of sending a list of all the images and info about the API call in an array back to whatever client you choose. See File :
`visionService/pymain.py`

## Cane
The cane was also made in Python (originially C++), and has the functionality of taking a picture with a camera that is on the front of the cane, (on the press of a button), and sending it to the `Vision Microservice`. Then, it receives back a wav of the image data in a byte[], and plays it on the speaker on the cane, attached to the raspberry pi. The cane functionality is pretty straightforward, see :
`cane/vision_client.py`
And the attached videos

# What we learned after the update
We learned alot about rest and grpc, and hardware interfacing with the RPI. It was much faster because we used `gRPC` instead of raw sockets, and we learned alot about the app development process too.
## The perks of gRPC
gRPC is great, and we chose it because its lightweight, uses *powerful* binary serialization, and is cross platform.

# Authors
- Aditya Prerepa
- Akshay Trivedi
- Ishan Jain

FIRST WRITTEN ON 3/23/19
BUILT AT A HACKATHON
## Inspiration

I have an uncle who is legally blind, and someone needs to be watching over him at all times. Everyone is always worried for his safety, and he has virtually no physical independence. What we hope to fix for him and all other blind people is giving these people vision, so they can be safer and more independent.

## What it does

The cane has a camera at one end and a speaker and button on the other end. When you run the program and press the button, it takes a picture and the speaker reads aloud what object is in front of you using a machine learning object detection model and a text to speech algorithm, both of which are provided by google. Temporarily, we have the data sent through a socket to a server that talks to google because if the RPi talked to google itself, it could overwhelm the RPi and fry it. So essentially, you press a button and the cane takes a picture of what's in front of you and then says it aloud.

## How we built it

We used java, sockets and an RPi. We used the jrpicam module to take a picture, which is a java version of the picamera python module, which has the ability to control a RPi camera extension. We used the omxplayer bash command to play an mp3 noise. To send the image to the computer that talks to the cloud and receive the image, we used java sockets (probably the most frustrating API of everything we used). Finally, we used GCP to convert the image into an mp3 that says the object in the image.

## Challenges we ran into

We ran into a plethora of challenges. First, the LosAltosHacks router doesn't allow for peer-to-peer connections so we had to use our own hotspot. Also, the java sockets are broken and refuse to work without the code being completely absurd. To send an image, you would call the sending function once, but to receive the image, you would have to call the receiving function thrice and ignore the second two return values because they would be null. If it was in a while loop, one in every three images received would be null for some reason. After solving that bug with some stupid code, we ran into the issue of sending the mp3 back. Java sockets are buffered, and send/receive data piece by piece. However, there's no way to tell the receiving buffer to stop receiving. We ended up putting a Thread.sleep(500); and then sending one byte to close the receiving buffer. This would prevent this byte buffer from joining with another buffer, so the receiver end could differentiate the packet as a lone, useless bit and exit the receiving buffer loop. By then, our brains were already fried. We had no idea how to play a sound on the RPi for 30 minutes until we came across omxplayer, but that was in bash, not java. However, that was now problem for Runtime.getRuntime().exec().

## Accomplishments that we're proud of

We're very proud to have finished the project. We worked together and we could solve the problems peacefully, despite how frustrating our issues were.

## What we learned

It's most productive to solve problems peacefully, rather than yelling and swearing and showing frustration towards every setback. Talk to the team about the problems in a civil way, and it will be so much easier.

## What's next for CaneCompanion

make the cane recite the direction of the object by getting its position on the image
make the cane detect more than one object.
put all the code on the RPi
fix the sockets (they work but the can be better. this change will only be if we ignore the one above)

## Links

Devpost : https://devpost.com/software/canecompanion-9czko1  
Slides : https://docs.google.com/presentation/d/1PGyEW9AsaN5V5b1ktX0y9_PrPj6ogfRfIv1v2cHbU4c/edit?usp=sharing
##TODO
Make a new ReadMe
Finish Google vision and accounts microservice
Render s3 bucket for AWS

