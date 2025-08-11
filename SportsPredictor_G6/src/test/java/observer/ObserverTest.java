package observer;

import decorator.*;
import model.evento.Evento;
import model.evento.EventoFutbol;
import model.usuario.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.io.ByteArrayOutputStream; import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {
    private EventoPublisher publisher;
    private Evento evento;
    private Notificador notificador1;
    private Notificador notificador2;

    @BeforeEach
    void setUp() {
        evento = new EventoFutbol("Final Copa", LocalDateTime.now());
        publisher = new EventoPublisher(evento);
        notificador1 = new Notificador();
        notificador2 = new Notificador();
    }

    @Test
    @DisplayName("TST-OBS-001: Validar suscripción")
    void testSuscribirseConSuscriptorValido() {
        int sizeBefore = publisher.suscriptores.size();
        publisher.suscribirse(notificador1);
        assertEquals(sizeBefore + 1, publisher.suscriptores.size());
        assertTrue(publisher.suscriptores.contains(notificador1));
    }

    @Test
    @DisplayName("TST-OBS-002: Validar manejo de suscriptor nulo")
    void testSuscribirseConSuscriptorNulo() {
        Suscriptor suscriptorNulo = null;
        assertDoesNotThrow(() -> publisher.suscribirse(suscriptorNulo));
    }

    @Test
    @DisplayName("TST-OBS-003: Validar manejo de duplicados")
    void testSuscribirseConSuscriptorDuplicado() {
        publisher.suscribirse(notificador1);
        int sizeAfterFirst = publisher.suscriptores.size();
        publisher.suscribirse(notificador1);
        assertEquals(sizeAfterFirst + 1, publisher.suscriptores.size());
    }

    @Test
    @DisplayName("TST-OBS-004: Validar desuscripción")
    void testDesuscribirseConSuscriptorExistente() {
        publisher.suscribirse(notificador1);
        int sizeAfterSubscribe = publisher.suscriptores.size();
        publisher.desuscribirse(notificador1);
        assertEquals(sizeAfterSubscribe - 1, publisher.suscriptores.size());
        assertFalse(publisher.suscriptores.contains(notificador1));
    }

    @Test
    @DisplayName("TST-OBS-005: Validar desuscripción de inexistente")
    void testDesuscribirseConSuscriptorInexistente() {
        Notificador suscriptorInexistente = new Notificador();
        int sizeBefore = publisher.suscriptores.size();
        publisher.desuscribirse(suscriptorInexistente);
        assertEquals(sizeBefore, publisher.suscriptores.size());
    }

    @Test
    @DisplayName("TST-OBS-006: Validar notificación masiva")
    void testNotificarSuscriptorConResultadoActualizado() {
        publisher.suscribirse(notificador1);
        publisher.suscribirse(notificador2);
        assertDoesNotThrow(() -> publisher.actualizarResultado("Resultado actualizado"));
        assertEquals(2, publisher.suscriptores.size());
    }

    @Test
    @DisplayName("TST-OBS-007: Validar manejo de mensaje nulo")
    void testNotificarSuscriptorConMensajeNulo() {
        publisher.suscribirse(notificador1);
        assertDoesNotThrow(() -> publisher.actualizarResultado(null));
    }

    @Test
    @DisplayName("TST-OBS-008: Validar manejo de mensaje vacío")
    void testNotificarSuscriptorConMensajeVacio() {
        publisher.suscribirse(notificador1);
        assertDoesNotThrow(() -> publisher.actualizarResultado(""));
    }

}
