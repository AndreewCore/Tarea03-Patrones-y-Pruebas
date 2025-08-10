package model.evento;

import java.time.LocalDateTime;
import java.util.Random;

public class EventoBasket extends Evento {
    private Boolean desempate;
    private Boolean tiempoExtra;
    private int puntosLocal;
    private int puntosVisitante;

    public EventoBasket(String nombre, LocalDateTime horaComienza) {
        super(nombre, horaComienza);
        this.desempate = false;
        this.tiempoExtra = false;
        this.puntosLocal = 0;
        this.puntosLocal = 0;
    }

    @Override
    public void actualizarEstadisticas() {
        estadisticas.clear();
        estadisticas.add(80 + new Random().nextInt(40)); // Puntos local
        estadisticas.add(80 + new Random().nextInt(40)); // Puntos visitante
        System.out.println("Estadísticas de básquet actualizadas");
    }

    @Override
    public String calcularResultado() {
        return estadisticas.stream().mapToInt(Integer::intValue).sum() + "";
    }

}
