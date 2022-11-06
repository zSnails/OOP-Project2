package com.zsnails.poo;

import javax.swing.JFrame;

import com.zsnails.hiddenNumber.HiddenNumberGame;

import com.zsnails.player.Player;
import com.zsnails.hiddenNumber.HiddenNumberGameUI;

public class App {
    public static void main(String[] args) {
        JFrame wHandle = new JFrame("Nigger dog");
        wHandle.setSize(500, 500);

        Player e = new Player("Samuel", "");


        HiddenNumberGameUI i = new HiddenNumberGameUI();
        i.iniciarPartida(e);


        // wHandle.setVisible(true);
    }
}
