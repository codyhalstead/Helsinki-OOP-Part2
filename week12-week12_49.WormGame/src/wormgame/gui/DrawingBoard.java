/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;
import wormgame.domain.Apple;

/**
 *
 * @author Cody
 */
public class DrawingBoard extends JPanel implements Updatable {
    private WormGame wormgame;
    private int pieceLength;
    
    public DrawingBoard(WormGame wormGame, int pieceLength){
        super.setBackground(Color.GRAY);
        this.wormgame = wormGame;
        this.pieceLength = pieceLength;
    }

    @Override
    public void update() {
         super.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        List<Piece> wormPieces = wormgame.getWorm().getPieces();
        for (Piece p : wormPieces) {
            int x = p.getX();
            int y = p.getY();
            g.fill3DRect(x*pieceLength, y*pieceLength, pieceLength, pieceLength, true);
        }

        g.setColor(Color.RED);
        g.fillOval(wormgame.getApple().getX()*pieceLength, wormgame.getApple().getY()*pieceLength, pieceLength, pieceLength);
    }
}
