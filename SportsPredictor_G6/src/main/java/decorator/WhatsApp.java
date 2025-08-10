package decorator;

public class WhatsApp extends BaseDecorator {
    public WhatsApp(Notificador n){ super(n); }

    @Override public void enviar(String mensaje){ super.enviar(mensaje); System.out.println("💬 Enviando por WHATSAPP: " + mensaje); }

}
