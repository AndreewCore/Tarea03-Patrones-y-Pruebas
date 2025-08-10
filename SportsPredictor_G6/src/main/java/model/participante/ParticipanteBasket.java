package model.participante;

public class ParticipanteBasket extends Participante {
    private Integer puntos;
    private Integer rebotes;

    public ParticipanteBasket(String nombre, String posicion) {
        super(nombre);
        this.puntos = 0;
        this.rebotes = 0;
    }

    @Override
    public void actualizarEstadisticas() {
        estadisticas.add(puntos);
        estadisticas.add(rebotes);
    }

    public void registrarPunto() {
        this.puntos += 2;
        System.out.println(nombre + " ha anotado 2 puntos!");
    }

}
