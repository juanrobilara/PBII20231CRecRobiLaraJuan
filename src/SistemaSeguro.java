import java.util.HashSet;
import java.util.Set;

public class SistemaSeguro {

	private String nombre;
	private BaseDeDatosUsuario baseDatos;
	
	public SistemaSeguro(String nombre, BaseDeDatosUsuario baseDatos) {
		this.nombre = nombre;
		this.baseDatos = baseDatos;
	}
	
	public Usuario buscarUsuario(String usuario) throws UsuarioInexistenteException {
		Usuario u = baseDatos.obtenerUsuario(usuario);
		
		if(u != null) {
			return u;
		}
		
		throw new UsuarioInexistenteException("No existe usuario");
	}
	
	public void bloquearUsuario(Usuario u) throws ClassCastException, UsuarioInexistenteException {
		baseDatos.bloquearUsuario(u.getUsuario());
	}
	public void agregarUsuario(Usuario u) {
		baseDatos.agregarUsuario(u);
	}
	
	public void eliminarUsuario(Usuario u) throws ClassCastException, UsuarioInexistenteException {
		baseDatos.eliminarUsuario(u.getUsuario());
	}
	
	public void loguearUsuario(String usuario, String contrasenia) {
		
	}
	
}
