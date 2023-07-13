import java.util.Objects;

public abstract class Usuario implements Comparable<Usuario> {
private String nombre;
private String usuario;
private String password;



public Usuario(String nombre, String password, String usuario) throws PasswordInvalidoException {
	super();
	this.nombre = nombre;
	
	if(!validarPassword(password)) {
		throw new PasswordInvalidoException("Este pass es invalido");
	}else {
		this.password = password;
	}

	this.usuario = usuario;
}

public abstract Boolean validarPassword(String password);

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}


@Override
public int hashCode() {
	return Objects.hash(usuario);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Usuario other = (Usuario) obj;
	return Objects.equals(usuario, other.usuario);
}


@Override
public int compareTo(Usuario o) {
	
	return this.getUsuario().compareTo(o.getUsuario());
}




}
