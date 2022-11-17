
package com.zsnails.Registro;

import java.time.Duration;
import java.time.LocalDateTime;

import com.zsnails.game.iJuego;
import com.zsnails.game.iJugador;
import com.zsnails.game.iRegistro;

/**
 *
 * @author omega
 */
public class Registro implements iRegistro {
    private LocalDateTime inicio;
    private LocalDateTime finalizacion;
    private int puntaje;
    private boolean estadoFinalizado;
    private iJugador jugador;
    private iJuego juego;

    public Registro() {
    }

    public Registro(LocalDateTime inicio, LocalDateTime finalizacion, int puntaje, boolean estadoFinalizado,
            iJugador jugador, iJuego juego) {
        this.inicio = inicio;
        this.finalizacion = finalizacion;
        this.puntaje = puntaje;
        this.estadoFinalizado = estadoFinalizado;
        this.jugador = jugador;
        this.juego = juego;
    }

    /**
     * Sets puntaje
     * @param puntaje
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * sets estadoFinalizado
     * @param estadoFinalizado
     */
    public void setEstadoFinalizado(boolean estadoFinalizado) {
        this.estadoFinalizado = estadoFinalizado;
    }

    /**
     * Sets jugador
     * @param jugador
     */
    public void setJugador(iJugador jugador) {
        this.jugador = jugador;
    }

    /**
     * Sets juego
     * @param juego
     */
    public void setJuego(iJuego juego) {
        this.juego = juego;
    }

    /**
     * Gets juego
     * @return
     */
    public iJuego getJuego() {
        return this.juego;
    }

    /* (non-Javadoc)
     * @see com.zsnails.game.iRegistro#getInicio()
     */
    @Override
    public LocalDateTime getInicio() {
        return this.inicio;
    }

    /* (non-Javadoc)
     * @see com.zsnails.game.iRegistro#getFinalizacion()
     */
    @Override
    public LocalDateTime getFinalizacion() {
        return this.finalizacion;
    }

    /* (non-Javadoc)
     * @see com.zsnails.game.iRegistro#setInicio(java.time.LocalDateTime)
     */
    @Override
    public void setInicio(LocalDateTime fechaHora) {
        this.inicio = fechaHora;
    }

    /* (non-Javadoc)
     * @see com.zsnails.game.iRegistro#setFinalizacion(java.time.LocalDateTime)
     */
    @Override
    public void setFinalizacion(LocalDateTime fechaHora) {
        this.finalizacion = fechaHora;

    }

    /* (non-Javadoc)
     * @see com.zsnails.game.iRegistro#getPuntaje()
     */
    @Override
    public int getPuntaje() {
        return this.puntaje;
    }

    /* (non-Javadoc)
     * @see com.zsnails.game.iRegistro#getSegundosTotalesPartida()
     */
    @Override
    public int getSegundosTotalesPartida() {
        return (int) Duration.between(this.inicio, this.finalizacion).getSeconds();
    }

    /* (non-Javadoc)
     * @see com.zsnails.game.iRegistro#getEstadoFinalizado()
     */
    @Override
    public boolean getEstadoFinalizado() {
        return this.estadoFinalizado;
    }

    /* (non-Javadoc)
     * @see com.zsnails.game.iRegistro#getJugador()
     */
    @Override
    public iJugador getJugador() {
        return this.jugador;
    }

}
