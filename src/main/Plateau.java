package main;

import javax.swing.*;
import java.util.Objects;


public class Plateau {

    private final Piece[][] piecePlateau;
    private final ImageIcon[] pngBlack;
    private final ImageIcon[] pngWhite;

    public Plateau() {
        piecePlateau = new Piece[8][8]; // create plateau with 8 rows and 8 cols
        pngBlack = new ImageIcon[6];
        pngWhite = new ImageIcon[6];
        loadImages();
        startPosition();          // draw the starting position of all pieces
    }

    public void loadImages() {
        // load black png for black pieces
        pngBlack[0] = new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/piece/b_rook.png")));
        pngBlack[1] = new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/piece/b_knight.png")));
        pngBlack[2] = new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/piece/b_bishop.png")));
        pngBlack[3] = new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/piece/b_queen.png")));
        pngBlack[4] = new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/piece/b_king.png")));
        pngBlack[5] = new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/piece/b_pawn.png")));


        // load white png for white pieces
        pngWhite[0] = new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/piece/w_rook.png")));
        pngWhite[1] = new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/piece/w_knight.png")));
        pngWhite[2] = new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/piece/w_bishop.png")));
        pngWhite[3] = new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/piece/w_queen.png")));
        pngWhite[4] = new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/piece/w_king.png")));
        pngWhite[5] = new ImageIcon(Objects.requireNonNull(getClass().getResource(
                "/piece/w_pawn.png")));
    }


    private void startPosition() {

        // placing white pieces
        piecePlateau[0][0] = new Piece("black", "rook");
        piecePlateau[0][1] = new Piece("black", "knight");
        piecePlateau[0][2] = new Piece("black", "bishop");
        piecePlateau[0][3] = new Piece("black", "queen");
        piecePlateau[0][4] = new Piece("black", "king");
        piecePlateau[0][5] = new Piece("black", "bishop");
        piecePlateau[0][6] = new Piece("black", "knight");
        piecePlateau[0][7] = new Piece("black", "rook");


        // placing black pawns
        for (int col =0; col<8; col++) { piecePlateau[1][col] = new Piece("black", "pawn"); }


        // placing white pieces
        piecePlateau[7][0] = new Piece("white", "rook");
        piecePlateau[7][1] = new Piece("white", "knight");
        piecePlateau[7][2] = new Piece("white", "bishop");
        piecePlateau[7][3] = new Piece("white", "queen");
        piecePlateau[7][4] = new Piece("white", "king");
        piecePlateau[7][5] = new Piece("white", "bishop");
        piecePlateau[7][6] = new Piece("white", "knight");
        piecePlateau[7][7] = new Piece("white", "rook");


        // placing white pawns
        for (int col =0; col<8; col++) { piecePlateau[6][col] = new Piece("white", "pawn"); }
    }


    // piece position getter
    public Piece getPiece(int col, int row) { return piecePlateau[col][row]; }

    public void movePiece(int yStart, int xStart, int xEnd, int yEnd) {
        Piece piece = piecePlateau[xStart][yStart];
        piecePlateau[xStart][yStart] = null;
        piecePlateau[xEnd][yEnd] = piece;
    }


    public ImageIcon getImage(Piece piece) {
        if (piece != null) {
            int index = switch (piece.getType()) {
                case "rook" -> 0;
                case "knight" -> 1;
                case "bishop" -> 2;
                case "queen" -> 3;
                case "king" -> 4;
                case "pawn" -> 5;
                default -> -1;
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





