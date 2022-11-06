
package com.zsnails.Registro;
import com.zsnails.game.iJugador;
import com.zsnails.game.iRegistro;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @author omega
 */
public class Registro implements iRegistro{
    LocalDateTime inicio;
    LocalDateTime finalizacion;
    int puntaje;
    boolean estadoFinalizado;
    iJugador jugador;

    public Registro(LocalDateTime inicio, LocalDateTime finalizacion, int puntaje, boolean estadoFinalizado, iJugador jugador) {
        this.inicio = inicio;
        this.finalizacion = finalizacion;
        this.puntaje = puntaje;
        this.estadoFinalizado = estadoFinalizado;
        this.jugador = jugador;
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
        return (int)Duration.between(this.inicio,this.finalizacion).getSeconds();
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
