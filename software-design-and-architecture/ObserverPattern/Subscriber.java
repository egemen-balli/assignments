//Egemen BALLI 23 Oct 2023
public class Subscriber implements Observer{
    private String username;

    public Subscriber(Subject subject, String name) {
        this.username = name;
        subject.registerObserver(this);
    }

    @Override
    public void update(String channelName) {
        System.out.println("Wake up " + username + "!! " + channelName + " uploaded new video.");
    }
}
