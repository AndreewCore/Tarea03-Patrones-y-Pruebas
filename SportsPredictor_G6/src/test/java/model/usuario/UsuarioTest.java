package model.usuario;

import model.prediccion.PrediccionFutbol;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    @Test
    @DisplayName("TST-USR-001: Constructor válido - Usuario creado correctamente")
    void testConstructorValidoUsuarioCreado() {
        Usuario u = new Usuario("Juan Pérez", "juan@email.com");
        u.getPredicciones().add(new PrediccionFutbol());
        u.agregarPuntos(10);
        assertNotNull(u);
        assertTrue(u.getPuntosTotales() > 0);
    }

    @Test
    @DisplayName("TST-USR-002: ID vacío - debe lanzar error")
    void testIdVacioDebeLanzarError() {
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario("Juan Pérez", "juan@email.com"));
    }

    @Test
    @DisplayName("TST-USR-003: Nombre nulo - debe lanzar error")
    void testNombreNuloDebeLanzarError() {
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario(null, "juan@email.com"));
    }

    @Test
    @DisplayName("TST-USR-004: Email inválido - debe lanzar error")
    void testEmailInvalidoDebeLanzarError() {
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario("Juan", "email_invalido"));
    }

    @Test
    @DisplayName("TST-USR-005: Predicciones nulas - debe lanzar error")
    void testPrediccionesNulasDebeLanzarError() {
        Usuario u = new Usuario("Juan", "juan@email.com");
        assertThrows(NullPointerException.class,
                () -> u.getPredicciones().addAll(null));
    }

}