import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class BaseDeDatosUsuario {
private Map<String, Usuario> usuarios;

public BaseDeDatosUsuario() {
	this.usuarios = new HashMap<>();
	
}
public void agregarUsuario(Usuario u) {
	usuarios.put(u.getUsuario(), u);
}

public Usuario obtenerUsuario(String usuario) throws UsuarioInexistenteException {
    Usuario u = usuarios.get(usuario);
    if (u == null) {
        throw new UsuarioInexistenteException("No se encontro usuario");
    }
    return u;
}

public void eliminarUsuario(String usuario) throws ClassCastException, UsuarioInexistenteException {
    Usuario u = usuarios.get(usuario);
    if (u == null) {
        throw new UsuarioInexistenteException("No existe");
    }
    if (!(u instanceof Eliminable)) {
        throw new ClassCastException("No se puede eliminar");
    }
    ((Eliminable) u).eliminarUsuario(usuario);
    usuarios.remove(usuario);
}

public void bloquearUsuario(String usuario) throws ClassCastException, UsuarioInexistenteException {
    Usuario u = usuarios.get(usuario);
    if (u == null) {
        throw new UsuarioInexistenteException("No existe");
    }
    if (!(u instanceof Bloqueable)) {
        throw new ClassCastException("No se puede bloquear");
    }
    ((Bloqueable) u).bloquearUsuario();
}

public List<Usuario> obtenerUsuariosOrdenados() {
    ArrayList usuariosLista = new ArrayList<Usuario>(usuarios.values());
    Collections.sort(usuariosLista);
    return usuariosLista;
    
}

public Integer obtenerCantidadUsuarios() {
    ArrayList usuariosLista = new ArrayList<Usuario>(usuarios.values());

    return usuariosLista.size();
    
}


}
