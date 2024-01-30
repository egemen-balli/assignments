//Egemen BALLI 20 Nov 2023
import java.util.ArrayList;
import java.util.Scanner;

public class MusicPlayer {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> playlist = new ArrayList<>();
    private static MusicPlayer uniqueInstance;
    private static String password = "123456";

    private MusicPlayer(){
        showMenu();
    }

    public static MusicPlayer getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new MusicPlayer();
        }
        return uniqueInstance;
    }

    public void showMenu(){
        System.out.println("===== Music Player Menu =====\n" +
                "1. Play MP3\n" +
                "2. Play FLAC\n" +
                "3. Play AAC\n" +
                "4. Add to Playlist\n" +
                "5. Remove from Playlist\n" +
                "6. Show Playlist\n" +
                "7. Authenticate User\n" +
                "0. Exit");
        int input = scanner.nextInt();
        switch (input){
            case 1:
                playMP3();
                showMenu();
                break;
            case 2:
                playFLAC();
                showMenu();
                break;
            case 3:
                playAAC();
                showMenu();
                break;
            case 4:
                addToPlaylist();
                showMenu();
                break;
            case 5:
                removeFromPlaylist();
                showMenu();
                break;
            case 6:
                showPlaylist();
                showMenu();
                break;
            case 7:
                authenticateUser();
                showMenu();
                break;
            case 0:
                exit();
                break;
            default:
                exit();
                break;
        }
    }

    public void playMP3(){
        System.out.println("Playing MP3");
    }

    public void playFLAC(){
        System.out.println("Playing FLAC");
    }

    public void playAAC(){
        System.out.println("Playing AAC");
    }

    public void addToPlaylist(){
        String st = scanner.next();
        playlist.add(st);
    }

    public void removeFromPlaylist(){
        String st = scanner.next();
        playlist.remove(st);
    }

    public void showPlaylist(){
        for(String e:playlist){
            System.out.println(e);
        }
    }

    public void authenticateUser(){
        String st = scanner.next();
        if(password.equals(st)){
            System.out.println("Correct");
        }else{
            System.out.println("Incorrect");
        }
    }

    public void exit(){
        return;
    }
}
