
import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class GameCanvas extends JComponent{
    private int width; 
    private int height; 
   
    public GameCanvas(int w, int h) {
        width = w; 
        height = h; 
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        // Background Properties
        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setPaint(Color.black);
        g2d.fill(background); 
    }
}
