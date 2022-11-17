package com.zsnails.poo;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

import com.zsnails.GameCenter.GameCenter;
import com.zsnails.hangmanGame.HangmanGameUI;
import com.zsnails.player.Player;
import com.zsnails.snake.SnakeGame;
import com.zsnails.tictactoe.TicTacToe;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 30; i++)
            nums.add(i);

        List<Integer> res = nums.stream().filter((num) -> (num & 1) == 0).limit(10).sorted((i1, i2) -> i1 < i2 ? 1 : -1)
                .toList();
        System.out.println(res);

        assertTrue(res.size() == 10);
    }

    public void testFind() {

        Player zeta = new Player("dog", "123");
        TicTacToe t = new TicTacToe();
        HangmanGameUI h = new HangmanGameUI();
        SnakeGame s = new SnakeGame();
        GameCenter.makeInstance(zeta, t, s, h);

        GameCenter center = null;
        try {
            center = GameCenter.getInstance();
        } catch (InvalidObjectException e) {
            e.printStackTrace();
            assert false;
        }

        center.cargarJugadores();
        center.cargarRegistros();

        System.out.println(center.findJuego("Snake"));
        System.out.println(center.getTop10().size());
        System.out.println(center.getTop10(zeta).size());
    }
}
