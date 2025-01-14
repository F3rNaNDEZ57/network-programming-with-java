package TCP;

import java.net.ServerSocket;
import  java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class server {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new java.net.ServerSocket(8000);
            System.out.println("Server started at " + new java.util.Date());

            // Listen for a connection request
            Socket socket = serverSocket.accept();

            // Create data input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Receive data from the client
            String message = in.readLine();
            System.out.println("Client says: " + message);

            // Send data to the client
            out.println("Hello from the server");

            // Close the socket
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
