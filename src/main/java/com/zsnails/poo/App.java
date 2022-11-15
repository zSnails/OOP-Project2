package com.zsnails.poo;

import com.zsnails.GameCenter.GameCenter;
import com.zsnails.hiddenNumber.HiddenNumberGameUI;
import com.zsnails.player.Player;
import com.zsnails.hangmanGame.HangmanGameUI;
public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Player zeta = new Player("dog", "menganito");
        HiddenNumberGameUI e = new HiddenNumberGameUI();
        HangmanGameUI h = new HangmanGameUI(new javax.swing.JDialog(),true);
        GameCenter center = new GameCenter(zeta,h ,e);
        
        center.setVisible(true);
    }
}
