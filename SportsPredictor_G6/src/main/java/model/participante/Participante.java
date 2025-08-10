package model.participante;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Participante {
    protected String id;
    protected String nombre;
    protected List<Integer> estadisticas;

    public Participante(String nombre) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.estadisticas = new ArrayList<>();
    }

    public abstract void actualizarEstadisticas();

    public String getNombre() { return nombre; }

}
