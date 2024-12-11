package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable {

    public static final int HEIGHT = 1000;
    public static final int WIDTH = 1000;
    Thread gameThread;
    GameBoard gameBoard = new GameBoard();
    private BufferedImage image;

    // Size of panel
    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    //Game Loop (maybe can be better ?)
    @Override
    public void run() {
        long initialTime = System.nanoTime();
        final int FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / FPS;

        while(gameThread != null) {
            long currentTime = System.nanoTime();
            double delta = (double) (currentTime - initialTime) / OPTIMAL_TIME;
            initialTime = currentTime;

            if (delta >= 1) {
                update();
                repaint(); // calls paint() to draw the chessboard
            }
        }
    }

    public void ImagePanel() throws IOException {
        image = ImageIO.read(new File("F:/THOMAS/Projet Code/Chess Game/res/piece/w_knight.png"));
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        //Transform Graphics g into Graphics2D because draw method use Graphics2D parameter
        Graphics2D g2d = (Graphics2D) g;

        gameBoard.draw(g2d);
        g.drawImage(image, 0, 0, null);

    }

    private void update() {
    }
}
