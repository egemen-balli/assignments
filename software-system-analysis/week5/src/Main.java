//Egemen Balli 8 Mar 2023
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();

        mainFrame.setContentPane(mainFrame.panel1);
        mainFrame.setSize(600,500);
        mainFrame.setVisible(true);
    }
}
