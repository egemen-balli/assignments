//Egemen Balli 8 Mar 2023
public class CommissionEmployee extends Employee{
    private double baseSalary;
    private int num_items;
    private double item_price;
    private double commission_rate;
    public CommissionEmployee(String name, String surname, Date dateOfBirth, int employeeID, String position, String baseSalary, String num_items, String item_price, String commission_rate) {
        super(name, surname, dateOfBirth, employeeID, position);
        this.baseSalary = Double.parseDouble(baseSalary);
        this.num_items = Integer.parseInt(num_items);
        this.item_price = Double.parseDouble(item_price);
        this.commission_rate = Double.parseDouble(commission_rate);
    }

    public double getSalary() {
        return baseSalary + ( num_items * ( item_price * ( commission_rate * .01)));
    }

    @Override
    public String toString() {
        return super.getName() + "-" + super.getSurname() + "-" + getSalary();
    }
}
