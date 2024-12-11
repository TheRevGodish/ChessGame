package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public static final int HEIGTH = 1000;
    public static final int WIDTH = 1000;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGTH));
        setBackground(Color.BLACK);

    }

}
