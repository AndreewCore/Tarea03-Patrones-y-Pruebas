package strategy;

import model.prediccion.*;
import model.enums.EstadoPrediccion;

public class PuntajeBasket implements EstrategiaPuntaje {
    @Override public int calcularPuntaje(Prediccion prediccion) {
        if (prediccion instanceof PrediccionBasket) {
            return prediccion.getEstado() == EstadoPrediccion.ACERTADO ? 15 : 0;
        }
        return 0;
    }

}
