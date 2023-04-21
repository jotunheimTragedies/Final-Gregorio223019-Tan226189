import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class GameFrame implements MouseListener {
    private int width;
    private int height;
    private JFrame gameFrame;
    private GameCanvas gameCanvas;

    private JLabel newGameLabel;
    private JLabel howPlayLabel;
    private ImageIcon newGameButton;
    private ImageIcon howPlayButton;

    private BombTimer bombTimer;

    // can add bombtimer here as an inner class cause it has a thread and a jlabel

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

        gameCanvas.gameState = gameCanvas.titleState;

    }

    public void setUpGUI() {
        Container cp = gameFrame.getContentPane();
        cp.add(gameCanvas, BorderLayout.CENTER);

        if (gameCanvas.gameState == gameCanvas.titleState) {
            System.out.println("setUpGUI");
            newGameLabel.setBounds(350, 550, 300, 100);
            howPlayLabel.setBounds(800, 550, 300, 100);
            gameFrame.add(newGameLabel);
            gameFrame.add(howPlayLabel);

        } else if (gameCanvas.gameState == gameCanvas.runningState) {
            System.out.println("setUpGUI");
            createBombTimer();
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
        JLabel currentLabel = (JLabel) e.getSource();
        if (currentLabel == newGameLabel) {
            System.out.println("Proceed to next gameState");
            if (gameCanvas.gameState == gameCanvas.titleState) {
                gameCanvas.gameState = gameCanvas.runningState;
                System.out.println(gameCanvas.gameState);
                System.out.println("beep from GameFrame");
                createBombTimer();
                gameCanvas.repaint();
                newGameLabel.setVisible(false);
                howPlayLabel.setVisible(false);
                gameFrame.repaint();

            }

        } else if (currentLabel == howPlayLabel) {
            System.out.println("Proceed to howPlayState");
            if (gameCanvas.gameState == gameCanvas.titleState) {
                gameCanvas.gameState = gameCanvas.howPlayState;
                System.out.println("rizz from GameFrame");
                gameCanvas.repaint();
                newGameLabel.setVisible(false);
                howPlayLabel.setVisible(false);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Unimplemented method
        // 'mousePressed'");
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

    private void createBombTimer() {
        bombTimer = new BombTimer();
        JPanel bombPanel = bombTimer.getTimerPanel();
        gameFrame.add(bombPanel, BorderLayout.CENTER);
    }
}
