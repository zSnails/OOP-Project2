package com.zsnails.poo;

import com.zsnails.GameCenter.GameCenter;
import com.zsnails.hiddenNumber.HiddenNumberGameUI;
import com.zsnails.player.Player;
import com.zsnails.hangmanGame.HangmanGameUI;
import com.zsnails.snake.SnakeGame;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Player zeta = new Player("dog", "menganito");
        HiddenNumberGameUI e = new HiddenNumberGameUI();
        HangmanGameUI h = new HangmanGameUI();

        SnakeGame s = new SnakeGame();

        GameCenter center = new GameCenter(zeta, e, s, h);
        s.setGameCenter(center);

        center.setVisible(true);
    }
}
