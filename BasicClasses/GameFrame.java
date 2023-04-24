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

    public void setUpModules() {
        Thread setUpModulesThread = new Thread(new SetUpModules());
        setUpModulesThread.start();
    }

    private class SetUpModules implements Runnable {
        @Override
        public void run() {
            // Determine how to get currentCanvasState without it becoming an infinte loop
            // Need it not to be an infinite loop so that I can add the modules into
            // GameFrame
            // we're planning on extending JPanel on all our other module components
            // module componenets are our composite shape classes

            while (true) {
                int currentCanvasState = gameCanvas.getCurrentState();
                if (currentCanvasState == gameCanvas.titleState) {
                    System.out.println("He like how i ride it"); // fak u

                }

                if (currentCanvasState == gameCanvas.howPlayState) {
                    System.out.println("Hop on the dick, I made him get excited"); // what the hell
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
