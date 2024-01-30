//Egemen Balli 8 Mar 2023
abstract public class Employee extends Person{
    private int employeeID;
    private String position;

    public Employee(String name, String surname, Date dateOfBirth, int employeeID, String position) {
        super(name, surname, dateOfBirth);
        this.employeeID = employeeID;
        this.position = position;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getPosition() {
        return position;
    }

    abstract double getSalary();
}
