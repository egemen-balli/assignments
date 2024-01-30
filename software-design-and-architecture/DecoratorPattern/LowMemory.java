//Egemen BALLI 30 Oct 2023
public class LowMemory extends ResourceDecorator{
    Server server;

    public LowMemory(Server server){
        this.server = server;
    }

    @Override
    public String getDescription() {
        return server.getDescription() + " with Low Memory,";
    }

    @Override
    double cost() {
        return 0.000920 + server.cost();
    }
}
