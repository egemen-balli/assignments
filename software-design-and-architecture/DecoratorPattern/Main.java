//Egemen BALLI 30 Oct 2023
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Server server;
        System.out.println("Welcome to the Data Center Configuration Tool!\nSelect Server Type:\n1. High-End CPU\n2. Normal CPU");
        int opt1 = scanner.nextInt();
        System.out.println("Select Memory Type:\n1. High Memory\n2. Low Memory");
        int opt2 = scanner.nextInt();
        System.out.println("Select GPU Type:\n1. High-End GPU\n2. Basic GPU");
        int opt3 = scanner.nextInt();

        if(opt1 == 1) {
            server = new HighEndCPU();
            if(opt2 == 1) server = new HighMemory(server);
            else if (opt2 == 2) server = new LowMemory(server);

            if(opt3 == 1) server = new HighEndGPU(server);
            else if (opt3 == 2) server = new BasicGPU(server);

            System.out.println("Total Price: $" + server.cost());
            System.out.println("Description: " + server.getDescription());
        }
        else if (opt1 == 2) {
            server = new NormalCPU();
            if(opt2 == 1) server = new HighMemory(server);
            else if (opt2 == 2) server = new LowMemory(server);

            if(opt3 == 1) server = new HighEndGPU(server);
            else if (opt3 == 2) server = new BasicGPU(server);

            System.out.println("Total Price: $" + server.cost());
            System.out.println("Description: " + server.getDescription());
        }
    }
}