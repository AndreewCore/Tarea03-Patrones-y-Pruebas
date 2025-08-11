//package decorator;
//
//import org.junit.jupiter.api.Test;
//import java.io.ByteArrayOutputStream; import java.io.PrintStream;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class DecoratorTest {
//    @Test public void testDecorator() {
//        ByteArrayOutputStream out = new ByteArrayOutputStream(); PrintStream orig = System.out; System.setOut(new PrintStream(out));
//        Notificador base = new NotificadorBase();
//        Notificador comp = new SMS(new WhatsApp(new Correo(base)));
//        comp.enviar("hola"); System.setOut(orig);
//        String s = out.toString();
//        assertTrue(s.contains("📧 Enviando por CORREO")); assertTrue(s.contains("💬 Enviando por WHATSAPP")); assertTrue(s.contains("📱 Enviando por SMS"));
//    }
//
//}
