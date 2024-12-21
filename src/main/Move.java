package main;


import static java.lang.Math.abs;

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

            case "knight":
                valid = (abs(x2 - x1) == 1 && abs(y2 - y1) == 2) || (abs(x2 - x1) == 2 && abs(y2 - y1) == 1);
                break;

            case "bishop":
                valid = abs(x2 - x1) == abs(y2 - y1);
                break;

            case "rook":
                valid = (x2 == x1) || (y2 == y1);
                break;

            case "king":
                valid = ((abs(x2 - x1) == 1) && abs(y2 - y1) < 2 || (abs(y2 - y1) == 1)) && abs(x2 - x1) < 2;
                break;

            case "queen":
                valid = (x2 == x1) || (y2 == y1) || abs(x2 - x1) == abs(y2 - y1);
                break;
        }
        return valid;
    }


    public boolean isPathClear (int x1, int y1, int x2, int y2, Plateau plateau) {

        boolean pathClear = true;

        if (x1 == x2) {
            int minStartY = Math.min(y1, y2);
            int minEndY = Math.max(y1, y2);

            for (int i = minStartY + 1; i < minEndY; i++) {
                if ((plateau.getPiece(x1, i)) != null) {
                    pathClear = false;
                    System.out.println("vertical move blocked");
                }
            }
        } else if (y1 == y2) {
            int minStartX = Math.min(x1, x2);
            int minEndX = Math.max( x1, x2);

            for (int j = minStartX + 1; j < minEndX; j++){
                if (plateau.getPiece(j, y1) != null) {
                    pathClear = false;
                    System.out.println("horizontal move blocked");
                }
            }
        }
        return pathClear;
    }


}
