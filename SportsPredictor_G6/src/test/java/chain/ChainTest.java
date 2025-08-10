package chain;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream; import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class ChainTest {
    @Test public void testChain() {
        ByteArrayOutputStream out = new ByteArrayOutputStream(); PrintStream orig = System.out; System.setOut(new PrintStream(out));
        EquipoSoporte s = new EquipoSoporte(); EquipoCalidad c = new EquipoCalidad(); s.setNext(c);
        model.usuario.Usuario u = new model.usuario.Usuario("T","t@t.com");
        Incidente simple = new Incidente("s",2,u,null);
        Incidente comp = new Incidente("c",5,u,null);
        s.handle(simple); s.handle(comp);
        System.setOut(orig);
        String o = out.toString();
        assertTrue(o.contains("Resolviendo incidente") || o.contains("Escalando incidente"));
    }

}
