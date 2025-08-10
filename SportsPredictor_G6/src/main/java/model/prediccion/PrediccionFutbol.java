package model.prediccion;

import model.evento.EventoFutbol;
import model.enums.EstadoEvento;

public class PrediccionFutbol extends Prediccion {
    private String resultadoPredicho;
    private Integer golesLocal;
    private Integer golesVisitante;

    public PrediccionFutbol() { super(); }

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

    public String verificarResultado() { return resultadoPredicho != null ? resultadoPredicho : "Sin predicción"; }

    public void setPrediccion(String resultado, Integer golesLocal, Integer golesVisitante) {
        this.resultadoPredicho = resultado;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

}
