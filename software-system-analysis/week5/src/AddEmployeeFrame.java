//Egemen Balli 8 Mar 2023
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddEmployeeFrame extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField YYYYTextField;
    private JTextField DDTextField;
    public JComboBox comboBox1;
    public JPanel panel1;
    private JRadioButton pieceWorkerRadioButton;
    private JRadioButton hourlyEmployeeRadioButton;
    private JRadioButton commissionEmployeeRadioButton;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JButton ADDButton;
    private JButton CANCELButton;
    public JPanel panel2;
    public JPanel panel3;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    public JPanel panel4;
    private int selectedType;

    private ArrayList<Employee> temp;

    public AddEmployeeFrame(ArrayList<Employee> employees, JTable table) {
        temp = employees;

        CANCELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        pieceWorkerRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hourlyEmployeeRadioButton.setSelected(false);
                commissionEmployeeRadioButton.setSelected(false);
                panel3.setVisible(true);
                panel4.setVisible(false);
                panel2.setVisible(false);
                selectedType = 0;
            }
        });
        hourlyEmployeeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pieceWorkerRadioButton.setSelected(false);
                commissionEmployeeRadioButton.setSelected(false);
                panel4.setVisible(true);
                panel3.setVisible(false);
                panel2.setVisible(false);
                selectedType = 1;
            }
        });
        commissionEmployeeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hourlyEmployeeRadioButton.setSelected(false);
                pieceWorkerRadioButton.setSelected(false);
                panel2.setVisible(true);
                panel3.setVisible(false);
                panel4.setVisible(false);
                selectedType = 2;
            }
        });
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String month;
                switch (comboBox1.getSelectedItem().toString()){
                    case "JANUARY":
                        month = "01";
                        break;
                    case "FEBRUARY":
                        month = "02";
                        break;
                    case "MARCH":
                        month = "03";
                        break;
                    case "APRIL":
                        month = "04";
                        break;
                    case "MAY":
                        month = "05";
                        break;
                    case "JUNE":
                        month = "06";
                        break;
                    case "JULY":
                        month = "07";
                        break;
                    case "AUGUST":
                        month = "08";
                        break;
                    case "SEPTEMBER":
                        month = "09";
                        break;
                    case "OCTOBER":
                        month = "10";
                        break;
                    case "NOVEMBER":
                        month = "11";
                        break;
                    case "DECEMBER":
                        month = "12";
                        break;
                    default:
                        month = "01";
                        break;
                }
                Date date = new Date(month, DDTextField.getText(), YYYYTextField.getText());
                switch (selectedType){
                    case 0:
                        temp.add(new ThePieceWorker(textField1.getText(), textField2.getText(), date, Integer.parseInt(textField3.getText()), textField4.getText(), textField11.getText(), textField12.getText()));
                        break;
                    case 1:
                        temp.add(new HourlyEmployee(textField1.getText(), textField2.getText(), date, Integer.parseInt(textField3.getText()), textField4.getText(), textField13.getText(), textField14.getText()));
                        break;
                    case 2:
                        temp.add(new CommissionEmployee(textField1.getText(), textField2.getText(), date, Integer.parseInt(textField3.getText()), textField4.getText(),textField7.getText(),textField8.getText(),textField9.getText(),textField10.getText()));
                        break;
                    default:
                        temp.add(new ThePieceWorker(textField1.getText(), textField2.getText(), date, Integer.parseInt(textField3.getText()), textField4.getText(), textField11.getText(), textField12.getText()));
                        break;
                }

                try {
                    FileWriter fileWriter = new FileWriter("employees.txt");
                    String st = "";
                    for (Employee i:temp) {
                        st += (i + "\n");
                    }
                    fileWriter.write(st);
                    fileWriter.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    ArrayList<String[]> arrayList = new ArrayList<>();
                    Scanner scanner = new Scanner(new File("employees.txt"));
                    while(scanner.hasNextLine()){
                        String[] arr = scanner.nextLine().split("-");
                        arrayList.add(arr);
                    }
                    table.setModel(new DefaultTableModel(listToArray(arrayList), new String[]{"First Name","Last Name","Salary"}));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public Object[][] listToArray(ArrayList<String[]> temp){
        Object forTable[][] = new Object[temp.size()][3];
        for (int i = 0; i < temp.size(); i++) {
            forTable[i][0] = temp.get(i)[0];
            forTable[i][1] = temp.get(i)[1];
            forTable[i][2] = temp.get(i)[2];
        }
        return forTable;
    }
}
