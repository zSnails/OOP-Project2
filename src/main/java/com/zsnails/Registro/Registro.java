
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

    public Registro(LocalDateTime inicio, LocalDateTime finalizacion, int puntaje, boolean estadoFinalizado,
            iJugador jugador, iJuego juego) {
        this.inicio = inicio;
        this.finalizacion = finalizacion;
        this.puntaje = puntaje;
        this.estadoFinalizado = estadoFinalizado;
        this.jugador = jugador;
        this.juego = juego;
    }

    public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public void setEstadoFinalizado(boolean estadoFinalizado) {
		this.estadoFinalizado = estadoFinalizado;
	}

	public void setJugador(iJugador jugador) {
		this.jugador = jugador;
	}

	public void setJuego(iJuego juego) {
		this.juego = juego;
	}

	public iJuego getJuego() {
        return this.juego;
    }

    @Override
    public LocalDateTime getInicio() {
        return this.inicio;
    }

    @Override
    public LocalDateTime getFinalizacion() {
        return this.finalizacion;
    }

    @Override
    public void setInicio(LocalDateTime fechaHora) {
        this.inicio = fechaHora;
    }

    @Override
    public void setFinalizacion(LocalDateTime fechaHora) {
        this.finalizacion = fechaHora;

    }

    @Override
    public int getPuntaje() {
        return this.puntaje;
    }

    @Override
    public int getSegundosTotalesPartida() {
        return (int) Duration.between(this.inicio, this.finalizacion).getSeconds();
    }

    @Override
    public boolean getEstadoFinalizado() {
        return this.estadoFinalizado;
    }

    @Override
    public iJugador getJugador() {
        return this.jugador;
    }

}
