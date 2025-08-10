package model.evento;

import java.time.LocalDateTime;
import java.util.Random;

public class EventoTenis extends Evento {
    private Integer sets;
    private Integer games;

    public EventoTenis(String nombre, LocalDateTime horaComienza) {
        super(nombre, horaComienza);
        this.sets = 0;
        this.games = 0;
    }

    @Override
    public void actualizarEstadisticas() {
        estadisticas.clear();
        estadisticas.add(new Random().nextInt(3) + 1); // Sets jugador 1
        estadisticas.add(new Random().nextInt(3) + 1); // Sets jugador 2
        System.out.println("Estadísticas de tenis actualizadas");
    }

    public String determinarGanador() {
        if (estadisticas.size() >= 2) {
            return estadisticas.get(0) > estadisticas.get(1) ? "Jugador 1" : "Jugador 2";
        }
        return "Sin determinar";
    }

}
