package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher {
    protected List<Suscriptor> suscriptores = new ArrayList<>();
    protected String estadoPrincipal;

    public void suscribirse(Suscriptor s) {
        suscriptores.add(s);
        System.out.println("Nuevo suscriptor agregado");
    }

    public void desuscribirse(Suscriptor s) {
        suscriptores.remove(s);
        System.out.println("Suscriptor removido");
    }

    public void notificarSuscriptor() {
        for (Suscriptor s : suscriptores) s.update(estadoPrincipal);
    }

}
