mvn package;
cd target;
java -cp $GRPC:gpsService-1.0-SNAPSHOT.jar:mysql-connector-java-8.0.15.jar com.prerepa.gps.Main 

