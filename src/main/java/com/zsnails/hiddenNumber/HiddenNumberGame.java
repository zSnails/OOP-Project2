package com.zsnails.hiddenNumber;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Random;

import com.zsnails.game.iJuego;
import com.zsnails.game.iJugador;

public class HiddenNumberGame extends JPanel implements iJuego {

    private Random rand = new Random();
    private int numeroOculto = 0;

    public final int MAX_NUM = 100;

    private JTextField guess = new JTextField("Pinga marrai");
    private iJugador jugador = null;

    public HiddenNumberGame() {
    }

    private void initUI() {
        guess.setWidth(100);
        this.setVisible(true);
        this.add(guess);
    }

    private int nuevoNumero() {
        return rand.nextInt(MAX_NUM);
    }

    @Override
    public void iniciarPartida(iJugador jugador) {
        this.jugador = jugador;

        this.numeroOculto = nuevoNumero();

        this.initUI();

    }

    @Override
    public void terminarPartida() {
        // TODO: almacenar la picha esta del jugador nigger dog
    }

    @Override
    public String getNombre() {
        return "Hidden Number";
    }

    @Override
    public String getDescripcion() {
        return "";
    }

}
