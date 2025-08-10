package strategy;

import model.prediccion.*;
import model.enums.EstadoPrediccion;

public class PuntajeFutbol implements EstrategiaPuntaje {
    @Override public int calcularPuntaje(Prediccion prediccion) {
        if (prediccion instanceof PrediccionFutbol) {
            return prediccion.getEstado() == EstadoPrediccion.ACERTADO ? 10 : 0;
        }
        return 0;
    }

}
