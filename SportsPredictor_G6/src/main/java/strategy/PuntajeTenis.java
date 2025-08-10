package strategy;

import model.prediccion.*;
import model.enums.EstadoPrediccion;

public class PuntajeTenis implements EstrategiaPuntaje {
    @Override public int calcularPuntaje(Prediccion prediccion) {
        if (prediccion instanceof PrediccionTenis) {
            return prediccion.getEstado() == EstadoPrediccion.ACERTADO ? 12 : 0;
        }
        return 0;
    }

}
