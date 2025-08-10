package model.participante;

public class ParticipanteBasket extends Participante {
    private Integer puntos;
    private Integer canastas;

    public ParticipanteBasket(String nombre, String posicion) {
        super(nombre);
        this.puntos = 0;
        this.canastas = 0;
    }

    @Override
    public void actualizarEstadisticas() {
        estadisticas.add(puntos);
        estadisticas.add(canastas);
    }

    public void registrarPunto() {
        this.puntos += 1;
        System.out.println(" ha anotado otro puntos!");
    }

}
