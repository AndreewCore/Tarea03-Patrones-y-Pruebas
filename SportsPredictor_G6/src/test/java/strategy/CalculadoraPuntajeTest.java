package strategy;

import model.evento.EventoFutbol;
import model.prediccion.PrediccionFutbol;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraPuntajeTest {
    @Test
    public void testPuntajeFutbol() {
        EventoFutbol e = new EventoFutbol("Test", LocalDateTime.now());
        PrediccionFutbol pred = new PrediccionFutbol();
        pred.setEvento(e);
        e.actualizarEstadisticas();
        e.finalizarEvento();
        pred.setPrediccion(((EventoFutbol)e).calcularResultado(), 1, 0);
        pred.validarPrediccion();
        CalculadoraPuntaje calc = new CalculadoraPuntaje();
        calc.usarEstrategia(new PuntajeFutbol());
        assertEquals(10, calc.ejecutarEstrategia(pred));
    }

}
