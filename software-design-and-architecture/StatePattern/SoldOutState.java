//Egemen BALLI 10 Dec 2023
public class SoldOutState implements State{
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("No quarter inserted");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but no gumballs left");
    }

    @Override
    public void dispense() {
        System.out.println("No gumballs left");
    }
}
