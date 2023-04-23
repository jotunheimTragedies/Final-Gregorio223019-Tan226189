package BasicClasses;

import java.awt.*;
import javax.swing.*;

public class GameFrame {
    private int width; 
    private int height; 
    private JFrame gameFrame; 
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

        gameFrame.setTitle("No Human Being Detonates");
        gameCanvas.setPreferredSize(new Dimension(width, height));
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);
        
    }

}   
