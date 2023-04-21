import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;
import java.util.Timer;

public class GameCanvas extends JComponent{
    private int width; 
    private int height; 
   
    //private BombTimer timerBomb; 

    public int gameState;
    public final int titleState = 0; 
    public final int howPlayState = 1; 
    public final int runningState = 2;
    
    private BombTimer bombTimer; 
    public GameCanvas(int w, int h) {
        width = w; 
        height = h; 
        setLayout(new GridLayout(2, 3));
  
        setPreferredSize(new Dimension(width, height));
        gameState = runningState;

        if(gameState == runningState) {
            System.out.println("GameCanvas beep");
            
        }
    
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        Rectangle2D.Double defaultBackground = new Rectangle2D.Double(0, 0, width, height);
        g2d.setPaint(Color.black);
        g2d.fill(defaultBackground);

        if(gameState == titleState) {
            g2d.setFont(new Font("Times New Roman", Font.BOLD, 100));
            g2d.setPaint(Color.white);
            g2d.drawString("Remain Speaking and No", 175, 180);
            g2d.drawString("Human Being Detonates", 190, 300);

            g2d.setFont(new Font("Times New Roman", Font.PLAIN, 55));
            g2d.drawString("Ateneo CS Edition", 550, 445);

        } else if(gameState == howPlayState) {
            System.out.println("[howPlayState] beep boop from GameCanvas");
            // statements will only be printed when i call repaint()
        
        
        } else if(gameState == runningState) {
            System.out.println("[runningState] beep boop from GameCanvas");
            
        }     
    }
} 