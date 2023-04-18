import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class GameFrame implements MouseListener{
    private int width;
    private int height; 
    private JFrame gameFrame; 
    private GameCanvas gameCanvas;

    private JLabel newGameLabel;
    private JLabel howPlayLabel; 
    private ImageIcon newGameButton;
    private ImageIcon howPlayButton; 

    public GameFrame(int w, int h) {
        width = w; 
        height = h; 
        gameFrame = new JFrame();
        gameCanvas = new GameCanvas(width, height);

        newGameLabel = new JLabel();
        newGameLabel.addMouseListener(this);
        howPlayLabel = new JLabel();
        howPlayLabel.addMouseListener(this);


        newGameButton = new ImageIcon("ImageIcons/[NF] New Game Button.png");
        howPlayButton = new ImageIcon("ImageIcons/[NF] How Play Button.png");

        newGameLabel.setIcon(newGameButton);
        howPlayLabel.setIcon(howPlayButton);
        

    }

    public void setUpGUI() {
        Container cp = gameFrame.getContentPane();
        cp.add(gameCanvas, BorderLayout.CENTER);

        if(gameCanvas.gameState == gameCanvas.titleState) {
            newGameLabel.setBounds(350, 550, 300, 100);
            howPlayLabel.setBounds(800, 550, 300, 100);
            gameFrame.add(newGameLabel);
            gameFrame.add(howPlayLabel);
            
        }

        

        gameFrame.setTitle("Remain Speaking and No Human Being Detonates");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.add(gameCanvas);
        gameFrame.pack();
        gameFrame.setVisible(true);

        
    }
    
    // https://stackoverflow.com/questions/35448604/one-mouselistener-for-many-jlabel-components
    // https://www.youtube.com/watch?v=jptf1Wd_omw
    // https://www.youtube.com/watch?v=_SJU99LU1IQ - use to continue 
    @Override 
    public void mouseClicked(MouseEvent e) {
        JLabel currentLabel = (JLabel)e.getSource();
        if(currentLabel == newGameLabel) {
            System.out.println("Proceed to next gameState");
            System.out.println("bitch better have my money");
        } else if(currentLabel == howPlayLabel) {
            System.out.println("Proceed to howPlayState");
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
        //throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
