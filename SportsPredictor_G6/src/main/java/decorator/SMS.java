package decorator;

public class SMS extends BaseDecorator {
    public SMS(Notificador n){ super(n); }

    @Override public void enviar(String mensaje){ super.enviar(mensaje); System.out.println("📱 Enviando por SMS: " + mensaje); }

}
