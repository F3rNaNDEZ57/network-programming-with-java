package TCP;

import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class client {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);
            System.out.println("Connected to the server");

            // Create an input and output stream to the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send data to the server
            out.println("Hello from the client");

            // Receive data from the server
            String message = in.readLine();
            System.out.println("Server says: " + message);

            //Close the socket
            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
