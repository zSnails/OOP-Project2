package com.zsnails.poo;

import javax.swing.JFrame;

import com.zsnails.hiddenNumber.HiddenNumberGame;

// import com.zsnails.tictactoe.TicTacToeGame;

public class App {
    public static void main(String[] args) {
        JFrame wHandle = new JFrame("Nigger dog");
        wHandle.setSize(500, 500);

        // PTicTacToe p = new PTicTacToe();
        // p.setVisible(true);

        // wHandle.add(p);
        // p.iniciarPartida(null);
        HiddenNumberGame hng = new HiddenNumberGame();

        hng.iniciarPartida(null);
        wHandle.add(hng);

        wHandle.setVisible(true);
    }
}
