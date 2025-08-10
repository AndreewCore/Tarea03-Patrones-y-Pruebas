package creational;

import model.evento.*;
import model.participante.*;
import model.prediccion.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FutbolFactory implements EventoAbstractFactory {
    private ArrayList<Participante> equipoCasa = new ArrayList<>();
    private ArrayList<Participante> equipoInvitado = new ArrayList<>();
    private String liga;

    public FutbolFactory(String liga) { this.liga = liga; }

    @Override
    public Evento crearEvento() {
        return new EventoFutbol("Partido de Fútbol - " + liga, LocalDateTime.now().plusDays(1));
    }

    @Override
    public Participante crearParticipante() {
        return new ParticipanteFutbol("Jugador Fútbol", "Delantero");
    }

    @Override
    public Prediccion crearPrediccion() {
        return new PrediccionFutbol();
    }

}
