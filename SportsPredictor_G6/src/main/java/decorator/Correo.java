package decorator;

public class Correo extends BaseDecorator {
    public Correo(Notificador n){ super(n); }

    @Override public void enviar(String mensaje){ super.enviar(mensaje); System.out.println("📧 Enviando por CORREO: " + mensaje); }

}
