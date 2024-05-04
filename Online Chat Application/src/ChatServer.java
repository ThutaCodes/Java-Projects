import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static int userIdCounter = 0;
    private static Map<Integer, PrintWriter> connectedClients = new HashMap<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for clients to connect...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Assign a unique user ID to the client
                int userId = ++userIdCounter;

                // Create a new thread to handle client communication
                Thread clientThread = new Thread(new ClientHandler(clientSocket, userId));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Broadcast message to all connected clients
    public static synchronized void broadcastMessage(String message, int senderUserId) {
        for (Map.Entry<Integer, PrintWriter> entry : connectedClients.entrySet()) {
            if (entry.getKey() != senderUserId) {
                entry.getValue().println("User " + senderUserId + ": " + message);
            }
        }
    }

    // Inner class to handle client connections
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private int userId;

        public ClientHandler(Socket socket, int userId) {
            this.clientSocket = socket;
            this.userId = userId;
        }

        @Override
        public void run() {
            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Add client's PrintWriter to the map of connected clients
                synchronized (ChatServer.class) {
                    connectedClients.put(userId, out);
                }

                out.println("Welcome to the chat! Your user ID is: " + userId);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received message from user " + userId + ": " + inputLine);
                    broadcastMessage(inputLine, userId);
                }
            } catch (SocketException e) {
                // Handle connection reset exception
                System.out.println("Client disconnected abruptly: " + clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Remove client from the map when they disconnect
                synchronized (ChatServer.class) {
                    connectedClients.remove(userId);
                }
                System.out.println("Client disconnected: " + clientSocket);
            }
        }
    }
}
