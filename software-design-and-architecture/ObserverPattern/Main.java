//Egemen BALLI 23 Oct 2023
public class Main {
    public static void main(String[] args) {
        Subject videoStreamingService = new VideoStreamingService("Veritasium");
        Subject videoStreamingService2 = new VideoStreamingService("Minute Physics");
        Observer elena = new Subscriber(videoStreamingService, "Elena");
        Observer derek = new Subscriber(videoStreamingService, "Derek");
        Observer gale = new PremiumSubscriber(videoStreamingService2, "Gale");
        Observer lane = new PremiumSubscriber(videoStreamingService2, "Lane");

        videoStreamingService.notifyObservers();
        videoStreamingService2.notifyObservers();

    }
}
