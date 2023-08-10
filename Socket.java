import java.net.*;
import java.io.*;
import java.util.*;

class A {
    public static void main(String[] args) throws Exception {
        
        Scanner obj = new Scanner(System.in);
        int i = 5511; // Port number starting point
        
        while (true) {
            // Create a socket to connect to localhost on the current port number
            Socket sc = new Socket("localhost", (i++));
            
            // Get the output stream from the socket
            OutputStream os = sc.getOutputStream();
            
            // Create a DataOutputStream to write data to the output stream
            DataOutputStream dos = new DataOutputStream(os);
            
            // Read a line of input from the user
            String m1 = obj.nextLine();
            
            // Write the input to the DataOutputStream
            dos.writeUTF(m1);

            // Create a new server socket on the next port number
            ServerSocket ss1 = new ServerSocket(i++);
            
            // Accept an incoming connection on the server socket
            Socket s1 = ss1.accept();
            
            // Get the input stream from the accepted socket
            InputStream is1 = s1.getInputStream();
            
            // Create a DataInputStream to read data from the input stream
            DataInputStream dis1 = new DataInputStream(is1);
            
            // Read and print the data received from the client
            System.out.print((String) dis1.readUTF());
            System.out.println();
            
            // Close the streams and sockets
            os.close();
            dos.close();
            dis1.close();
            is1.close();
            
            // Check if the user input is "bye" to exit the loop
            if (m1.equals("bye")) {
                break;
            }
        }
    }
}
