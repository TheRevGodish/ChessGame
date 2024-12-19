package main;

import javax.swing.*;
import java.awt.*;

public class ChessGame extends JPanel implements Runnable {

    private static final int HEIGHT = 800;
    private static final int WIDTH = 800;
    private static final int CASE_SIZE = 100;

    private Plateau plateau;
    Thread gameThread;

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }


    //ChessGame Loop (can be better ?)
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
                //update();
                repaint(); // calls paintComponent() to draw the chessboard
            }
        }
    }


    public ChessGame() {
        plateau = new Plateau();
        setPreferredSize(new Dimension(8*CASE_SIZE, 8*CASE_SIZE));

        // add mouse listener
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Transform Graphics g into Graphics2D because draw method use Graphics2D parameter
        Graphics2D g2d = (Graphics2D) g;

        //Draw the chess board
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    g2d.setColor(new Color(205, 133, 63));
                } else {
                    g2d.setColor(new Color(139, 69, 19));
                }
                g2d.fillRect(col * CASE_SIZE, row * CASE_SIZE, CASE_SIZE, CASE_SIZE);


                //draw chess pieces
                Piece piece = plateau.getPiece(row, col);
                if (piece != null) {
                    ImageIcon image = plateau.getImage(piece);
                    if (image != null) {
                        g2d.drawImage(image.getImage(),
                                col * CASE_SIZE, row * CASE_SIZE, CASE_SIZE, CASE_SIZE, this);
                        /*g2d.setColor(piece.getColor().equals("white") ? Color.WHITE : Color.BLACK);
                        g2d.fillOval(col * CASE_SIZE, row * CASE_SIZE, CASE_SIZE, CASE_SIZE);*/
                    }
                }
            }
        }
    }

    /*private void update() {
    }*/


    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Chess ChessGame");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(WIDTH,HEIGHT); // blank space on the right of the window to show some information
        frame.setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ChessGame chess = new ChessGame();
        frame.add(chess);
        frame.pack();
        chess.setLayout(null);
        chess.launchGame();

        /*JButton buttonQuit = new JButton("Quit Chess");
        frame.add(buttonQuit);
        buttonQuit.setBounds(850, 387, 100,36);
        buttonQuit.addActionListener(_ -> System.exit(0));*/

        ImageIcon icon = new ImageIcon("F:/THOMAS/Projet Code/Chess ChessGame/res/chess icon.png");
        frame.setIconImage(icon.getImage());

    }
}