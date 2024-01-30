//Egemen BALLI 30 Oct 2023
public class HighEndGPU extends ResourceDecorator{
    Server server;

    public HighEndGPU(Server server){
        this.server = server;
    }

    @Override
    public String getDescription() {
        return server.getDescription() + " with High-End GPU";
    }

    @Override
    double cost() {
        return 0.022890 + server.cost();
    }
}
