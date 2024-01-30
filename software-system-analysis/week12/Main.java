//Egemen Balli 25 April 2023
import javax.swing.*;
import java.util.TimerTask;
import java.util.Timer;

public class Main {
    static int count = 0;
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JProgressBar jb = new JProgressBar(0,100);
        jb.setBounds(100,100,160,30);
        jb.setValue(0);
        jb.setStringPainted(true);
        jFrame.add(jb);
        jFrame.setSize(400,400);
        jFrame.setLayout(null);
        jFrame.setVisible(true);


        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                count++;
                if (count == 100) timer.cancel();
                jb.setValue(count);
            }
        };
        timer.schedule(timerTask,0,100);
    }
}
