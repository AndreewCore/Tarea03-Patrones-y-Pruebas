package model.participante;

public class ParticipanteTenis extends Participante {
    private Integer ranking;
    private Integer sets;

    public ParticipanteTenis(String nombre, Integer ranking) {
        super(nombre);
        this.ranking = ranking;
        this.sets = 0;
    }

    @Override
    public void actualizarEstadisticas() {
        estadisticas.add(sets);
        estadisticas.add(ranking);
    }

    public void ganarSet() {
        this.sets++;
        System.out.println(nombre + " ha ganado un set!");
    }

}
