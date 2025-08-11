package model.administracion;

import chain.Incidente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest2 {
    @Test
    @DisplayName("ADM-001: configurarOpciones() con admin válido → no lanza error")
    void testConfigurarOpciones() {
        Administrador admin = new Administrador("Alice");
        assertDoesNotThrow(admin::configurarOpciones);
    }

    @Test
    @DisplayName("ADM-002: gestionarReglas() con admin válido → no lanza error")
    void testGestionarReglas() {
        Administrador admin = new Administrador("Alice");
        assertDoesNotThrow(admin::gestionarReglas);
    }

    @Test
    @DisplayName("ADM-003: procesarIncidentes() con incidente válido → no lanza error")
    void testProcesarIncidenteValido() {
        Administrador admin = new Administrador("Alice");
        Incidente incidente = new Incidente("Incidente de prueba", 2, null, null);
        assertDoesNotThrow(() -> admin.procesarIncidentes(incidente));
    }

    @Test
    @DisplayName("ADM-004: procesarIncidentes(null) → error por incidente nulo")
    void testProcesarIncidenteNulo() {
        Administrador admin = new Administrador("Alice");
        assertThrows(NullPointerException.class, () -> admin.procesarIncidentes(null));
    }

}