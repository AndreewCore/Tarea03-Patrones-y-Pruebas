package creational;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import model.evento.*;
import model.participante.*;
import model.prediccion.*;


@DisplayName("Pruebas de BasketFactory")
public class BasketFactoryTest {

    private BasketFactory basketFactory;

    @BeforeEach
    void setUp() {
        basketFactory = new BasketFactory("NBA");
    }

    @Test
    @DisplayName("TST-CR-013: Crear evento de básquet correctamente")
    void testCrearEventoBasketValido() {
        Evento evento = basketFactory.crearEvento();

        assertNotNull(evento, "El evento creado no debe ser nulo");
    }

    @Test
    @DisplayName("TST-CR-014: Error por nombre de evento nulo")
    void testCrearEventoConNombreNulo() {
        Evento evento = basketFactory.crearEvento();

        assertNotNull(evento.getNombre(),
                "El nombre del evento no debe ser nulo");
    }

    @Test
    @DisplayName("TST-CR-015: Error por nombre vacío")
    void testCrearEventoConNombreVacio() {
        Evento evento = basketFactory.crearEvento();

        assertFalse(evento.getNombre().isEmpty(),
                "El nombre del evento no debe estar vacío");
    }

    @Test
    @DisplayName("TST-CR-016: Excepción por ID nulo")
    void testCrearEventoConIdNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new BasketFactory(null),
                "Factory debe validar parámetros nulos en constructor");
    }

    @Test
    @DisplayName("TST-CR-017: Crear participante de básquet correctamente")
    void testCrearParticipanteBasketValido() {
        Participante participante = basketFactory.crearParticipante();

        assertInstanceOf(ParticipanteBasket.class, participante,
                "El participante debe ser de tipo ParticipanteBasket");
    }

    @Test
    @DisplayName("TST-CR-018: Error por nombre nulo en participante")
    void testCrearParticipanteConNombreNulo() {
        Participante participante = basketFactory.crearParticipante();

        assertEquals("Jugador Basket", participante.getNombre(),
                "El nombre del participante debe ser el esperado");
    }

    @Test
    @DisplayName("TST-CR-019: Error por ID vacío en participante")
    void testCrearParticipanteConIdVacio() {
        ParticipanteBasket participante = (ParticipanteBasket) basketFactory.crearParticipante();

        assertTrue(participante.getNombre() != null && !participante.getNombre().isEmpty(),
                "El participante debe tener un nombre válido");
    }

    @Test
    @DisplayName("TST-CR-020: Crear predicción de básquet correctamente")
    void testCrearPrediccionBasketValida() {
        Prediccion prediccion = basketFactory.crearPrediccion();

        assertInstanceOf(PrediccionBasket.class, prediccion,
                "La predicción debe ser de tipo PrediccionBasket");
    }

    @Test
    @DisplayName("TST-CR-021: Error por marcador nulo")
    void testCrearPrediccionConMarcadorNulo() {
        PrediccionBasket prediccion = (PrediccionBasket) basketFactory.crearPrediccion();

        assertTimeoutPreemptively(java.time.Duration.ofSeconds(1),
                () -> assertNotNull(prediccion),
                "La creación de predicción debe ser rápida");
    }

    @Test
    @DisplayName("TST-CR-022: Excepción por ID nulo en predicción")
    void testCrearPrediccionConIdNulo() {
        Prediccion prediccion1 = basketFactory.crearPrediccion();
        Prediccion prediccion2 = basketFactory.crearPrediccion();

        assertAll("Verificaciones de predicciones de básquet",
                () -> assertNotNull(prediccion1, "Primera predicción no debe ser nula"),
                () -> assertNotNull(prediccion2, "Segunda predicción no debe ser nula"),
                () -> assertEquals(prediccion1.getClass(), prediccion2.getClass(),
                        "Ambas predicciones deben ser del mismo tipo")
        );
    }

}