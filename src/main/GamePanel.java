package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public static final int HEIGTH = 1000;
    public static final int WIDTH = 1000;

    // Size of panel
    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGTH));
        setBackground(Color.BLACK);
    }

    Thread gameThread;

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {
        long initialTime = System.nanoTime();
        long currentTime = 0;
        double delta = 0;
        final int FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / FPS;

        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta = (double) (currentTime - initialTime) / OPTIMAL_TIME;
            initialTime = currentTime;

            if (delta >= 1) {
                updateGame();
                repaint();
                delta = 0;

            }
        }
    }

    private void updateGame() {

    }

    public void paint(Graphics g) {
        super.paintComponent(g);
    }
}
