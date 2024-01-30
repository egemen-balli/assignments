//Egemen BALLI 4 Dec 2023
import java.io.IOException;

public class ServiceAdapter implements MyFileReader {
    Service s;

    public ServiceAdapter(Service s) {
        this.s = s;
    }

    @Override
    public String readFile(String filePath) throws IOException {
        return s.readDataFile(filePath);
    }
}