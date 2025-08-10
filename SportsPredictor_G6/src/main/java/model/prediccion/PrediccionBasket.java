package model.prediccion;

import model.evento.EventoBasket;
import model.enums.EstadoEvento;

public class PrediccionBasket extends Prediccion {
    private Integer puntajePredicho;
    private Integer margenVictoria;

    public PrediccionBasket() { super(); }

    @Override
    public void validarPrediccion() {
        if (evento instanceof EventoBasket && evento.getEstado() == EstadoEvento.FINALIZADO) {
            EventoBasket basket = (EventoBasket) evento;
            Integer puntajeReal = basket.calcularPuntaje();
            if (Math.abs(puntajeReal - puntajePredicho) <= 5) {
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

    public void evaluarPuntaje() { System.out.println("Evaluando puntaje de básquet: " + puntajePredicho); }

    public void setPrediccion(Integer puntaje, Integer margen) { this.puntajePredicho = puntaje; this.margenVictoria = margen; }

}
