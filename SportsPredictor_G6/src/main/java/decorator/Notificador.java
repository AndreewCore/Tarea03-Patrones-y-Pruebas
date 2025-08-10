package decorator;

public class Notificador implements Suscriptor {
    @Override public void update(String contexto){ 
        System.out.println("Actualizando contexto: " + contexto); 
    }

    Override public void enviar(String mensaje){ 
        System.out.println("Enviando notificación base: " + mensaje); 
    }

}
