//Egemen Balli 21 Feb 2023

import java.util.Random;

public class U2 extends Rocket{
    private double expChance;
    private double crashChance;
    Random rnd = new Random();
    public U2() {
        super(36000, 58000, 12000);
        expChance = (36000/58000)*4;
        crashChance = (36000/58000)*8;
    }

    @Override
    public boolean launch() {
        return !(rnd.nextDouble(1) >= expChance);
    }

    @Override
    public boolean land() {
        return !(rnd.nextDouble(1) >= crashChance);
    }
}
