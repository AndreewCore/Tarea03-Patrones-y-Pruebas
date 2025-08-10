package model.evento;

import java.time.LocalDateTime;
import java.util.Random;

public class EventoBasket extends Evento {
    private Integer cuartos;
    private Integer puntajeFinal;

    public EventoBasket(String nombre, LocalDateTime horaComienza) {
        super(nombre, horaComienza);
        this.cuartos = 4;
        this.puntajeFinal = 0;
    }

    @Override
    public void actualizarEstadisticas() {
        estadisticas.clear();
        estadisticas.add(80 + new Random().nextInt(40)); // Puntos local
        estadisticas.add(80 + new Random().nextInt(40)); // Puntos visitante
        System.out.println("Estadísticas de básquet actualizadas");
    }

    public Integer calcularPuntaje() {
        return estadisticas.stream().mapToInt(Integer::intValue).sum();
    }

}
