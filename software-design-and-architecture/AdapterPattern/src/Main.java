//Egemen BALLI 4 Dec 2023
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MyFileReader excelReader = new ServiceAdapter(new ExcelReader());
        MyFileReader jsonReader = new ServiceAdapter(new JSONReader());
        MyFileReader txtReader = new TxtReader();

        System.out.println(excelReader.readFile("student.xls"));
        System.out.println(jsonReader.readFile("employees.json"));
        System.out.println(txtReader.readFile("example.txt"));
    }
}