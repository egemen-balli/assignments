//Egemen Balli 28 Feb 2023
import javax.swing.*;
import java.util.ArrayList;

public interface BaseController {
    void validate(String st1, String st2, String st3) throws Exception;
    void create(String st1, String st2, String st3) throws Exception;

    ArrayList<String> showInput(String textField1, String textField2, String textField3);
    DefaultListModel<String> showData();
}
