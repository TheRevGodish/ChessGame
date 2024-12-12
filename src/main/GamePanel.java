package main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable {

    public static final int HEIGHT = 800;
    public static final int WIDTH = 1000;
    Thread gameThread;
    GameBoard gameBoard = new GameBoard();
    Piece piece = new Piece();
    Mouse mouse = new Mouse();


    // characteristics of panel
    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
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

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Transform Graphics g into Graphics2D because draw method use Graphics2D parameter
        Graphics2D g2d = (Graphics2D) g;

        //Draw the chess board
        gameBoard.draw(g2d);

        //draw chess pieces
        try {
            piece.draw(g2d);
        } catch (IOException e) {
            throw new RuntimeException(e);
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

