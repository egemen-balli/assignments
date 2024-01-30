//Egemen Balli 8 Mar 2023
public class HourlyEmployee extends Employee{
    private double hour;
    private double rate;

    public HourlyEmployee(String name, String surname, Date dateOfBirth, int employeeID, String position, String hour, String rate) {
        super(name, surname, dateOfBirth, employeeID, position);
        this.hour = Double.parseDouble(hour);
        this.rate = Double.parseDouble(rate);
    }


    public double getSalary() {
        return hour * rate;
    }

    @Override
    public String toString() {
        return super.getName() + "-" + super.getSurname() + "-" + getSalary();
    }
}
