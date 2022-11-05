package com.zsnails.tictactoe;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.zsnails.game.iJuego;
import com.zsnails.game.iJugador;

public class TicTacToeGame implements iJuego {

    private JFrame wHandle = new JFrame("TBD");
    private int[][] board = new int[3][3];

    /*
     * (non-Javadoc)
     * 
     * @see com.zsnails.game.iJuego#iniciarPartida(com.zsnails.game.iJugador)
     */
    public void iniciarPartida(iJugador jugador) {
        wHandle.setSize(500, 500);
        this.makeBoard();

        wHandle.setVisible(true);
    }

    private void makeBoard() {
        JPanel p = new JPanel();
        p.setVisible(true);
        for (int i = 0; i < 9; i++) {
            TCell tc = new TCell();
            tc.setSize(20, 20);
            p.add(tc);
        }

        wHandle.add(p);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zsnails.game.iJuego#terminarPartida()
     */
    public void terminarPartida() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zsnails.game.iJuego#getNombre()
     */
    public String getNombre() {
        return "Tic-Tac-Toe";
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zsnails.game.iJuego#getDescripcion()
     */
    public String getDescripcion() {
        return "Juego sencillo de tictactoe no pida mucho profe lmao";
    }
}
