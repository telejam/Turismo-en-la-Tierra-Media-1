package tierramedia;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsuarioTest {

	@Test
	public void reducirPresupuesto() {
		Usuario usuario = new Usuario("Sam", 10.5, 10);
		assertEquals(10.5, usuario.getPresupuesto(), 0.01);
		usuario.reducirPresupuesto(5);
		assertEquals(5.5, usuario.getPresupuesto(), 0.01);
	}

	@Test
	public void getNombre() {
		Usuario usuario = new Usuario("Sam", 10.5, 10);
		assertEquals("Sam", usuario.getNombre());
	}
	
	@Test
	public void reducirTiempo() {
		Usuario usuario = new Usuario("Sam", 10.5, 10);
		assertEquals(10, usuario.getTiempo(), 0.01);
		usuario.reducirTiempo(5);
		assertEquals(5, usuario.getTiempo(), 0.01);
	}
	
	@Test
	public void getPresupuesto() {
		Usuario usuario = new Usuario("Sam", 10.5, 10);
		assertEquals(10.5, usuario.getPresupuesto(), 0.01);
	}
	
	@Test
	public void getTiempo() {
		Usuario usuario = new Usuario("Sam", 10.5, 10);
		assertEquals(10, usuario.getTiempo(), 0.01);
	}
	
}
