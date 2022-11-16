package com.zsnails.poo;

import java.io.InvalidObjectException;

import com.zsnails.GameCenter.GameCenter;
import com.zsnails.hangmanGame.HangmanGameUI;
import com.zsnails.hiddenNumber.HiddenNumberGameUI;
import com.zsnails.player.Player;
import com.zsnails.snake.SnakeGame;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) throws InvalidObjectException {
        Player zeta = new Player("dog", "menganito");
        HiddenNumberGameUI e = new HiddenNumberGameUI();
        HangmanGameUI h = new HangmanGameUI();
        SnakeGame s = new SnakeGame();
        GameCenter.makeInstance(zeta, e, s, h);


        GameCenter center = GameCenter.getInstance();
        // s.setGameCenter(center);

        center.setVisible(true);
    }
}
