import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatClient extends JFrame {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    private JTextArea chatArea;
    private JTextField messageField;
    private String userName;

    public ChatClient(String userName) {
        this.userName = userName;

        setTitle("Simple Chat - " + userName);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);

        connectToServer();
        startReceivingMessages();
    }

    private void connectToServer() {
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send the user's name to the server
            out.println(userName);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect to the server.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void startReceivingMessages() {
        Thread receivingThread = new Thread(() -> {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    chatArea.append(message + "\n");

                    // If the message was sent by the client itself, append it to the chat area as well
                    if (message.startsWith(userName + ": ")) {
                        chatArea.append(message + "\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        receivingThread.start();
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            out.println(userName + ": " + message);
            chatArea.append("You: " + message + "\n");
            messageField.setText("");
        }
    }

    public static void main(String[] args) {
        String userName = JOptionPane.showInputDialog(null, "Enter your name:", "Login", JOptionPane.PLAIN_MESSAGE);
        if (userName == null || userName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else {
            SwingUtilities.invokeLater(() -> new ChatClient(userName));
        }
    }
}
