// To Do 
    // Create a JPanel to add: 
        // JLabel for the timer following ryisnow's tutorial
        // Other graphics components such as: 
            // strike counter 
                // if there is a strike draw an X 
            // Circle looking thing 

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class BombTimer extends JComponent {
    private JPanel timerPanel;
    private JLabel timerLabel; 

    private Timer timeLeft; 
    private DecimalFormat decimalFormat; 
    private int minutesLeft; 
    private int secondsLeft; 
    private String formattedMinutes; 
    private String formattedSeconds; 

    public BombTimer() {
        timerPanel = new JPanel();
        timerPanel.setLayout(new BorderLayout()); // add timerLabel to the center
        timerPanel.setBounds(0, 0, 350, 350);
        timerPanel.setBackground(Color.pink);

        timerLabel = new JLabel();
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        timerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        timerLabel.setForeground(Color.black);

        timerPanel.add(timerLabel, BorderLayout.CENTER);
        timerPanel.setVisible(true);

        decimalFormat = new DecimalFormat("00");
        timerLabel.setText("3:00");
        minutesLeft = 5; 
        secondsLeft = 0; 
        setUpCountdownTimer();
        timeLeft.start();

    }

    public void setUpCountdownTimer() {
        timeLeft = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                secondsLeft--; 
                formattedMinutes = decimalFormat.format(minutesLeft);
                formattedSeconds = decimalFormat.format(secondsLeft);
                timerLabel.setText(formattedMinutes + ":" + formattedSeconds);

                if(secondsLeft == -1) {
                    secondsLeft = 59; 
                    minutesLeft--; 

                    formattedMinutes = decimalFormat.format(minutesLeft);
                    formattedSeconds = decimalFormat.format(secondsLeft);
                    timerLabel.setText(formattedMinutes + ":" + formattedSeconds);
                }

                if(minutesLeft == 0 && secondsLeft == 0) {
                    //bombExplodes();
                    timeLeft.stop();
                }
            }

        });
    }

    public JPanel getTimerPanel() {
        return timerPanel;
    }
      
}