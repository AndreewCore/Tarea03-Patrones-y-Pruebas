package decorator;

public class Correo extends BaseDecorator {
    public Correo(Notificador n){ 
        super(n);
    }

    @Override public void update(String mensaje){ 
        super.update(mensaje);
        System.out.println(" Enviando actualización por CORREO: " + mensaje); 
    }

}
