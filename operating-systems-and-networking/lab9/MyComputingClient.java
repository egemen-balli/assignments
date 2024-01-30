//Egemen Balli 25 Dec 2023
import java.io.*;
import java.net.*;
public class MyComputingClient {

    public static void main(String args[]) {
        Socket client = null;

        // Default port number we are going to use
        int portnumber = 1234;
        if (args.length >= 1){
            portnumber = Integer.parseInt(args[0]);
        }

        for (int i=0; i <10; i++) {
            try {
                // Create a client socket
                client = new Socket(InetAddress.getLocalHost(), portnumber);
                System.out.println("Client socket is created " + client);

                // Create an output stream of the client socket
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);

                // Create an input stream of the client socket
                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new
                        InputStreamReader(clientIn));

                // Create BufferedReader for a standard input
                BufferedReader stdIn = new BufferedReader(new
                        InputStreamReader(System.in));

                System.out.println("Enter the String:");
                String string = stdIn.readLine().trim();
                // Read data from standard input device and write it
                // to the output stream of the client socket.

                int key = 5;
                int spaceCount = 0;
                for (char c : string.toCharArray()) {
                    if (c == ' ') {
                        spaceCount++;
                    }
                }

                if(spaceCount != 0) {
                    key = spaceCount * 3;
                }

                pw.println(encrypt(string, key));

                // Read data from the input stream of the client socket.
                System.out.println("Response: " + br.readLine());

                pw.close();
                br.close();
                client.close();
            } catch (IOException ie) {
                System.out.println("I/O error " + ie);
            }
        }
    }

    public static String encrypt(String str, int key) {
        String encrypted = "";
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                c = c + (key % 26);
                if (c > 'Z') {
                    c = c - 26;
                }
            } else if (Character.isLowerCase(c)) {
                c = c + (key % 26);
                if (c > 'z') {
                    c = c - 26;
                }
            }
            encrypted += (char) c;
        }
        return encrypted;
    }
}
