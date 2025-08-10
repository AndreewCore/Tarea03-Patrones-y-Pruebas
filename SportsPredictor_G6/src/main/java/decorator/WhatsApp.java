package decorator;

public class WhatsApp extends BaseDecorator {
    public WhatsApp(Notificador n){ super(n); }

    @Override public void update(String mensaje){ 
        super.update(mensaje);
        System.out.println(" Enviando actualización por WhatsApp: " + mensaje); 
    }

}
