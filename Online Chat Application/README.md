**Simple Online Chat Application In JAVA**

**Introduction**

This Java-based online chat application facilitates real-time communication among multiple users through a central server. The application includes both server-side (ChatServer) and client-side (ChatClient) components. Users can connect to the server, send messages, and receive messages from other connected users.

**Implementation Details**

**Server Implementation (ChatServer)**

- The ChatServer class manages connections from multiple clients using socket programming.
- It assigns a unique user ID to each connected client and maintains a list of connected users.
- The server broadcasts messages to all connected clients.

**Client Implementation (ChatClient)**

- The ChatClient class connects to the server using sockets and enables users to send messages.
- Each client can receive messages from other users.
- Two versions of the ChatClient (ChatClient and ChatClient2) are provided for demonstration purposes.

**User Interface**

- The user interface is a simple text-based interface for message input and display.
- It includes a text area to display incoming messages and a text field to input new messages.
