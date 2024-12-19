package main;

import javax.swing.*;


public class Plateau {

    private Piece[][] plateau;
    private final ImageIcon[] pngBlack;
    private final ImageIcon[] pngWhite;

    public Plateau() {
        plateau = new Piece[8][8]; // create plateau with 8 rows and 8 cols
        pngBlack = new ImageIcon[6];
        pngWhite = new ImageIcon[6];
        loadImages();
        startPosition();          // draw the starting position of all pieces
    }

    public void loadImages() {
        // load black png for black pieces
        pngBlack[0] = new ImageIcon(getClass().getResource(
                "/piece/b_rook.png"));
        pngBlack[1] = new ImageIcon(getClass().getResource(
                "/piece/b_knight.png"));
        pngBlack[2] = new ImageIcon(getClass().getResource(
                "/piece/b_bishop.png"));
        pngBlack[3] = new ImageIcon(getClass().getResource(
                "/piece/b_queen.png"));
        pngBlack[4] = new ImageIcon(getClass().getResource(
                "/piece/b_king.png"));
        pngBlack[5] = new ImageIcon(getClass().getResource(
                "/piece/b_pawn.png"));


        // load white png for white pieces
        pngWhite[0] = new ImageIcon(getClass().getResource(
                "/piece/w_rook.png"));
        pngWhite[1] = new ImageIcon(getClass().getResource(
                "/piece/w_knight.png"));
        pngWhite[2] = new ImageIcon(getClass().getResource(
                "/piece/w_bishop.png"));
        pngWhite[3] = new ImageIcon(getClass().getResource(
                "/piece/w_queen.png"));
        pngWhite[4] = new ImageIcon(getClass().getResource(
                "/piece/w_king.png"));
        pngWhite[5] = new ImageIcon(getClass().getResource(
                "/piece/w_pawn.png"));
    }


    private void startPosition() {

        // placing white pieces
        plateau[0][0] = new Piece("black", "rook");
        plateau[0][1] = new Piece("black", "knight");
        plateau[0][2] = new Piece("black", "bishop");
        plateau[0][3] = new Piece("black", "queen");
        plateau[0][4] = new Piece("black", "king");
        plateau[0][5] = new Piece("black", "bishop");
        plateau[0][6] = new Piece("black", "knight");
        plateau[0][7] = new Piece("black", "rook");


        // placing black pawns
        for (int col =0; col<8; col++) { plateau[1][col] = new Piece("black", "pawn"); }


        // placing white pieces
        plateau[7][0] = new Piece("white", "rook");
        plateau[7][1] = new Piece("white", "knight");
        plateau[7][2] = new Piece("white", "bishop");
        plateau[7][3] = new Piece("white", "queen");
        plateau[7][4] = new Piece("white", "king");
        plateau[7][5] = new Piece("white", "bishop");
        plateau[7][6] = new Piece("white", "knight");
        plateau[7][7] = new Piece("white", "rook");


        // placing white pawns
        for (int col =0; col<8; col++) { plateau[6][col] = new Piece("white", "pawn"); }
    }


    // piece position getter
    public Piece getPiece(int row, int col) { return plateau[row][col]; }


    public ImageIcon getImage(Piece piece) {
        if (piece != null) {
            int index = switch (piece.getType()) {
                case "rook" -> 0;
                case "knight" -> 1;
                case "bishop" -> 2;
                case "queen" -> 3;
                case "king" -> 4;
                case "pawn" -> 5;
                default -> 0;
            };

            if (piece.getColor().equals("black")) {
                return pngBlack[index];
            } else {
                return pngWhite[index];
            }
        }
        return null;
    }

}





