package com.zsnails.hiddenNumber;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.zsnails.game.iJuego;
import com.zsnails.game.iJugador;

public class HiddenNumberGame extends JPanel implements iJuego {

    private int numeroOculto = 0;
    private JTextField guess = new JTextField("Pinga marrai");

    public HiddenNumberGame() {
        this.setBackground(Color.YELLOW);
        this.initUI();
    }

    private void initUI() {
        this.add(guess);
    }

    @Override
    public void iniciarPartida(iJugador jugador) {
        this.setVisible(true);
    }

    @Override
    public void terminarPartida() {
    }

    @Override
    public String getNombre() {
        return "Hidden Number";
    }

    @Override
    public String getDescripcion() {
        return "Juego culiolo de adivinar un número";
    }

}
