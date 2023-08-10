import java.io.*;
import java.net.*;
import java.util.*;

class A1 {
    public static void main(String[] args) {
        try {
            int i = 5511; // Port number starting point
            
            while (true) {
                // Create a server socket on the current port number
                ServerSocket ss = new ServerSocket(i++);
                
                // Accept an incoming connection on the server socket
                Socket s = ss.accept();
                
                // Get the input stream from the accepted socket
                InputStream is = s.getInputStream();
                
                // Create a DataInputStream to read data from the input stream
                DataInputStream dis = new DataInputStream(is);
                
                // Read and print the data received from the client
                System.out.print((String) dis.readUTF());
                System.out.println();
                
                // Create a scanner to read user input
                Scanner obj = new Scanner(System.in);
                
                // Create a socket to connect to localhost on the next port number
                Socket sc1 = new Socket("localhost", (i++));
                
                // Get the output stream from the socket
                OutputStream os1 = sc1.getOutputStream();
                
                // Create a DataOutputStream to write data to the output stream
                DataOutputStream dos1 = new DataOutputStream(os1);
                
                // Read a line of input from the user
                String m = obj.nextLine();
                
                // Write the input to the DataOutputStream
                dos1.writeUTF(m);
                
                // Close the streams and sockets
                dis.close();
                is.close();
                dos1.close();
                os1.close();
                
                // Check if the user input is "bye" to exit the loop
                if (m.equals("bye")) {
                    break;
                }
            }
        } catch (Exception ae) {
            // Exception handling (no specific action taken here)
        }
    }
}
