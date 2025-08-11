package model.evento;

import model.enums.EstadoEvento;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EventoTest {
    @Test
    @DisplayName("TST-DOM-001: Constructor válido - Evento creado y PROGRAMADO")
    void testConstructorValido() {
        EventoFutbol e = new EventoFutbol("Partido Final", LocalDateTime.now());
        assertNotNull(e.getId());
        assertEquals(EstadoEvento.PROGRAMADO, e.getEstado());
    }

    @Test
    @DisplayName("TST-DOM-002: ID nulo - debe lanzar error")
    void testIdNuloDebeLanzarError() {
        EventoFutbol e = new EventoFutbol("Partido", LocalDateTime.now());
        assertThrows(IllegalArgumentException.class, () -> e.setId(null));
    }

    @Test
    @DisplayName("TST-DOM-003: Nombre nulo - debe lanzar error")
    void testNombreNuloDebeLanzarError() {
        assertThrows(IllegalArgumentException.class, () -> new EventoFutbol(null, LocalDateTime.now()));
    }

    @Test
    @DisplayName("TST-DOM-004: Participantes nulos - debe lanzar error")
    void testParticipantesNulosDebeLanzarError() {
        EventoFutbol e = new EventoFutbol("Partido", LocalDateTime.now());
        assertThrows(IllegalArgumentException.class, () -> e.setEquipoLocal(null));
        assertThrows(IllegalArgumentException.class, () -> e.setEquipoVisitante(null));
    }

    @Test
    @DisplayName("TST-DOM-005: Listas de participantes vacías - debe lanzar error")
    void testListasVaciasDebeLanzarError() {
        EventoFutbol e = new EventoFutbol("Partido", LocalDateTime.now());
        assertThrows(IllegalArgumentException.class, () -> e.setEquipoLocal(new ArrayList<>()));
        assertThrows(IllegalArgumentException.class, () -> e.setEquipoVisitante(new ArrayList<>()));
    }

}