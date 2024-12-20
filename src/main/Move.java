package main;


public class Move extends Plateau {

    public boolean isValid(int x1, int y1, int x2, int y2, String type, String color) {

        boolean valid = false;

        switch (type) {
            case "pawn":
                if (color.equals("white")) {
                    if (y1 == 6) {
                        valid = ((y1 - y2) == 1 || (y1 - y2) == 2) && x1 == x2;
                    } else { valid = (y1 - y2) == 1 && x1 == x2; }
                } else {
                    if (y1 == 1) {
                        valid = ((y2 - y1) == 1 || (y2 - y1) == 2) && x1 == x2;
                    } else { valid = (y2 - y1) == 1 && x1 == x2; }
                }
                break;

            case "bishop":
                valid = true;
                break;
        }
        return valid;
    }
}
