package com.zsnails.poo;

import com.zsnails.GameCenter.GameCenter;
import com.zsnails.hiddenNumber.HiddenNumberGameUI;
import com.zsnails.player.Player;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Player zeta = new Player("dog", "menganito");
        HiddenNumberGameUI e = new HiddenNumberGameUI();
        GameCenter center = new GameCenter(zeta, e);

        center.setVisible(true);
    }
}
