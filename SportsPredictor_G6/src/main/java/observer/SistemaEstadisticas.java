package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaEstadisticas implements Suscriptor {
    private List<Integer> estadisticas = new ArrayList<>();

    public void procesarNuevosResultados(){ estadisticas.add(new Random().nextInt(100)); System.out.println("Nuevas estadísticas procesadas"); }

    @Override public void update(String mensaje){ System.out.println("📊 Sistema de Estadísticas procesando: " + mensaje); procesarNuevosResultados(); }

}
