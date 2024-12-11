package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class Piece {

    public void draw (Graphics2D gp) throws IOException {
        Hashtable<Integer, String> pieceList = new Hashtable<>();
        pieceList.put(1, "w_pawn");
        pieceList.put(2, "w_knight");
        pieceList.put(3, "w_bishop");
        pieceList.put(4, "w_rook");
        pieceList.put(5, "w_queen");
        pieceList.put(6, "w_king");
        pieceList.put(7, "b_pawn");
        pieceList.put(8, "b_knight");
        pieceList.put(9, "b_bishop");
        pieceList.put(10, "b_rook");
        pieceList.put(11, "b_queen");
        pieceList.put(12, "b_king");


        //white pawns
        for (int i=1; i<=8; i++) {
            BufferedImage image1 = ImageIO.read(new File(
                    "F:/THOMAS/Projet Code/Chess Game/res/piece/" + pieceList.get(1) + ".png"));
            gp.drawImage(image1, i*100-100, 600, null);
        }
        // white knights
        BufferedImage image2 = ImageIO.read(new File(
                "F:/THOMAS/Projet Code/Chess Game/res/piece/" + pieceList.get(2) + ".png"));
        gp.drawImage(image2, 100, 700, null);
        gp.drawImage(image2, 600, 700, null);
        // white bishops
        BufferedImage image3 = ImageIO.read(new File(
                "F:/THOMAS/Projet Code/Chess Game/res/piece/" + pieceList.get(3) + ".png"));
        gp.drawImage(image3, 200, 700, null);
        gp.drawImage(image3, 500, 700, null);
        // white rooks
        BufferedImage image4 = ImageIO.read(new File(
                "F:/THOMAS/Projet Code/Chess Game/res/piece/" + pieceList.get(4) + ".png"));
        gp.drawImage(image4, 0, 700, null);
        gp.drawImage(image4, 700, 700, null);
        // white queen
        BufferedImage image5 = ImageIO.read(new File(
                "F:/THOMAS/Projet Code/Chess Game/res/piece/" + pieceList.get(5) + ".png"));
        gp.drawImage(image5, 300, 700, null);
        // white king
        BufferedImage image6 = ImageIO.read(new File(
                "F:/THOMAS/Projet Code/Chess Game/res/piece/" + pieceList.get(6) + ".png"));
        gp.drawImage(image6, 400, 700, null);

        //black pawns
        for (int i=1; i<=8; i++) {
            BufferedImage image7 = ImageIO.read(new File(
                    "F:/THOMAS/Projet Code/Chess Game/res/piece/" + pieceList.get(7) + ".png"));
            gp.drawImage(image7, i*100-100, 100, null);
        }
        // black knights
        BufferedImage image8 = ImageIO.read(new File(
                "F:/THOMAS/Projet Code/Chess Game/res/piece/" + pieceList.get(8) + ".png"));
        gp.drawImage(image8, 100, 0, null);
        gp.drawImage(image8, 600, 0, null);
        // black bishops
        BufferedImage image9 = ImageIO.read(new File(
                "F:/THOMAS/Projet Code/Chess Game/res/piece/" + pieceList.get(9) + ".png"));
        gp.drawImage(image9, 200, 0, null);
        gp.drawImage(image9, 500, 0, null);
        // black rooks
        BufferedImage image10 = ImageIO.read(new File(
                "F:/THOMAS/Projet Code/Chess Game/res/piece/" + pieceList.get(10) + ".png"));
        gp.drawImage(image10, 0, 0, null);
        gp.drawImage(image10, 700, 0, null);
        // black queen
        BufferedImage image11 = ImageIO.read(new File(
                "F:/THOMAS/Projet Code/Chess Game/res/piece/" + pieceList.get(11) + ".png"));
        gp.drawImage(image11, 300, 0, null);
        // black king
        BufferedImage image12 = ImageIO.read(new File(
                "F:/THOMAS/Projet Code/Chess Game/res/piece/" + pieceList.get(12) + ".png"));
        gp.drawImage(image12, 400, 0, null);




    }
}
