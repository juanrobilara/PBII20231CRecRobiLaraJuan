
public class Administrador extends Usuario {

	public Administrador(String nombre, String contrasenia, String usuario) throws PasswordInvalidoException {
		super(nombre, contrasenia, usuario);
		
	}

	@Override
	public Boolean validarPassword(String password) {
	    String mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String minus = mayus.toLowerCase();
	    String numero = "1234567890";
	    String especiales = "_-.,:;!#$%&/()=?¡¿*[]{}";

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

	    // Verificar si cumple con los requisitos
	    boolean esValida = tieneMinus && tieneMayus && tieneNumero && tieneEspecial;

	    return esValida;
	}

	
	
}
