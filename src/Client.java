import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import java.io.IOException;

public class Client {

    private static final String SERVER_NAME = "localhost"; // 127.0.0.1
    private static final int PORT = 7000; // assign random unused port

    public static void main(String[] args) throws IOException {

        String receiveMessage;

        Socket socket = new Socket(SERVER_NAME, PORT);
        BufferedReader readMsgToSend = new BufferedReader(new InputStreamReader(System.in)); // to read the client msg from terminal

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true); // for writing out to the output stream
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(socket.getInputStream())); // for reading from input stream

        System.out.println("To send text, enter your message and press enter");

        // create a thread for sending to the server while your main thread receives from the server.
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sendMessage = null;

                while (true) {
                    try {
                        sendMessage = readMsgToSend.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    writer.println("[Client:] " + sendMessage); // sending to server
                    writer.flush(); // flush the data coz auto-flush wont work on linux for some OS level reasons
                }
            }
        }).start();

        // receive from server
        while (true) {
            receiveMessage = receiveRead.readLine();

            if(receiveMessage != null) {
                System.out.println(receiveMessage);
            }
        }
    }

}