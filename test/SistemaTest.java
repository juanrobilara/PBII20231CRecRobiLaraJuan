import static org.junit.Assert.*;

import org.junit.Test;

public class SistemaTest {

	@Test
	public void queSePuedaCrearUnUsuario() throws PasswordInvalidoException {
		//PREPARACION
		Administrador admin = new Administrador("Pablo", "ABC1265", "Pablillo");
		//EJECUCION
		
		assertNotNull(admin);
	}

	@Test
	public void queSePuedaCrearUnSistema() {
		
		BaseDeDatosUsuario baseDatos = new BaseDeDatosUsuario();	
		SistemaSeguro seguridad = new SistemaSeguro("SecuCorp", baseDatos);
		assertNotNull(seguridad);
	}
	
	@Test
	public void queNoSePuedanAgregarUsuariosDuplicados() throws PasswordInvalidoException {
		
		BaseDeDatosUsuario baseDatos = new BaseDeDatosUsuario();
		SistemaSeguro seguridad = new SistemaSeguro("SecuCorp", baseDatos);
		Administrador admin = new Administrador("Pablo", "AB32_1265", "Pablillo");
		Administrador cuentaCopia = admin;
		
		seguridad.agregarUsuario(admin);
		seguridad.agregarUsuario(cuentaCopia);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = baseDatos.obtenerCantidadUsuarios();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test (expected = ClassCastException.class)
	public void queNoSePuedaEliminarAUnUsuarioNoEliminable() throws PasswordInvalidoException, ClassCastException, UsuarioInexistenteException {
		BaseDeDatosUsuario baseDatos = new BaseDeDatosUsuario();	
		SistemaSeguro seguridad = new SistemaSeguro("SecuCorp", baseDatos);
		Administrador admin = new Administrador("Pablo", "AB3a21265", "Pablillo");
		Administrador admin2 = new Administrador("PabloPerez", "ADcETRd234", "Pablangas");
		
		seguridad.agregarUsuario(admin2);
		seguridad.agregarUsuario(admin);
		
		seguridad.eliminarUsuario(admin2);
	}
	
	@Test (expected = ClassCastException.class)
	public void queNoSePuedaBloquearAUnUsuarioNoBloqueable() throws PasswordInvalidoException, ClassCastException, UsuarioInexistenteException {
		BaseDeDatosUsuario baseDatos = new BaseDeDatosUsuario();	
		SistemaSeguro seguridad = new SistemaSeguro("SecuCorp", baseDatos);
		Administrador admin = new Administrador("Pablo", "AB32_1265", "Pablillo");
		Administrador admin2 = new Administrador("PabloPerez", "ADcETRd234", "Pablangas");
		
		seguridad.agregarUsuario(admin2);
		seguridad.agregarUsuario(admin);
		
		seguridad.bloquearUsuario(admin);
	}
	
	@Test 
	public void queSePuedaBloquearAUnUsuarioBloqueable() throws PasswordInvalidoException, ClassCastException, UsuarioInexistenteException {
		BaseDeDatosUsuario baseDatos = new BaseDeDatosUsuario();	
		SistemaSeguro seguridad = new SistemaSeguro("SecuCorp", baseDatos);
		Administrador admin = new Administrador("Pablo", "AB3s2_1265", "Pablillo");
		Basico basico = new Basico("PabloPerez", "ADcETRd_234", "Pablangas");
		
		seguridad.agregarUsuario(basico);
		seguridad.agregarUsuario(admin);
		
		seguridad.bloquearUsuario(basico);
		
		assertTrue(basico.getBloqueado());
	}
	@Test 
	public void queSePuedaEliminarAUnUsuarioEliminable() throws PasswordInvalidoException, ClassCastException, UsuarioInexistenteException {
		BaseDeDatosUsuario baseDatos = new BaseDeDatosUsuario();	
		SistemaSeguro seguridad = new SistemaSeguro("SecuCorp", baseDatos);
		Administrador admin = new Administrador("Pablo", "AB3a2_126", "Pablillo");
		Basico basico = new Basico("PabloPerez", "ADcETRd_234", "Pablangas");
		
		seguridad.agregarUsuario(basico);
		seguridad.agregarUsuario(admin);
		
		seguridad.eliminarUsuario(basico);
		
		assertTrue(basico.getEliminado());
	}
	
	@Test (expected = UsuarioInexistenteException.class)
	public void queAlLoguearUnUsuarioNoExistenteEnLaBBDDLanceExcepcion() throws PasswordInvalidoException, UsuarioInexistenteException {
		BaseDeDatosUsuario baseDatos = new BaseDeDatosUsuario();	
		SistemaSeguro seguridad = new SistemaSeguro("SecuCorp", baseDatos);
		
		Basico basico = new Basico("PabloPerez", "ADcETRd_234", "Pablangas");
		
		//No lo agrego
		
		seguridad.buscarUsuario(basico.getUsuario());
	}
	@Test (expected = PasswordInvalidoException.class)
	public void queAlLoguearUnUsuarioConUnaContraseniaInvalidaLanceUnaExcepcion() throws PasswordInvalidoException {

	}
	
}
