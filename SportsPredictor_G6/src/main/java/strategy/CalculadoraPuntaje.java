package strategy;

import model.prediccion.Prediccion;

public class CalculadoraPuntaje {
    private EstrategiaPuntaje estrategia;

    public void usarEstrategia(EstrategiaPuntaje e) { this.estrategia = e; }

    public int ejecutarEstrategia(Prediccion p) { return estrategia == null ? 0 : estrategia.calcularPuntaje(p); }

}
