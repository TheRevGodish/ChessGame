package main;

import java.awt.*;
import java.awt.Graphics2D;

public class GameBoard {

    public void draw (Graphics2D gb) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((col % 2) > 0){
                    gb.setColor(new Color(130, 94, 92));
                }
                else {
                    gb.setColor(new Color(227, 186, 143));
                }
                gb.fillRect(col * 100, row * 100, 100, 100);
            }
        }
    }
}
