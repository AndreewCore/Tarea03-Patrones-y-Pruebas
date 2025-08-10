package model.evento;

import model.participante.Participante;
import model.enums.EstadoEvento;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import creational.BasketFactory;
import creational.EventoAbstractFactory;
import creational.FutbolFactory;
import creational.TenisFactory;

public abstract class Evento {
    protected String id;
    protected String nombre;
    protected List<Participante> EquipoLocal;
    protected List<Participante> EquipoVisitante;
    protected LocalDateTime horaComienza;
    protected List<Integer> estadisticas;
    protected int duracion;
    protected String lugar;
    protected EstadoEvento estado;

    public Evento(String nombre, LocalDateTime horaComienza) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.EquipoLocal = new ArrayList<>();
        this.EquipoVisitante = new ArrayList<>();
        this.horaComienza = horaComienza;
        this.estadisticas = new ArrayList<>();
        this.lugar = "Mi casa padre";
        this.estado = EstadoEvento.PROGRAMADO;
    }

    public EventoAbstractFactory obtenerFactory(Evento evento){
        if (evento instanceof model.evento.EventoFutbol)
            return new FutbolFactory("Liga Futbol");
        else if (evento instanceof model.evento.EventoBasket)
            return new BasketFactory("Liga Basket");
        else if (evento instanceof model.evento.EventoTenis)
            return new TenisFactory("Liga Tenis");
        return null;
    }

    public void agregarParticipante(Participante p, List<Participante> Equipo){
        Equipo.add(p);
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
    public abstract String calcularResultado();

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Participante> getEquipoLocal() {
        return EquipoLocal;
    }

    public void setEquipoLocal(List<Participante> equipoLocal) {
        EquipoLocal = equipoLocal;
    }

    public List<Participante> getEquipoVisitante() {
        return EquipoVisitante;
    }

    public void setEquipoVisitante(List<Participante> equipoVisitante) {
        EquipoVisitante = equipoVisitante;
    }

    public LocalDateTime getHoraComienza() {
        return horaComienza;
    }

    public void setHoraComienza(LocalDateTime horaComienza) {
        this.horaComienza = horaComienza;
    }

    public List<Integer> getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(List<Integer> estadisticas) {
        this.estadisticas = estadisticas;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setEstado(EstadoEvento estado) {
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoEvento getEstado() {
        return estado;
    }
}
