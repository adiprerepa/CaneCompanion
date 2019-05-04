# Account Microservice Protocols

The Accounts Microservice is very useable, and always running! Here is how you contact and make transactions with this server and how to use it. This is a guide that is as detailed as possible, for more detail, look at the code.

# Association with the Cane
Every time the cane boots, the last used WiFi SSID and Password are send on a separate thread. The Raspberry Pi Initiates the connection, and the information is send back immediately. That is basically all of the association with the Accounts Microservice with the cane, most of the transaction occur via applications.

Future Applications to Associate with the Accounts Microservice:

  - Web Application - Make purchase (fill in cane id) and View Product
  - Desktop Applications - Logins, Wifi Inserts, View product
  - Mobile Applications - Logins, Wifi Inserts, and View Product

# The Cane ID concept
To prevent theft of canes, Aditya cane(not a typo) up with an system to do just that. When you go to the CaneCompanion website, you are required to make an account to do anything. Once the account is made (via some interface), the username, email, password and all relevant information are sent to the Account Microservice, which then inserts these values into the database. An account can be made without any purchases. Once a purchase is made, a Cane ID is given to the user, as well as inserted into another table in the database. In an interface, if you click the "add cane" button, you enter the cane ID you were given, and it checks if it is you who actually bought the cane. This is how we implement cane security.

# Tech

As of 5/3/2019, this service is running on one machine, in primarily in java. There is a mySQL back-end, where we do the checking and the registry. The service uses gRPC to communicate with the cane and the app.

# How to work on it


### On the Server
First, log onto the server, with the command :
ssh -i "GameConnection.pem" ubuntu@<hostname>

Then, to pull the latest commits from github, run :
```git
$ git pull origin master
```

Go to CaneCompanion/AccountsMicroservice. You Should see an src and target folder, some build scripts, and a pom.
To build and compile the project, run :
```bash
$ mvn clean package
```

This command will generate a jar in the /target directory. Run this jar along with other dependencies with the command :
```bash
$ java -cp AccountsMicroservice-1.0-SNAPSHOT.jar:<other jars>:<other jars> com.something.Main
```
When you have a working commit, commit it to github with:

```bash
$ git add .
$ git commit -m <message>
$ git pull origin master
$ git push origin master
```
This is for testing. In order to deploy the cron, inside the AccountsMicroservice directory, there should be a script called ```runcron.sh```. Run that command with
```bash
$ sudo ./runCron.sh
```
The cron will run indefiniteley, and you can log off if your work is done now. If you wish to shut down the cron, run
```bash
$ ps -ef
```
And find the command with the java -cp in it. Navigate to the second column of that row, get the pid, and run 
```bash
$ kill <pid>
```

To view the history of what happened in the cron, type ``vim nohup.out``, and you should be able to see the event history.

### In Intellij or some other IDE

In order to commit from intellij, the process is much simpler. Log onto the server as seen in the steps above, and go into the ``AccountsMicroservice`` directory. Have this on standby. Now, clone our repository with
```bash
$ git clone git@github.com:adiprerepa/CaneCompanion.git
```
Make sure you are a collaborator to this repository, and have your ``/.ssh/id.rsa_pub`` in your ssh and gpg keys. If you have not done this, go to this link. [SSH-KEYGEN](https://help.github.com/en/articles/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)

Once you are a definite collaborator from your local machine, open ``CaneCompanion`` with your ide. Make some edits, run some tests, whatever. Once you are done, commit the code with the steps above. Now, once the code is commited, go to the remote server and run
```bash
$ git pull origin master
```
Now, your changes will be on the server, and you can deploy them as seen in the instructions above.

### Data flow in the Microservice

So this microservice relies on gRPC to send data. The inteface sends cane id and user to check with mysql, and registry from web servers just inserts into mysql. There are checks for accounts happening quite often, but that is it.

### Todos

 - Finish this markdown
 - add server dependencies

License
----

MIT


**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>
   [REPO]: <https://help.github.com/en/articles/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
