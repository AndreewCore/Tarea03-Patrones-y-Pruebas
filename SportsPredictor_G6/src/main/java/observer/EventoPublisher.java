package observer;

import model.evento.Evento;

public class EventoPublisher extends Publisher {
    private Evento evento;
    private String resultado;

    public EventoPublisher(Evento evento) { 
        this.evento = evento; 
    }

    public void actualizarResultado(String nuevoResultado) {
        this.resultado = nuevoResultado;
        this.estadoPrincipal = "Evento " + evento.getNombre() + " - Resultado: " + resultado;
        notificarCambio();
    }

    public void notificarCambio() {
        System.out.println("Notificando cambio en evento: " + evento.getNombre()); 
        notificarSuscriptor();
    }

}
