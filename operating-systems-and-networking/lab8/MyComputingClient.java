//Egemen BALLI 18 Dec 2023
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

                System.out.println("Enter two numbers.");

                // Read data from standard input device and write it
                // to the output stream of the client socket.
                String number1 = stdIn.readLine().trim();
                String number2 = stdIn.readLine().trim();

                System.out.println("Choose an operation.\n" +
                        "1.+\n" + "2.-\n" + "3.*\n" + "4./\n");
                String operation = stdIn.readLine().trim();
                pw.println(number1 + "," + number2 + "," + operation);

                // Read data from the input stream of the client socket.
                System.out.println("Result = " + br.readLine());

                pw.close();
                br.close();
                client.close();
            } catch (IOException ie) {
                System.out.println("I/O error " + ie);
            }
        }
    }
}
