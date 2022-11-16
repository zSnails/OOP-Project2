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

    private Map<String, Integer> puntajes = new HashMap<>();

    public Player() {
    }

    public Player(final String nombre, final String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(final String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void registrarPuntaje(final int puntuacion, final iJuego juego) {
        this.puntajes.computeIfAbsent(juego.getNombre(), (key) -> puntuacion);
        this.puntajes.computeIfPresent(juego.getNombre(), (k, v) -> v += puntuacion);
    }

    public ArrayList<iRegistro> estadisticas(final iJuego tipoJuego) {
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

    @Override
    public String toString() {
        return String.format("Player(%s)", this.nombre);
    }

    public List<iRegistro> getStats() {
        return stats;
    }

    public void setStats(final List<iRegistro> stats) {
        this.stats = stats;
    }

    public Map<String, Integer> getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(final Map<String, Integer> puntajes) {
        this.puntajes = puntajes;
    }
}
