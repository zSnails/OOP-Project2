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

    /**
     * Sets nombre
     * @param nombre
     */
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets contraseña
     * @return
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Sets contraseña
     * @param contrasena
     */
    public void setContrasena(final String contrasena) {
        this.contrasena = contrasena;
    }

    /* (non-Javadoc)
     * @see com.zsnails.game.iJugador#getNombre()
     */
    public String getNombre() {
        return this.nombre;
    }

    /* (non-Javadoc)
     * @see com.zsnails.game.iJugador#registrarPuntaje(int, com.zsnails.game.iJuego)
     */
    public void registrarPuntaje(final int puntuacion, final iJuego juego) {
        this.puntajes.computeIfAbsent(juego.getNombre(), (key) -> puntuacion);
        this.puntajes.computeIfPresent(juego.getNombre(), (k, v) -> v += puntuacion);
    }

    /* (non-Javadoc)
     * @see com.zsnails.game.iJugador#estadisticas(com.zsnails.game.iJuego)
     */
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Player(%s)", this.nombre);
    }

    /**
     * Gets stats
     * @return
     */
    public List<iRegistro> getStats() {
        return stats;
    }

    /**
     * Sets stats
     * @param stats
     */
    public void setStats(final List<iRegistro> stats) {
        this.stats = stats;
    }

    /**
     * Gets puntajes
     * @return
     */
    public Map<String, Integer> getPuntajes() {
        return puntajes;
    }

    /**
     * Sets puntajes
     * @param puntajes
     */
    public void setPuntajes(final Map<String, Integer> puntajes) {
        this.puntajes = puntajes;
    }
}
