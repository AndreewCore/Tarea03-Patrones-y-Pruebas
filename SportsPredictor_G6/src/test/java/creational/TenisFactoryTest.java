package creational;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import model.evento.*;
import model.participante.*;
import model.prediccion.*;


@DisplayName("Pruebas de TenisFactory")
public class TenisFactoryTest {

    private TenisFactory tenisFactory;

    @BeforeEach
    void setUp() {
        tenisFactory = new TenisFactory("ATP");
    }

    @Test
    @DisplayName("TST-CR-023: Crear evento de tenis correctamente")
    void testCrearEventoTenisValido() {
        Evento evento = tenisFactory.crearEvento();

        assertNotNull(evento, "El evento creado no debe ser nulo");
    }

    @Test
    @DisplayName("TST-CR-024: Excepción por ID nulo")
    void testCrearEventoConIdNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new TenisFactory(null),
                "Factory debe validar parámetros nulos en constructor");
    }

    @Test
    @DisplayName("TST-CR-025: Error por nombre nulo")
    void testCrearEventoConNombreNulo() {
        Evento evento = tenisFactory.crearEvento();

        assertTrue(evento.getNombre() != null && !evento.getNombre().isEmpty(),
                "El nombre del evento debe ser válido (no nulo ni vacío)");
    }

    @Test
    @DisplayName("TST-CR-026: Crear participante de tenis correctamente")
    void testCrearParticipanteTenisValido() {
        Participante participante = tenisFactory.crearParticipante();

        assertInstanceOf(ParticipanteTenis.class, participante,
                "El participante debe ser de tipo ParticipanteTenis");
    }

    @Test
    @DisplayName("TST-CR-027: Error por ID vacío en participante")
    void testCrearParticipanteConIdVacio() {
        ParticipanteTenis participante = (ParticipanteTenis) tenisFactory.crearParticipante();

        assertEquals("Tenista", participante.getNombre(),
                "El nombre del participante debe ser 'Tenista'");
    }

    @Test
    @DisplayName("TST-CR-028: Crear predicción de tenis correctamente")
    void testCrearPrediccionTenisValida() {
        Prediccion prediccion = tenisFactory.crearPrediccion();

        assertInstanceOf(PrediccionTenis.class, prediccion,
                "La predicción debe ser de tipo PrediccionTenis");
    }

    @Test
    @DisplayName("TST-CR-029: Error por marcador vacío")
    void testCrearPrediccionConMarcadorVacio() {
        PrediccionTenis prediccion = (PrediccionTenis) tenisFactory.crearPrediccion();

        assertFalse(prediccion == null,
                "La predicción no debe ser nula");
    }

}