
public class Basico extends Usuario implements Eliminable, Bloqueable {
private Boolean bloqueado;
private Boolean eliminado;
	public Basico(String nombre,String password, String usuario) throws PasswordInvalidoException {
		super(nombre, password, usuario);
		this.bloqueado = false;
		this.eliminado = false;
	}
	
	public Boolean validarPassword(String password) {
	    
		/*
		String mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String minus = mayus.toLowerCase();
	    String numero = "1234567890";
	    String especiales = "_-.,:;!#$%&/()=?¡¿*[]{}";
	 // chequeo todas las posibilidades
	    Boolean tieneMinus = false;
	    Boolean tieneMayus = false;
	    Boolean tieneNumero = false;


	    for (char c : password.toCharArray()) {
	        if (mayus.contains(String.valueOf(c))) {
	        	tieneMayus = true;
	        } else if (minus.contains(String.valueOf(c))) {
	        	tieneMayus = true;
	        } else if (numero.contains(String.valueOf(c))) {
	        	tieneNumero = true;
	        } 
	    }

	    
	    boolean esValida = tieneMinus && tieneMayus && tieneNumero;

	    return esValida;
	    
	    */
		return true;
	}



	@Override
	public void bloquearUsuario() {
		this.bloqueado = true;	
	}

	@Override
	public void eliminarUsuario(String nombreUsuario) {
		this.eliminado = true;	
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}

	
	
}
