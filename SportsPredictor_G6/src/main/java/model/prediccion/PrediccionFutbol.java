package model.prediccion;

import model.evento.EventoFutbol;
import model.enums.EstadoEvento;

public class PrediccionFutbol extends Prediccion {
    private String resultadoPredicho;
    private Integer golesLocal;
    private Integer golesVisitante;

    public PrediccionFutbol() { 
        super(); 
        this.golesLocal = 0;
        this.golesVisitante = 0;
    }

    @Override
    public void validarPrediccion() {
        if (evento instanceof EventoFutbol && evento.getEstado() == EstadoEvento.FINALIZADO) {
            EventoFutbol futbol = (EventoFutbol) evento;
            String resultadoReal = futbol.calcularResultado();
            if (resultadoReal.equals(resultadoPredicho)) {
                this.estado = model.enums.EstadoPrediccion.ACERTADO;
                this.puntos = calcularPuntos();
            } else {
                this.estado = model.enums.EstadoPrediccion.FALLIDO;
            }
        }
    }

    @Override
    public Integer calcularPuntos() {
        return estado == model.enums.EstadoPrediccion.ACERTADO ? 10 : 0;
    }

    @Override
    public void setPrediccion(String string, int i, int j) {
        this.resultadoPredicho = string;
        this.golesLocal = i;
        this.golesVisitante = j;
    }

}
