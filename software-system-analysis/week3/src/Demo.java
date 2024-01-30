//Egemen Balli 21 Feb 2023

public class Demo {
    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation();
        System.out.println("U1 Rockets Total Cost = " + simulation.runSimulation(simulation.loadU1(simulation.loadItems("phase-1.txt"))));
        System.out.println("U2 Rockets Total Cost = " + simulation.runSimulation(simulation.loadU2(simulation.loadItems("phase-2.txt"))));
    }
}
