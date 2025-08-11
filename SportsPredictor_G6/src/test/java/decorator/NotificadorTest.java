package decorator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificadorTest {
    @Test
    @DisplayName("TST-NOT-001: update() con mensaje válido actualiza contexto")
    void testUpdateConMensajeValido() {
        Notificador notificador = new Notificador();
        assertDoesNotThrow(() -> notificador.update("Nuevo resultado disponible"));
    }

    @Test
    @DisplayName("TST-NOT-002: update() con null debe lanzar error")
    void testUpdateConNullDebeLanzarError() {
        Notificador notificador = new Notificador();
        assertThrows(IllegalArgumentException.class, () -> notificador.update(null));
    }

}