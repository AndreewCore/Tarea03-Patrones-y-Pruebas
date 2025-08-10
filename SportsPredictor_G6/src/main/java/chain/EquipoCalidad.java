package chain;

public class EquipoCalidad implements Handler {
    private Handler next;

    @Override public void setNext(Handler h){ 
        this.next = h; 
    }

    @Override public void handle(Incidente request){
        System.out.println(" Resolviendo incidente complejo " + 
                           request.getId() + " - " + request.getDescripcion()); resolverIncidente(request); 
    }

    private void resolverIncidente(Incidente request){ 
        request.resolver(); 
        if (request.getPrediccion() != null) request.getPrediccion().setEstado(model.enums.EstadoPrediccion.EN_REVISION); 
    }

}
