package chain;

public class EquipoSoporte implements Handler {
    private Handler next;

    @Override public void setNext(Handler h){ this.next = h; }

    @Override public void handle(Incidente request){
        if (puedeResolver(request)){ System.out.println("🔧 SOPORTE: Resolviendo incidente " + request.getId() + " - " + request.getDescripcion()); request.resolver(); }
        else if (next != null){ System.out.println("🔧 SOPORTE: Escalando incidente " + request.getId() + " al siguiente nivel"); next.handle(request); }
    }

    private boolean puedeResolver(Incidente r){ return r.getComplejidad() <= 3; }

}
