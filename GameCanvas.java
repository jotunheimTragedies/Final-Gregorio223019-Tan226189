
//import java.awt.image.BufferedImage;
//import java.io.IOException;
import java.awt.*;

//import javax.imageio.ImageIO;
//import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.geom.*;
import java.io.*;

public class GameCanvas extends JComponent{
    private int width; 
    private int height; 
   
    public int gameState;
    public final int titleState = 0; 
    public final int runningState = 1; 


    
    //private BufferedImage newGameButton;
    //private BufferedImage howPlayButton; 


    public GameCanvas(int w, int h) {
        width = w; 
        height = h; 
        setPreferredSize(new Dimension(width, height));
        gameState = titleState;

      


       

       /*  try {
            newGameButton = ImageIO.read(getClass().getResourceAsStream("ImageIcons/NF New Game Button.png"));
            howPlayButton = ImageIO.read(getClass().getResourceAsStream("ImageIcons/NF How Play Button.png"));
        } catch(IOException e) {
            e.printStackTrace();
        } */
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

            

           //g2d.drawImage(newGameButton, 350, 550, 300, 100, null);
           //g2d.drawImage(howPlayButton, 800, 550, 300, 100, null);
           //(Image img, int x, int y, int width, int height, ImageObserver observer)


            // if newGamebutton mouseClicked 
                // proceed to another game state
                

        }

        
    
       

        
    }
} 
