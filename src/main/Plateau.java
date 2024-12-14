package main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Plateau extends JPanel implements Runnable {

    public static final int HEIGHT = 800;
    public static final int WIDTH = 1000; // blank space on the right of the window to show some information
    Thread gameThread;
    Piece piece = new Piece();
    Mouse mouse = new Mouse();


    // characteristics of panel
    public Plateau() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Transform Graphics g into Graphics2D because draw method use Graphics2D parameter
        Graphics2D g2d = (Graphics2D) g;

        //Draw the chess board
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    g2d.setColor(new Color(139, 69, 19));
                } else {
                    g2d.setColor(new Color(205, 133, 63));
                }
                g2d.fillRect(col * 100, row * 100, 100, 100);
            }
        }


        //draw chess pieces
        try {
            piece.draw(g2d);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        final long OPTIMAL_TIME = 100000 / FPS;

        while(gameThread != null) {
            long currentTime = System.nanoTime();
            double delta = (double) (currentTime - initialTime) / OPTIMAL_TIME;
            initialTime = currentTime;

            if (delta*1000 >= 1) {
                update();
                repaint(); // calls paintComponent() to draw the chessboard
            }
        }
    }


    private void update() {
        if(mouse.pressed) {
            mouse.x = getX();
            mouse.y = getY();
            System.out.println("x" + mouse.x + "y" + mouse.y);
        }
    }
}

