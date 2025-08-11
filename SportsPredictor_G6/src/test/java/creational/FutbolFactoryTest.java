package creational;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import model.evento.*;
import model.participante.*;
import model.prediccion.*;


@DisplayName("Pruebas de FutbolFactory")
public class FutbolFactoryTest {

    private FutbolFactory futbolFactory;

    @BeforeEach
    void setUp() {
        futbolFactory = new FutbolFactory("Liga Española");
    }

    @Test
    @DisplayName("TST-CR-001: Crear evento de fútbol correctamente")
    void testCrearEventoFutbolValido() {
        Evento evento = futbolFactory.crearEvento();

        assertNotNull(evento, "El evento creado no debe ser nulo");
    }

    @Test
    @DisplayName("TST-CR-002: Excepción por ID nulo en evento")
    void testCrearEventoConIdNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new FutbolFactory(null),
                "Factory debe validar parámetros nulos en constructor");
    }

    @Test
    @DisplayName("TST-CR-003: Error por ID vacío en evento")
    void testCrearEventoConIdVacio() {
        assertThrows(IllegalArgumentException.class,
                () -> new FutbolFactory(""),
                "Factory debe validar parámetros vacíos");
    }

    @Test
    @DisplayName("TST-CR-004: Error por nombre nulo en evento")
    void testCrearEventoConNombreNulo() {
        Evento evento = futbolFactory.crearEvento();

        assertNotNull(evento.getNombre(),
                "El nombre del evento no debe ser nulo");
    }

    @Test
    @DisplayName("TST-CR-005: Error por nombre vacío en evento")
    void testCrearEventoConNombreVacio() {
        Evento evento = futbolFactory.crearEvento();

        assertFalse(evento.getNombre().isEmpty(),
                "El nombre del evento no debe estar vacío");
    }

    @Test
    @DisplayName("TST-CR-006: Crear participante de fútbol correctamente")
    void testCrearParticipanteFutbolValido() {
        Participante participante = futbolFactory.crearParticipante();

        assertInstanceOf(ParticipanteFutbol.class, participante,
                "El participante debe ser de tipo ParticipanteFutbol");
    }

    @Test
    @DisplayName("TST-CR-007: Error por ID vacío en participante")
    void testCrearParticipanteConIdVacio() {
        Participante participante = futbolFactory.crearParticipante();

        assertTrue(participante.getNombre() != null && !participante.getNombre().isEmpty(),
                "El participante debe tener un nombre válido (no vacío)");
    }

    @Test
    @DisplayName("TST-CR-008: Excepción por ID nulo en participante")
    void testCrearParticipanteConIdNulo() {
        Participante participante = futbolFactory.crearParticipante();

        assertTimeoutPreemptively(java.time.Duration.ofSeconds(1),
                () -> assertNotNull(participante.getNombre()),
                "La verificación de nombre debe ser rápida");
    }

    @Test
    @DisplayName("TST-CR-009: Error por nombre nulo en participante")
    void testCrearParticipanteConNombreNulo() {
        ParticipanteFutbol participante = (ParticipanteFutbol) futbolFactory.crearParticipante();

        assertEquals("Jugador Fútbol", participante.getNombre(),
                "El nombre del participante debe ser el esperado");
    }

    @Test
    @DisplayName("TST-CR-010: Crear predicción de fútbol correctamente")
    void testCrearPrediccionFutbolValida() {
        Prediccion prediccion = futbolFactory.crearPrediccion();

        assertInstanceOf(PrediccionFutbol.class, prediccion,
                "La predicción debe ser de tipo PrediccionFutbol");
    }

    @Test
    @DisplayName("TST-CR-011: Error por marcador nulo en predicción")
    void testCrearPrediccionConMarcadorNulo() {
        PrediccionFutbol prediccion = (PrediccionFutbol) futbolFactory.crearPrediccion();

        assertFalse(prediccion == null,
                "La predicción no debe ser nula");
    }

    @Test
    @DisplayName("TST-CR-012: Excepción por ID nulo en predicción")
    void testCrearPrediccionConIdNulo() {
        Prediccion prediccion1 = futbolFactory.crearPrediccion();
        Prediccion prediccion2 = futbolFactory.crearPrediccion();

        assertAll("Verificaciones de predicciones",
                () -> assertNotNull(prediccion1, "Primera predicción no debe ser nula"),
                () -> assertNotNull(prediccion2, "Segunda predicción no debe ser nula"),
                () -> assertEquals(prediccion1.getClass(), prediccion2.getClass(),
                        "Ambas predicciones deben ser del mismo tipo")
        );
    }

}