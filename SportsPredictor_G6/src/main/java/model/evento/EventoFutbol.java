package model.evento;

import java.time.LocalDateTime;
import java.util.Random;

public class EventoFutbol extends Evento {
    private Boolean penales;
    private Boolean tiempoExtra;
    private int golesVisitante;
    private int golesLocal;

    public EventoFutbol(String nombre, LocalDateTime horaComienza) {
        super(nombre, horaComienza);
        this.penales = false;
        this.tiempoExtra = false;
        this.golesVisitante = 0;
        this.golesLocal = 0;
    }

    @Override
    public void actualizarEstadisticas() {
        estadisticas.clear();
        estadisticas.add(new Random().nextInt(5)); // Goles local
        estadisticas.add(new Random().nextInt(5)); // Goles visitante
        System.out.println("Estadísticas de fútbol actualizadas");
    }

    public String calcularResultado() {
        if (estadisticas.size() >= 2) {
            int golesLocal = estadisticas.get(0);
            int golesVisitante = estadisticas.get(1);
            return golesLocal + " - " + golesVisitante;
        }
        return "0 - 0";
    }

}
