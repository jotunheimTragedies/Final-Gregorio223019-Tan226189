package BasicClasses;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.*;
import javax.swing.*;

public class GameCanvas extends JComponent implements KeyListener {
    private int width; 
    private int height;

    // Game States
    public int gameState; 
    public final int titleState = 0; 
    public final int howPlayState = 1; 
    public final int runningState = 2; 
    public final int gameOverState = 3; 
    public final int congratulationsState = 4; 

    private String[] titleOptions = {"Play Game", "Mechanics", "Quit"};
    private int currentTitleOption = 0; 

    private String BackButton = "< Back";
    private boolean backButtonPressed; 



    public GameCanvas(int w, int h) {
        width = w; 
        height = h; 
        setPreferredSize(new Dimension(w, h));

        addKeyListener(this);
        setFocusable(true);

        gameState = titleState; 
        backButtonPressed = false; 

    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        Rectangle2D.Double defaultBackground = new Rectangle2D.Double(0, 0, width, height);
        g2d.setPaint(Color.BLACK);
        g2d.fill(defaultBackground);

        if(gameState == titleState) {
            g2d.setFont(new Font("Times New Roman", Font.BOLD, 100));
            g2d.setColor(Color.white);
            g2d.drawString("Remain Speaking and No", 175, 180);
            g2d.drawString("Human Being Detonates", 190, 300);

            g2d.setFont(new Font("Times New Roman", Font.PLAIN, 55));
            g2d.drawString("Ateneo CS Edition", 535, 410);
            

            for(int i = 0; i < titleOptions.length; i++) {
                if(i == currentTitleOption) {
                    g2d.setColor(Color.red);
                } else {
                    g2d.setColor(Color.white);
                }
                
                g2d.setFont(new Font("Times New Roman", Font.PLAIN, 50));
                g2d.drawString(titleOptions[i], 620, 520 + i*90);
            }
        }

        if(gameState == howPlayState) {

            if(backButtonPressed == false) {
                g2d.setFont(new Font("Times New Roman", Font.PLAIN, 35));
                g2d.setPaint(Color.white);
                g2d.drawString(BackButton, 40, 50);
            } else if(backButtonPressed == true) {
                g2d.setFont(new Font("Times New Roman", Font.PLAIN, 35));
                g2d.setPaint(Color.red);
                g2d.drawString(BackButton, 40, 50);
            }
            
            g2d.setFont(new Font("Times New Roman", Font.BOLD, 75));
            g2d.setPaint(Color.white);
            g2d.drawString("Mechanics", 560, 110);
            g2d.drawRect(85, 140, 1300, 550);

            g2d.setFont(new Font("Times New Roman", Font.PLAIN, 30));
            g2d.setPaint(Color.white);
            g2d.drawString("1. Both players of the game will be shown the same bomb but with slight modifications. Additionally,", 105, 180);
            g2d.drawString("one player may have the manual, written in pseudocode, to disarm the other player’s module. Both", 95, 220);
            g2d.drawString("players must perform the tasks of both “Experts” and “Defusers.”", 95, 260);

            g2d.drawString("2. There are two types of modules. First, the Normal Modules are modules that can be disarmed. Second,", 95, 340);
            g2d.drawString("Needy Modules are modules that can not be disarmed and requires periodic attention by both players.", 95, 380);
            g2d.drawString("Otherwise, they will incur a penalty as seen above the timer.", 95, 420);

            g2d.drawString("3. All modules, Normal or Needy, can be disarmed in no particular order. The LED to the top right of a", 95, 500);
            g2d.drawString("Normal Module shall turn green once it has been successfully solved.", 95, 540);

            g2d.drawString("4. Thus, the goal of the game is to successfully defuse all of the modules on the bomb before the timer", 95, 620);
            g2d.drawString("runs out.", 95, 660);
 

        }

    }

    
    public int getCurrentState() {
        return gameState;
    }

// https://www.youtube.com/watch?v=BJ7fr9XwS2o
// https://www.youtube.com/watch?v=2ibxoX0E6AY
    @Override
    public void keyTyped(KeyEvent e) { 

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int getKeyPressed = e.getKeyCode();

        if(gameState == titleState) {
            if(getKeyPressed == KeyEvent.VK_DOWN) {
                currentTitleOption++; 
                repaint();
                if(currentTitleOption >= titleOptions.length) {
                    currentTitleOption = 0; 
                    repaint();
                }
               
            } else if(getKeyPressed == KeyEvent.VK_UP) {
                currentTitleOption--; 
                repaint();
                if(currentTitleOption < 0) {
                    currentTitleOption = titleOptions.length-1; 
                    repaint();
                }
                
    
            } else if(getKeyPressed == KeyEvent.VK_ENTER) {
                if(currentTitleOption == 0) {
                    gameState = runningState; 
                    repaint();
                } else if(currentTitleOption == 1) {
                    gameState = howPlayState;
                    repaint();
                } else if(currentTitleOption == 2) {
                    System.exit(0); 
                }
            } 

        } else if(gameState == howPlayState) {
            if(getKeyPressed == KeyEvent.VK_LEFT) {
                backButtonPressed = true; 
                repaint();
            } else if(getKeyPressed == KeyEvent.VK_ENTER) {
                gameState = titleState;
                repaint();
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
