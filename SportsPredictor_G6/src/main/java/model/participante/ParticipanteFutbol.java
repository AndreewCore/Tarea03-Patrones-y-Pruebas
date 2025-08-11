package model.participante;

import java.util.Random;

public class ParticipanteFutbol extends Participante {
    private String posicion;
    private Integer goles;

    public ParticipanteFutbol(String nombre, String posicion) {
        super(nombre);
        this.posicion = posicion;
        this.goles = 0;
    }

    @Override
    public void actualizarEstadisticas() {
        estadisticas.add(goles);
        estadisticas.add(new Random().nextInt(10)); // Pases
    }

    public void registrarGol() {
        this.goles++;
        System.out.println(nombre + " ha marcado un gol!");
    }

    public String getPosicion() {
        return posicion;
    }

}
