package chain;

import model.prediccion.Prediccion;
import model.usuario.Usuario;
import java.util.UUID;

public class Incidente {
    private String id;
    private String descripcion;
    private Integer complejidad;
    private Usuario usuario;
    private Prediccion prediccion;
    private String estado;

    public Incidente(String descripcion, Integer complejidad, Usuario usuario, Prediccion prediccion){
        this.id = UUID.randomUUID().toString(); this.descripcion = descripcion; this.complejidad = complejidad; this.usuario = usuario; this.prediccion = prediccion; this.estado = "ABIERTO";
    }

    public void escalar(){ this.complejidad++; System.out.println("Incidente " + id + " escalado a complejidad " + complejidad); }

    public void resolver(){ this.estado = "RESUELTO"; System.out.println("✅ Incidente " + id + " resuelto"); }

    public String getId(){ return id; } public String getDescripcion(){ return descripcion; } public Integer getComplejidad(){ return complejidad; } public Usuario getUsuario(){ return usuario; } public Prediccion getPrediccion(){ return prediccion; } public String getEstado(){ return estado; }

}
