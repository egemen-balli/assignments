//Egemen BALLI 4 Dec 2023
import java.io.*;

public class TxtReader implements MyFileReader{
    @Override
    public String readFile(String filePath) throws IOException {
        File file = new File("example.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st, stFinal = "";
        while ((st = br.readLine()) != null){
            stFinal += st + "\n";
        }

        return stFinal;
    }
}
