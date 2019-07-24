import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.IOException;

public class Server {

    private static final int PORT = 7000;

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is up and listening to port: " + PORT);

        Socket socket = serverSocket.accept();
        BufferedReader msgRead = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String receiveMessage;

        // create a thread for sending message to client while the main thread is receiving from the client
        new Thread(new Runnable() {
            @Override
            public void run() {
                String sendMessage = null;

                while(true) {
                    try {
                        sendMessage = msgRead.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    writer.println("[Server:] " + sendMessage);
                    writer.flush(); // coz auto-flushable doesn't work on linux for some reason OS level reasons
                }
            }
        }).start();

        // receive from client
        while(true) {
            if ((receiveMessage = receiveRead.readLine()) != null) {
                System.out.println(receiveMessage);
            }
        }
    }
}
