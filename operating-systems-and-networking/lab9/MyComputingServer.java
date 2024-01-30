//Egemen Balli 25 Dec 2023
import java.io.*;
import java.net.*;

public class MyComputingServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client;

        // Default port number we are going to use
        int portnumber = 1234;
        if (args.length >= 1){
            portnumber = Integer.parseInt(args[0]);
        }

        // Create Server side socket
        try {
            server = new ServerSocket(portnumber);
        } catch (IOException ie) {
            System.out.println("Cannot open socket." + ie);
            System.exit(1);
        }
        System.out.println("ServerSocket is created " + server);

        // Wait for the data from the client and reply
        while(true) {
            try {
                // Listens for a connection to be made to
                // this socket and accepts it. The method blocks until
                // a connection is made
                System.out.println("Waiting for connect request...");
                client = server.accept();

                System.out.println("Connect request is accepted...");
                String clientHost = client.getInetAddress().getHostAddress();
                int clientPort = client.getPort();
                System.out.println("Client host = " + clientHost + " Client port = " + clientPort);

                // Read data from the client
                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new
                        InputStreamReader(clientIn));
                String msgFromClient = br.readLine();
                System.out.println("Message received from client = " + msgFromClient);

                // Send response to the client
                if (msgFromClient != null) {
                    OutputStream clientOut = client.getOutputStream();
                    PrintWriter pw = new PrintWriter(clientOut, true);
                    String ansMsg = msgFromClient;

                    int key = 5;
                    int spaceCount = 0;
                    for (char c : ansMsg.toCharArray()) {
                        if (c == ' ') {
                            spaceCount++;
                        }
                    }

                    if(spaceCount != 0) {
                        key = spaceCount * 3;
                    }

                    System.out.println("Encrypted String is: " + ansMsg);

                    System.out.println("Decrypted String is: " + decrypt(ansMsg, key));
                    pw.println(decrypt(ansMsg, key));
                }

                // Close sockets
                if (msgFromClient != null) {
                    server.close();
                    client.close();
                    break;
                }
            } catch (IOException ie) {
            }
        }
    }

    public static String decrypt(String str, int key) {
        String decrypted = "";
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                c = c - (key % 26);
                if (c < 'A') {
                    c = c + 26;
                }
            } else if (Character.isLowerCase(c)) {
                c = c - (key % 26);
                if (c < 'a') {
                    c = c + 26;
                }
            }
            decrypted += (char) c;
        }
        return decrypted;
    }
}