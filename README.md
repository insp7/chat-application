# Chat Application
A one to one client-server chatting application from the terminal. Implemented using Socket and ServerSocket classes.

## What are Sockets?
**From oracle documentation:**
A socket is one endpoint of a two-way communication link between two programs running on the network. 
A socket is bound to a port number so that the TCP layer can identify the application that data is destined to be sent to.

For more information on sockets, [click here](https://docs.oracle.com/javase/tutorial/networking/sockets/definition.html)

## How to use?
To start the application, follow these steps:

### 1. Clone 
```
cd desired-directory
git clone https://github.com/insp7/chatApplication.git
```

### 2. Compile
Compile Server.java and Client.java 
```
cd chatApplication
javac src/Server.java
javac src/Client.java
```

### 3. Execute
Execute the .class files generated. **It is important to execute the Server first**
```
java src/Server
java src/Client
```

### Sample Output
![client-server-communication](https://user-images.githubusercontent.com/28151282/61800400-93ae5700-ae4a-11e9-850c-36bd0c75c514.gif)

## Next Module
Implementation of a **centralized server:**
A texting application in which a client sends a text-msg to a central server and the server forwards that message to the intended recipient.


