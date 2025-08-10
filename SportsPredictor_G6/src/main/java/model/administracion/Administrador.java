package model.administracion;

import chain.Incidente;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Administrador {
    private String id;
    private String nombre;
    private List<String> permisos;

    public Administrador(String nombre){ this.id = UUID.randomUUID().toString(); this.nombre = nombre; this.permisos = new ArrayList<>(); this.permisos.addAll(Arrays.asList("CONFIGURAR","GESTIONAR","RESOLVER")); }

    public void configurarOpciones(){ System.out.println("👨‍💼 " + nombre + " configurando opciones del sistema"); }

    public void gestionarReglas(){ System.out.println("👨‍💼 " + nombre + " gestionando reglas de puntuación"); }

    public void procesarIncidentes(Incidente incidente){ System.out.println("👨‍💼 " + nombre + " procesando incidente: " + incidente.getDescripcion()); }

}
