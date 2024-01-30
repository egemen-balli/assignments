//Egemen Balli 2 May 2023
import java.awt.EventQueue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import javax.swing.*;
import java.util.Timer;

public class SwingDateTimeWarning {
    JFrame frame;
    LocalDateTime enteredDateTime;
    Timer timer;

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            SwingDateTimeWarning window = new SwingDateTimeWarning();
            window.frame.setVisible(true);
        });
    }

    public SwingDateTimeWarning(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        enteredDateTime = LocalDateTime.parse("2023-05-02 15:44:50",formatter);

        frame = new JFrame("DateTime Warning");
        frame.setBounds(100,100,400,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                LocalDateTime currDateTime = LocalDateTime.now();
                if(currDateTime.compareTo(enteredDateTime) >= 0){
                    try{
                        JOptionPane.showMessageDialog(null, "Warning: The entered date and time has reached.", "WARNING",JOptionPane.WARNING_MESSAGE);
                        timer.cancel();
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
}
