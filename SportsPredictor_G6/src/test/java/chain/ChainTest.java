package chain;

import model.enums.EstadoPrediccion;
import model.prediccion.PrediccionFutbol;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream; import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class ChainTest {
    @Test
    @DisplayName("TST-COR-001: EquipoSoporte.handle con incidente nivel 1 - resuelto por soporte")
    void testSoporteResuelveNivel1() {
        EquipoSoporte soporte = new EquipoSoporte();
        Incidente incidente = new Incidente("Incidente básico", 1, null, null);
        soporte.handle(incidente);
        assertEquals("RESUELTO", incidente.getEstado());
    }

    @Test
    @DisplayName("TST-COR-002: EquipoSoporte.handle con incidente complejo - escalado correctamente")
    void testSoporteEscalaIncidenteComplejo() {
        EquipoSoporte soporte = new EquipoSoporte();
        EquipoCalidad calidad = new EquipoCalidad();
        soporte.setNext(calidad);
        Incidente incidente = new Incidente("Incidente complejo", 4, null, null);
        soporte.handle(incidente);
        assertEquals("RESUELTO", incidente.getEstado());
    }

    @Test
    @DisplayName("TST-COR-003: setNext configura correctamente la cadena")
    void testSetNextConfiguraCadena() {
        EquipoSoporte soporte = new EquipoSoporte();
        EquipoCalidad calidad = new EquipoCalidad();
        soporte.setNext(calidad);
        Incidente incidente = new Incidente("Incidente para cadena", 4, null, null);
        assertDoesNotThrow(() -> soporte.handle(incidente));
        assertEquals("RESUELTO", incidente.getEstado());
    }

    @Test
    @DisplayName("TST-COR-004: EquipoSoporte.handle con request null - error por request nulo")
    void testSoporteConRequestNulo() {
        EquipoSoporte soporte = new EquipoSoporte();
        assertThrows(NullPointerException.class, () -> soporte.handle(null));
    }

    @Test
    @DisplayName("TST-COR-005: EquipoCalidad.handle con incidente nivel 2 - resuelto por calidad")
    void testCalidadResuelveNivel2() {
        EquipoCalidad calidad = new EquipoCalidad();
        Incidente incidente = new Incidente("Incidente nivel 2", 2, null, null);
        calidad.handle(incidente);
        assertEquals("RESUELTO", incidente.getEstado());
    }

    @Test
    @DisplayName("TST-COR-006: EquipoCalidad.handle con incidente crítico - resuelto por calidad")
    void testCalidadResuelveCritico() {
        EquipoCalidad calidad = new EquipoCalidad();
        PrediccionFutbol pred = new PrediccionFutbol();
        pred.setEstado(EstadoPrediccion.PENDIENTE);
        Incidente incidente = new Incidente("Incidente crítico", 5, null, pred);
        calidad.handle(incidente);
        assertEquals("RESUELTO", incidente.getEstado());
        assertEquals(EstadoPrediccion.EN_REVISION, pred.getEstado());
    }

}
