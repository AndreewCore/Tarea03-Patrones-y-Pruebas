package creational;

import model.evento.Evento;
import model.participante.Participante;
import model.prediccion.Prediccion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FutbolFactoryTest {
    @Test
    public void testFactoryCreates() {
        EventoAbstractFactory f = new FutbolFactory("LigaTest");
        Evento e = f.crearEvento();
        Participante p = f.crearParticipante();
        Prediccion pred = f.crearPrediccion();
        assertNotNull(e); assertNotNull(p); assertNotNull(pred);
        assertTrue(e.getNombre().contains("Fútbol") || e.getNombre().contains("Futbol"));
    }

}
