package app;

import creational.*;
import model.evento.*;
import model.participante.*;
import model.prediccion.*;
import model.usuario.Usuario;
import observer.*;
import decorator.*;
import chain.*;
import strategy.*;

public class SportsPredictor {
    public static void main(String[] args) {
        System.out.println("INICIANDO SISTEMA SPORTSPREDICTOR");
        EventoAbstractFactory futbolFactory = new FutbolFactory("Liga Futbol");
        EventoAbstractFactory basketFactory = new BasketFactory("Liga Basket");
        EventoAbstractFactory tenisFactory = new TenisFactory("Liga Tenis");

        Evento eventoFutbol = futbolFactory.crearEvento();
        Evento eventoBasket = basketFactory.crearEvento();
        Evento eventoTenis = tenisFactory.crearEvento();

        Participante jugadorFutbol = futbolFactory.crearParticipante();
        Participante jugadorBasket = basketFactory.crearParticipante();
        Participante jugadorTenis = tenisFactory.crearParticipante();

        eventoFutbol.agregarParticipante(jugadorFutbol, eventoFutbol.getEquipoLocal());
        eventoBasket.agregarParticipante(jugadorBasket, eventoBasket.getEquipoLocal());
        eventoTenis.agregarParticipante(jugadorTenis, eventoTenis.getEquipoLocal());

        Usuario usuario1 = new Usuario("Carlos", "carlos@email.com");
        Usuario usuario2 = new Usuario("María", "maria@email.com");

        EventoPublisher publisher = new EventoPublisher(eventoFutbol);
        Notificador n1 = new Notificador();

        Usuario us1 = new Usuario("Pepe", "pepe@gmail.com");
        publisher.suscribirse(n1);

        Notificador notificadorBase = new Notificador();
        Notificador notificadorCompleto = new SMS(new WhatsApp(new Correo(notificadorBase)));
        notificadorCompleto.update("¡Tu predicción ha sido procesada!");

        usuario1.realizarPrediccion(eventoFutbol, "resultado");
        usuario2.realizarPrediccion(eventoBasket, "puntaje");

        if (!usuario1.getPredicciones().isEmpty()) {
            Prediccion pred1 = usuario1.getPredicciones().get(0);
            if (pred1 instanceof PrediccionFutbol) {
                ((PrediccionFutbol) pred1).setPrediccion("2 - 1", 2, 1);
            }
        }

        System.out.println("\nSIMULANDO EVENTOS:");
        eventoFutbol.iniciarEvento();
        eventoBasket.iniciarEvento();
        eventoTenis.iniciarEvento();

        eventoFutbol.actualizarEstadisticas();
        eventoBasket.actualizarEstadisticas();
        eventoTenis.actualizarEstadisticas();

        eventoFutbol.finalizarEvento();
        eventoBasket.finalizarEvento();
        eventoTenis.finalizarEvento();

        if (eventoFutbol instanceof EventoFutbol) {
            publisher.actualizarResultado(((EventoFutbol) eventoFutbol).calcularResultado());
        }

        CalculadoraPuntaje calculadora = new CalculadoraPuntaje();
        for (Prediccion pred : usuario1.getPredicciones()) {
            pred.validarPrediccion();
            if (pred instanceof PrediccionFutbol) calculadora.usarEstrategia(new PuntajeFutbol());
            else if (pred instanceof PrediccionBasket) calculadora.usarEstrategia(new PuntajeBasket());
            else if (pred instanceof PrediccionTenis) calculadora.usarEstrategia(new PuntajeTenis());
            int pts = calculadora.ejecutarEstrategia(pred);
            usuario1.agregarPuntos(pts);
            System.out.println("Usuario " + usuario1.getNombre() + " obtuvo " + pts + " puntos");
        }

        Handler soporte = new EquipoSoporte();
        Handler calidad = new EquipoCalidad();
        soporte.setNext(calidad);

        Incidente incidenteSimple = new Incidente("Problema de login", 2, usuario1, null);
        Incidente incidenteComplejo = new Incidente("Error en cálculo de puntos", 5, usuario2, usuario2.getPredicciones().isEmpty() ? null : usuario2.getPredicciones().get(0));

        soporte.handle(incidenteSimple);
        soporte.handle(incidenteComplejo);

        model.administracion.Administrador admin = new model.administracion.Administrador("Admin Principal");
        admin.configurarOpciones();
        admin.gestionarReglas();
        admin.procesarIncidentes(incidenteComplejo);

        usuario1.consultarPuntos();
        usuario2.consultarPuntos();

        System.out.println("DEMOSTRACIÓN COMPLETADA");
    }
}
