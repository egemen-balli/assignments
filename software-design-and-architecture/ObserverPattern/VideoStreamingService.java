//Egemen BALLI 23 Oct 2023
import java.util.ArrayList;

public class VideoStreamingService implements Subject{
    private ArrayList observers;
    private String channelName;

    public VideoStreamingService(String channelName){
        this.channelName = channelName;
        observers = new ArrayList();
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i >= 0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for(int i = 0; i < observers.size(); i++){
            Observer observer = (Observer) observers.get(i);
            observer.update(channelName);
        }
    }

    public void videoUploaded(){
        notifyObservers();
    }

    public void setChannelName(String channelName){
        this.channelName = channelName;
        videoUploaded();
    }
}
