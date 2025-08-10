package model.prediccion;

import model.evento.EventoBasket;
import model.enums.EstadoEvento;

public class PrediccionBasket extends Prediccion {
    private int puntosLocal;
    private int puntosVisitantes;
    private String resultadoPredicho;

    public PrediccionBasket() { 
        super(); 
        this.puntosLocal = 0;
        this.puntosVisitantes = 0;
    }

    @Override
    public void setPrediccion(String s, int i, int j) {
        this.resultadoPredicho = s;
        this.puntosLocal = i;
        this.puntosVisitantes = j;
    }

    @Override
    public void validarPrediccion() {
        if (evento instanceof EventoBasket && evento.getEstado() == EstadoEvento.FINALIZADO) {
            EventoBasket basket = (EventoBasket) evento;
            Integer puntajeReal = Integer.parseInt(basket.calcularResultado());
            if (Math.abs(puntajeReal - Integer.parseInt(resultadoPredicho)) <= 5) {
                this.estado = model.enums.EstadoPrediccion.ACERTADO;
                this.puntos = calcularPuntos();
            } else {
                this.estado = model.enums.EstadoPrediccion.FALLIDO;
            }
        }
    }

    @Override
    public Integer calcularPuntos() {
        return estado == model.enums.EstadoPrediccion.ACERTADO ? 15 : 0;
    }

}
