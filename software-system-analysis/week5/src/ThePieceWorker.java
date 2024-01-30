//Egemen Balli 8 Mar 2023
public class ThePieceWorker extends Employee{
    private int num_items;
    private double rate;

    public ThePieceWorker(String name, String surname, Date dateOfBirth, int employeeID, String position, String num_items, String rate) {
        super(name, surname, dateOfBirth, employeeID, position);
        this.num_items = Integer.parseInt(num_items);
        this.rate = Double.parseDouble(rate);
    }

    public double getSalary() {
        return num_items * rate;
    }

    @Override
    public String toString() {
        return super.getName() + "-" + super.getSurname() + "-" + getSalary();
    }
}
