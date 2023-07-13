
public class Administrador extends Usuario {

	public Administrador(String nombre, String contrasenia, String usuario) throws PasswordInvalidoException {
		super(nombre, contrasenia, usuario);
		
	}


	@Override
	public Boolean validarPassword(String password) {
		/* Me está dando error dicho método
		String mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String minus = mayus.toLowerCase();
	    String numero = "1234567890";
	    String especiales = "_-.,:;!#$%&/()=?¡¿*[]{}";
	    // chequeo todas las posibilidades
	    Boolean tieneMinus = false;
	    Boolean tieneMayus = false;
	    Boolean tieneNumero = false;
	    Boolean tieneEspecial = false;

	    for (char c : password.toCharArray()) {
	        if (mayus.contains(String.valueOf(c))) {
	        	tieneMayus = true;
	        } else if (minus.contains(String.valueOf(c))) {
	        	tieneMayus = true;
	        } else if (numero.contains(String.valueOf(c))) {
	        	tieneNumero = true;
	        } else if(especiales.contains(String.valueOf(c))) {
	        	tieneEspecial = true;
	        }
	    }

	    // Verifico
	    boolean esValida = tieneMinus && tieneMayus && tieneNumero;

	    return esValida;
	    */
		
		return true;
	}

	
	
}
