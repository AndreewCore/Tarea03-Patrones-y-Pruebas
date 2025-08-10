package creational;

import model.evento.*;
import model.participante.*;
import model.prediccion.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BasketFactory implements EventoAbstractFactory {
    private ArrayList<Participante> equipoCasa = new ArrayList<>();
    private ArrayList<Participante> equipoInvitado = new ArrayList<>();
    private String liga;

    public BasketFactory(String liga) { 
        this.liga = liga; 
    }

    @Override
    public Evento crearEvento() {
        return new EventoBasket("Partido de Básquet - " + 
                                liga, LocalDateTime.now().plusDays(1));
    }

    @Override
    public Participante crearParticipante() {
        return new ParticipanteBasket("Jugador Basket", "Alero");
    }

    @Override
    public Prediccion crearPrediccion() {
        return new PrediccionBasket();
    }

}
