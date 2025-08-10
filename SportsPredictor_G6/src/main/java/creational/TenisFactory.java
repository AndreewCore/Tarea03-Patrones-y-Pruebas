package creational;

import model.evento.*;
import model.participante.*;
import model.prediccion.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TenisFactory implements EventoAbstractFactory {
    private ArrayList<Participante> equipoCasa = new ArrayList<>();
    private ArrayList<Participante> equipoInvitado = new ArrayList<>();
    private String liga;

    public TenisFactory(String liga) { this.liga = liga; }

    @Override
    public Evento crearEvento() {
        return new EventoTenis("Partido de Tenis - " + liga, LocalDateTime.now().plusDays(1));
    }

    @Override
    public Participante crearParticipante() {
        return new ParticipanteTenis("Tenista", 50);
    }

    @Override
    public Prediccion crearPrediccion() {
        return new PrediccionTenis();
    }

}
