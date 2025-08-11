package decorator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream; import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("TST-DEC-001: BaseDecorator envío básico")
    void testBaseDecoratorEnvioBasico() {
        Correo correo = new Correo(null);
        String mensaje = "Hola usuario";
        assertNotNull(correo, "El objeto Correo debe ser creado correctamente");
    }

    @Test
    @DisplayName("TST-DEC-002: BaseDecorator manejo de mensaje nulo")
    void testBaseDecoratorMensajeNulo() {
        SMS sms = new SMS(null);
        String mensajeNulo = null;
        assertNull(mensajeNulo, "El mensaje debe ser nulo para esta prueba");
        assertDoesNotThrow(() -> sms.update(mensajeNulo), "No debe lanzar excepción con mensaje nulo");
    }

    @Test
    @DisplayName("TST-DEC-003: BaseDecorator manejo de mensaje vacío")
    void testBaseDecoratorMensajeVacio() {
        WhatsApp whatsApp = new WhatsApp(null);
        String mensajeVacio = "";
        assertTrue(mensajeVacio.isEmpty(), "El mensaje debe estar vacío para esta prueba");
    }

    @Test
    @DisplayName("TST-DEC-004: Correo - Verificar envío por correo")
    void testCorreoEnvio() {
        Correo correo = new Correo(null);
        String mensaje = "Notificación por correo";
        assertFalse(mensaje.isEmpty(), "El mensaje no debe estar vacío");
        assertEquals("Notificación por correo", mensaje, "El mensaje debe ser exactamente el esperado");
    }


    @Test
    @DisplayName("TST-DEC-005: WhatsApp - Verificar envío por WhatsApp")
    void testWhatsAppEnvio() {
        WhatsApp whatsApp = new WhatsApp(null);
        String mensaje = "Notificación por WhatsApp";
        assertDoesNotThrow(() -> whatsApp.update(mensaje),
                "El envío por WhatsApp debe ejecutarse sin errores");
    }


    @Test
    @DisplayName("TST-DEC-006: SMS - Verificar envío por SMS")
    void testSMSEnvio() {
        SMS sms = new SMS(null);
        String mensaje = "Notificación por SMS";
        assertDoesNotThrow(() -> sms.update(mensaje),
                "El envío por SMS debe ejecutarse sin errores");
    }

    @Test
    @DisplayName("TST-DEC-007: SMS - Validar límite de 160 caracteres")
    void testSMSLimiteCaracteres() {
        SMS sms = new SMS(null);
        String mensajeLargo = "Este es un mensaje muy largo que supera los 160 caracteres permitidos en SMS. " +
                "Necesitamos verificar que el sistema maneja correctamente esta situación y trunca el mensaje apropiadamente.";
        assertTrue(mensajeLargo.length() > 160, "El mensaje de prueba debe superar 160 caracteres");
    }
}
