//Egemen BALLI 30 Oct 2023
public class HighMemory extends ResourceDecorator {
    Server server;

    public HighMemory(Server server){
        this.server = server;
    }

    @Override
    public String getDescription() {
        return server.getDescription() + " with High Memory,";
    }

    @Override
    double cost() {
        return 0.003067 + server.cost();
    }
}
