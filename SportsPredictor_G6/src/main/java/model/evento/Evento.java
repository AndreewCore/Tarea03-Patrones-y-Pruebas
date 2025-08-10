package model.evento;

import model.participante.Participante;
import model.enums.EstadoEvento;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Evento {
    protected String id;
    protected String nombre;
    protected List<Participante> participantes;
    protected LocalDateTime horaComienza;
    protected List<Integer> estadisticas;
    protected EstadoEvento estado;

    public Evento(String nombre, LocalDateTime horaComienza) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.horaComienza = horaComienza;
        this.participantes = new ArrayList<>();
        this.estadisticas = new ArrayList<>();
        this.estado = EstadoEvento.PROGRAMADO;
    }

    public void iniciarEvento() {
        this.estado = EstadoEvento.EN_CURSO;
        System.out.println("Evento iniciado: " + nombre);
    }

    public void finalizarEvento() {
        this.estado = EstadoEvento.FINALIZADO;
        System.out.println("Evento finalizado: " + nombre);
    }

    public abstract void actualizarEstadisticas();

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public EstadoEvento getEstado() { return estado; }
    public List<Participante> getParticipantes() { return participantes; }

    public void agregarParticipante(Participante participante) {
        participantes.add(participante);
    }

}
