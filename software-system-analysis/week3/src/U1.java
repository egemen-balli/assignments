//Egemen Balli 21 Feb 2023
import java.util.Random;
import java.util.random.*;
public class U1 extends Rocket{
    private double expChance;
    private double crashChance;
    Random rnd = new Random();
    public U1() {
        super(20000, 36000, 10000);
        expChance = (20000/36000)*5;
        crashChance = 20000/36000;
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
