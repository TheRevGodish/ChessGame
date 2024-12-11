package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setTitle("Chess Game");
        window.setResizable(false);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();
        gp.launchGame();

        ImageIcon icon = new ImageIcon("F:/THOMAS/Projet Code/Chess Game/assets/chess icon.png");
        window.setIconImage(icon.getImage());

    }
}