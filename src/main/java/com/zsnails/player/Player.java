package com.zsnails.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.zsnails.game.iJuego;
import com.zsnails.game.iJugador;
import com.zsnails.game.iRegistro;

public class Player implements iJugador {

    private String nombre;

    private Map<String, Integer> puntajes = new HashMap<>();

    public String getNombre() {
        return this.nombre;
    }

    public void registrarPuntaje(int puntuacion, iJuego juego) {
        this.puntajes.computeIfAbsent(juego.getNombre(), (key) -> puntuacion);
        this.puntajes.computeIfPresent(juego.getNombre(), (k, v) -> v += puntuacion);
    }

    public ArrayList<iRegistro> estadisticas(iJuego tipoJuego) {
        return null;
    }
}
