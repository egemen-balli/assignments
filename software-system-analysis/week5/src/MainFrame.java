//Egemen Balli 8 Mar 2023
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;

public class MainFrame extends JFrame{
    private JTable table1;
    public JPanel panel1;
    private JRadioButton allRadioButton;
    private JRadioButton pieceWorkerRadioButton;
    private JRadioButton hourlyEmployeeRadioButton;
    private JRadioButton commissionEmployeeRadioButton;
    private JButton SEARCHButton;
    private JTextField textField1;
    private JButton ADDEMPLOYEEButton;
    private JButton EXITButton;

    private ArrayList<Employee> employees = new ArrayList<>();

    public MainFrame() throws IOException {
        ADDEMPLOYEEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmployeeFrame addEmployeeFrame = new AddEmployeeFrame(employees, table1);
                addEmployeeFrame.setContentPane(addEmployeeFrame.panel1);
                addEmployeeFrame.setSize(500,500);
                addEmployeeFrame.panel2.setVisible(false);
                addEmployeeFrame.panel3.setVisible(true);
                addEmployeeFrame.panel4.setVisible(false);
                addEmployeeFrame.comboBox1.addItem("JANUARY");
                addEmployeeFrame.comboBox1.addItem("FEBRUARY");
                addEmployeeFrame.comboBox1.addItem("MARCH");
                addEmployeeFrame.comboBox1.addItem("APRIL");
                addEmployeeFrame.comboBox1.addItem("MAY");
                addEmployeeFrame.comboBox1.addItem("JUNE");
                addEmployeeFrame.comboBox1.addItem("JULY");
                addEmployeeFrame.comboBox1.addItem("AUGUST");
                addEmployeeFrame.comboBox1.addItem("SEPTEMBER");
                addEmployeeFrame.comboBox1.addItem("OCTOBER");
                addEmployeeFrame.comboBox1.addItem("NOVEMBER");
                addEmployeeFrame.comboBox1.addItem("DECEMBER");
                addEmployeeFrame.setVisible(true);
            }
        });
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        allRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hourlyEmployeeRadioButton.setSelected(false);
                commissionEmployeeRadioButton.setSelected(false);
                pieceWorkerRadioButton.setSelected(false);
                listTable(employees);
            }
        });
        hourlyEmployeeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pieceWorkerRadioButton.setSelected(false);
                commissionEmployeeRadioButton.setSelected(false);
                allRadioButton.setSelected(false);
                ArrayList<Employee> temp = new ArrayList<>();
                for (Employee i:employees) {
                    if(i.getClass() == HourlyEmployee.class){
                        temp.add(i);
                    }
                }
                listTable(temp);
            }
        });
        commissionEmployeeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hourlyEmployeeRadioButton.setSelected(false);
                pieceWorkerRadioButton.setSelected(false);
                allRadioButton.setSelected(false);
                ArrayList<Employee> temp = new ArrayList<>();
                for (Employee i:employees) {
                    if(i.getClass() == CommissionEmployee.class){
                        temp.add(i);
                    }
                }
                listTable(temp);
            }
        });
        pieceWorkerRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hourlyEmployeeRadioButton.setSelected(false);
                commissionEmployeeRadioButton.setSelected(false);
                allRadioButton.setSelected(false);
                ArrayList<Employee> temp = new ArrayList<>();
                for (Employee i:employees) {
                    if(i.getClass() == ThePieceWorker.class){
                        temp.add(i);
                    }
                }
                listTable(temp);
            }
        });
        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isFound = false;
                for (Employee i:employees) {
                    if(i.getEmployeeID() == Integer.parseInt(textField1.getText())){
                        SearchResult searchResult = new SearchResult();
                        searchResult.setContentPane(searchResult.panel1);
                        searchResult.setSize(300,300);
                        searchResult.label1.setText(Integer.toString(i.getEmployeeID()));
                        searchResult.label2.setText(i.getName() + i.getSurname());
                        searchResult.label3.setText(i.getDateOfBirth().month+"/"+i.getDateOfBirth().day+"/"+i.getDateOfBirth().year+"  Age: "+(Year.now().getValue()-Integer.parseInt(i.getDateOfBirth().year))+" years old");
                        searchResult.label4.setText(i.getPosition());
                        searchResult.label5.setText(Double.toString(i.getSalary()));
                        searchResult.setVisible(true);
                        isFound = true;
                    }
                }
                if(isFound == false){
                    NotFound notFound = new NotFound();
                    notFound.setContentPane(notFound.panel1);
                    notFound.setSize(200,120);
                    notFound.setVisible(true);
                }
            }
        });
    }

    public void listTable(ArrayList<Employee> temp){
        Object forTable[][] = new Object[temp.size()][3];
        for (int i = 0; i < temp.size(); i++) {
            forTable[i][0] = temp.get(i).getName();
            forTable[i][1] = temp.get(i).getSurname();
            forTable[i][2] = temp.get(i).getSalary();
        }
        table1.setModel(new DefaultTableModel(forTable, new String[]{"First Name","Last Name","Salary"}));
    }
}
