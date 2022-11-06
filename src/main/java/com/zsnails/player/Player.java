package com.zsnails.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zsnails.game.iJuego;
import com.zsnails.game.iJugador;
import com.zsnails.game.iRegistro;

public class Player implements iJugador {

    private String nombre;
    private String contrasena;
    private List<iRegistro> stats = new ArrayList<>();

    public Player(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    private Map<String, Integer> puntajes = new HashMap<>();

    public String getNombre() {
        return this.nombre;
    }

    public void registrarPuntaje(int puntuacion, iJuego juego) {
        this.puntajes.computeIfAbsent(juego.getNombre(), (key) -> puntuacion);
        this.puntajes.computeIfPresent(juego.getNombre(), (k, v) -> v += puntuacion);
    }

    public ArrayList<iRegistro> estadisticas(iJuego tipoJuego) {
        return new ArrayList<iRegistro>(
                // WARNING: broken code

                // FIXME: the code below checks if the class of every element within the
                // stats List is equal to the class of the given game, this is not the intended
                // behaviour
                // there's now way of accessing the underlying game type that's stored within
                // the
                // stats list
                this.stats.stream().filter((e) -> e.getClass() == tipoJuego.getClass()).toList());
    }
}
