package observer;

import java.util.HashMap;
import java.util.Map;

public class SistemaRanking implements Suscriptor {
    private HashMap<String,Integer> rankings = new HashMap<>();

    public void actualizarRanking(String usuario, Integer puntos){ rankings.put(usuario, rankings.getOrDefault(usuario,0)+puntos); System.out.println("Ranking actualizado para " + usuario); }

    @Override public void update(String mensaje){ System.out.println("🏆 Sistema de Ranking procesando: " + mensaje); }

    public void mostrarRanking(){ System.out.println("\n=== RANKING ACTUAL ==="); rankings.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).forEach(e->System.out.println(e.getKey()+": "+e.getValue()+" puntos")); }

}
