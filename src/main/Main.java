package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setTitle("Chess Game");
        window.setResizable(false);
        window.setVisible(true);
        window.setSize(1000,800);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();
        gp.setLayout(null);
        gp.launchGame();

        JButton buttonQuit = new JButton("Quit Chess");
        gp.add(buttonQuit);
        buttonQuit.setBounds(850, 387, 100,36);
        buttonQuit.addActionListener(_ -> System.exit(0));

        ImageIcon icon = new ImageIcon("F:/THOMAS/Projet Code/Chess Game/res/chess icon.png");
        window.setIconImage(icon.getImage());

    }
}