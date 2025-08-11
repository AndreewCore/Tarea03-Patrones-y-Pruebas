package strategy;

import model.enums.EstadoPrediccion;
import model.evento.EventoFutbol;
import model.prediccion.PrediccionBasket;
import model.prediccion.PrediccionFutbol;
import model.prediccion.PrediccionTenis;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraPuntajeTest {
    @Test
    @DisplayName("TST-STR-001: Configurar estrategia PuntajeFutbol correctamente")
    void testConfigurarEstrategiaFutbol() {
        CalculadoraPuntaje calc = new CalculadoraPuntaje();
        assertDoesNotThrow(() -> calc.usarEstrategia(new PuntajeFutbol()),
                "La estrategia PuntajeFutbol debería configurarse sin errores");
    }

    @Test
    @DisplayName("TST-STR-002: Configurar estrategia nula no provoca error")
    void testConfigurarEstrategiaNula() {
        CalculadoraPuntaje calc = new CalculadoraPuntaje();
        assertDoesNotThrow(() -> calc.usarEstrategia(null),
                "Asignar una estrategia nula no debería provocar error");
    }

    @Test
    @DisplayName("TST-STR-003: Calcular puntaje con predicción de fútbol acertada devuelve 10 puntos")
    void testPuntajeFutbolPrediccionAcertada() {
        CalculadoraPuntaje calc = new CalculadoraPuntaje();
        calc.usarEstrategia(new PuntajeFutbol());
        PrediccionFutbol p = new PrediccionFutbol();
        p.setEstado(EstadoPrediccion.ACERTADO);
        assertEquals(10, calc.ejecutarEstrategia(p));
    }

    @Test
    @DisplayName("TST-STR-004: Calcular puntaje con predicción de fútbol fallida devuelve 0 puntos")
    void testPuntajeFutbolPrediccionFallida() {
        CalculadoraPuntaje calc = new CalculadoraPuntaje();
        calc.usarEstrategia(new PuntajeFutbol());
        PrediccionFutbol p = new PrediccionFutbol();
        p.setEstado(EstadoPrediccion.FALLIDO);
        assertEquals(0, calc.ejecutarEstrategia(p));
    }

    @Test
    @DisplayName("TST-STR-005: Ejecutar estrategia con predicción nula devuelve 0 puntos")
    void testEstrategiaConPrediccionNula() {
        CalculadoraPuntaje calc = new CalculadoraPuntaje();
        calc.usarEstrategia(new PuntajeFutbol());
        assertEquals(0, calc.ejecutarEstrategia(null));
    }

    @Test
    @DisplayName("TST-STR-006: PuntajeFutbol con estado ACERTADO devuelve 10")
    void testCalculoDirectoPuntajeFutbolAcertado() {
        PuntajeFutbol estrategia = new PuntajeFutbol();
        PrediccionFutbol p = new PrediccionFutbol();
        p.setEstado(EstadoPrediccion.ACERTADO);
        assertEquals(10, estrategia.calcularPuntaje(p));
    }

    @Test
    @DisplayName("TST-STR-007: PuntajeFutbol con estado FALLIDO devuelve 0")
    void testCalculoDirectoPuntajeFutbolFallido() {
        PuntajeFutbol estrategia = new PuntajeFutbol();
        PrediccionFutbol p = new PrediccionFutbol();
        p.setEstado(EstadoPrediccion.FALLIDO);
        assertEquals(0, estrategia.calcularPuntaje(p));
    }

    @Test
    @DisplayName("TST-STR-008: PuntajeTenis con estado ACERTADO devuelve 12")
    void testCalculoDirectoPuntajeTenisAcertado() {
        PuntajeTenis estrategia = new PuntajeTenis();
        PrediccionTenis p = new PrediccionTenis();
        p.setEstado(EstadoPrediccion.ACERTADO);
        assertEquals(12, estrategia.calcularPuntaje(p));
    }

    @Test
    @DisplayName("TST-STR-009: PuntajeBasket con estado ACERTADO devuelve 15")
    void testCalculoDirectoPuntajeBasketAcertado() {
        PuntajeBasket estrategia = new PuntajeBasket();
        PrediccionBasket p = new PrediccionBasket();
        p.setEstado(EstadoPrediccion.ACERTADO);
        assertEquals(15, estrategia.calcularPuntaje(p));
    }
}
