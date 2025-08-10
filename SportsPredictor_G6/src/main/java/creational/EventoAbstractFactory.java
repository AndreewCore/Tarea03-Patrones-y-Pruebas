package creational;

import model.evento.Evento;
import model.participante.Participante;
import model.prediccion.Prediccion;

public interface EventoAbstractFactory {
    Evento crearEvento();
    Participante crearParticipante();
    Prediccion crearPrediccion();
}
