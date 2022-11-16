package com.zsnails.snake;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InvalidObjectException;

import javax.swing.JFrame;

import com.zsnails.GameCenter.GameCenter;
import com.zsnails.Registro.Registro;
import com.zsnails.game.iJuego;
import com.zsnails.game.iJugador;

public class SnakeGame extends JFrame implements iJuego {

    private iJugador player = null;

    private SnakePanel snakePanel = new SnakePanel();

    private boolean hardReset = false;

    private GameCenter gameCenter = null;

    public SnakeGame() {
        this.add(snakePanel);
        this.setTitle("Snake");

        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                terminarPartida();
                hardReset = true;
            }
        });

        this.setLocationRelativeTo(null);
    }

    public iJugador getPlayer() {
        return player;
    }

    public void setPlayer(iJugador player) {
        this.player = player;
    }

    public SnakePanel getSnakePanel() {
        return snakePanel;
    }

    public void setSnakePanel(SnakePanel snakePanel) {
        this.snakePanel = snakePanel;
    }

    public boolean isHardReset() {
        return hardReset;
    }

    public void setHardReset(boolean hardReset) {
        this.hardReset = hardReset;
    }

    @Override
    public void iniciarPartida(iJugador jugador) {
        this.player = jugador;
        this.setVisible(true);
        this.snakePanel.startGame();

        try {
            this.gameCenter = GameCenter.getInstance();
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void terminarPartida() {
        this.snakePanel.stopGame();
        Registro score = this.snakePanel.getScore(this.hardReset);

        score.setJuego(this);
        score.setJugador(this.player);

        this.player.registrarPuntaje(score.getPuntaje(), this);
        // try {
        this.gameCenter.addRegistro(score);
        // } catch (InvalidObjectException e) {
        // e.printStackTrace();
        // }

        this.dispose();
    }

    @Override
    public String getNombre() {
        return "Snake";
    }

    @Override
    public String getDescripcion() {
        return "Un juego sencillo de snake que me saqué de un video de un indio";
    }

}
