package decorator;

public abstract class BaseDecorator implements Notificador {
    protected Notificador envolviendo;

    public BaseDecorator(Notificador n){ this.envolviendo = n; }

    @Override public void update(String contexto){ if(envolviendo!=null) envolviendo.update(contexto); }

    @Override public void enviar(String mensaje){ if(envolviendo!=null) envolviendo.enviar(mensaje); }

}
