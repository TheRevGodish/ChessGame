package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setTitle("Chesss Game");
        window.setResizable(true);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();

        // Window icon
        ImageIcon icon = new ImageIcon("F:/THOMAS/Projet Code/Chess Game/assets/chess icon.png");
        window.setIconImage(icon.getImage());

    }
}