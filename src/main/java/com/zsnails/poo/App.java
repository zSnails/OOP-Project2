package com.zsnails.poo;

import java.io.InvalidObjectException;

import com.zsnails.GameCenter.GameCenter;
import com.zsnails.auth.Auth;
import com.zsnails.login.LoginUI;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) throws InvalidObjectException {
        // Autenticar el usuario aquí

        // Usar las credenciales validas aquí y listo
        // Ya con eso queda fino
        // Autenticar el usuario aquí

        // Usar las credenciales validas aquí y listo
        // Ya con eso queda fino
        /*Player zeta = new Player("dog", "menganito");

        TicTacToe t = new TicTacToe();
        HangmanGameUI h = new HangmanGameUI();
        SnakeGame s = new SnakeGame();
        GameCenter.makeInstance(zeta, t, s, h);

        GameCenter center = GameCenter.getInstance();
        System.out.println(center.getJugadores());

        System.out.println(center.findJugador("dog"));

        center.setVisible(true);*/
        Auth.loadData();
        LoginUI login = new LoginUI();
        login.setVisible(true);
    }
}
