//Egemen BALLI 30 Oct 2023
public class BasicGPU extends ResourceDecorator{
    Server server;

    public BasicGPU(Server server){
        this.server = server;
    }

    @Override
    public String getDescription() {
        return server.getDescription() + " with Basic GPU";
    }

    @Override
    double cost() {
        return 0.006867 + server.cost();
    }
}
