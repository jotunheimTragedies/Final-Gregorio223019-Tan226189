import java.awt.*;
import javax.swing.*;

public class GameFrame {
    private JFrame gameFrame; 
    private int width; 
    private int height; 
    private GameCanvas gameCanvas; 

    public GameFrame(int w, int h) {
        width = w; 
        height = h;
        gameFrame = new JFrame();
        gameCanvas = new GameCanvas(width, height);
    }

    public void setUpGUI() {
        Container cp = gameFrame.getContentPane();
        cp.add(gameCanvas, BorderLayout.CENTER);

        gameFrame.setTitle("[Change Title cause i cant find instructions from specs]");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.add(gameCanvas);
        gameFrame.pack();
        gameFrame.setVisible(true);
    }

}
