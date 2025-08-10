package model.prediccion;

import model.usuario.Usuario;
import model.evento.Evento;
import model.enums.EstadoPrediccion;
import java.util.UUID;

public abstract class Prediccion {
    protected String id;
    protected Usuario usuario;
    protected Evento evento;
    protected EstadoPrediccion estado;
    protected Integer puntos;

    public Prediccion() {
        this.id = UUID.randomUUID().toString();
        this.estado = EstadoPrediccion.PENDIENTE;
        this.puntos = 0;
    }

    public abstract void validarPrediccion();
    public abstract Integer calcularPuntos();

    public String getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }
    public EstadoPrediccion getEstado() { return estado; }
    public void setEstado(EstadoPrediccion estado) { this.estado = estado; }
    public Integer getPuntos() { return puntos; }

}
