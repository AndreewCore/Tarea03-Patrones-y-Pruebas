package decorator;

import observer.Suscriptor;

public class Notificador implements Suscriptor {
    @Override public void update(String contexto){ 
        System.out.println("Actualizando contexto: " + contexto); 
    }
}
