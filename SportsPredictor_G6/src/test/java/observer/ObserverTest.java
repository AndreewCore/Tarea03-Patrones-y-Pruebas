//package observer;
//
//import model.evento.EventoFutbol;
//import model.usuario.Usuario;
//import org.junit.jupiter.api.Test;
//import java.time.LocalDateTime;
//import java.io.ByteArrayOutputStream; import java.io.PrintStream;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ObserverTest {
//    @Test
//    public void testNotificacion() {
//        EventoFutbol e = new EventoFutbol("Test", LocalDateTime.now());
//        EventoPublisher pub = new EventoPublisher(e);
//        Usuario u = new Usuario("Ana","a@b.com");
//        UsuarioSuscriptor us = new UsuarioSuscriptor(u);
//        ByteArrayOutputStream out = new ByteArrayOutputStream(); PrintStream orig = System.out; System.setOut(new PrintStream(out));
//        pub.suscribirse(us);
//        pub.actualizarResultado("1 - 0");
//        System.setOut(orig);
//        String o = out.toString();
//        assertTrue(o.contains("Notificando cambio") || o.contains("recibió notificación"));
//    }
//
//}
