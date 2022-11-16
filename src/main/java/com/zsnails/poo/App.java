package com.zsnails.poo;

import java.io.InvalidObjectException;

import com.zsnails.GameCenter.GameCenter;
import com.zsnails.hangmanGame.HangmanGameUI;
<<<<<<< Updated upstream
import com.zsnails.hiddenNumber.HiddenNumberGameUI;
=======
import com.zsnails.login.LoginUI;
>>>>>>> Stashed changes
import com.zsnails.player.Player;
import com.zsnails.snake.SnakeGame;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) throws InvalidObjectException {
<<<<<<< Updated upstream
        Player zeta = new Player("dog", "menganito");
        HiddenNumberGameUI e = new HiddenNumberGameUI();
=======

        // Autenticar el usuario aquí

        // Usar las credenciales validas aquí y listo
        // Ya con eso queda fino
        /*Player zeta = new Player("dog", "menganito");

        TicTacToe t = new TicTacToe();
>>>>>>> Stashed changes
        HangmanGameUI h = new HangmanGameUI();
        SnakeGame s = new SnakeGame();
        GameCenter.makeInstance(zeta, e, s, h);

        GameCenter center = GameCenter.getInstance();

        center.setVisible(true);*/
        LoginUI login = new LoginUI();
        login.setVisible(true);
    }
}
