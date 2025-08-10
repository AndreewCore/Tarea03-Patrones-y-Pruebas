package decorator;

public class SMS extends BaseDecorator {
    public SMS(Notificador n){
        super(n);
    }

    @Override public void update(String mensaje){ 
        super.update(mensaje);
        System.out.println(" Enviando actualización por SMS: " + mensaje); 
    }

}
