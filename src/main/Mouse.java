package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    public boolean pressed;
    public int x, y;

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed = false;
        x = e.getX();
        y = e.getY();
    }

}
