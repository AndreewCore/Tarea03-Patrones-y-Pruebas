package observer;

import model.usuario.Usuario;

public class UsuarioSuscriptor implements Suscriptor {
    private Usuario usuario;

    public UsuarioSuscriptor(Usuario usuario) { this.usuario = usuario; }

    @Override public void update(String mensaje) { System.out.println("📧 " + usuario.getNombre() + " recibió notificación: " + mensaje); }

    public Usuario getUsuario() { return usuario; }

}
