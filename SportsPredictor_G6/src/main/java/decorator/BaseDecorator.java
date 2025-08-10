package decorator;

public abstract class BaseDecorator extends Notificador {
    protected Notificador envolviendo;

    public BaseDecorator(Notificador n){ 
        this.envolviendo = n; 
    }

    @Override public void update(String contexto){ 
        if(envolviendo!=null) envolviendo.update(contexto); 
    }

}
