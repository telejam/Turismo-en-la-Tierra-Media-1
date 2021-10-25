package tierramedia;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class AtraccionTest {

	@Test
	public void getNombre() {
		Atraccion atraccion = new Atraccion("Mordor", 10, 10, 2);
		assertEquals("Mordor",atraccion.getNombre());
	}

	@Test
	public void obtenerCosto() {
		Atraccion atraccion = new Atraccion("Mordor", 10, 10, 2);
		assertEquals(10,atraccion.obtenerCosto(), 0.01);
	}
	
	@Test
	public void obtenerDuracion() {
		Atraccion atraccion = new Atraccion("Mordor", 10, 10, 2);
		assertEquals(10,atraccion.obtenerDuracion(), 0.01);
	}
	
	@Test
	public void hayCupo() {
		Atraccion atraccion = new Atraccion("Mordor", 10, 10, 2);
		assertTrue(atraccion.hayCupo());
	}
	
	@Test
	public void noHayCupo() {
		Atraccion atraccion = new Atraccion("Mordor", 10, 10, 0);
		assertFalse(atraccion.hayCupo());
	}
	
	@Test
	public void restarCupo() {
		Atraccion atraccion = new Atraccion("Mordor", 10, 10, 1);
		assertTrue(atraccion.hayCupo());
		atraccion.restarCupo();
		assertFalse(atraccion.hayCupo());
	}
	
	@Test
	public void obtenerContenido() {
		Atraccion atraccion = new Atraccion("Mordor", 10, 10, 1);
		List<Atraccion> recibida = atraccion.obtenerContenido();
		for (Atraccion unaAtraccion : recibida)
			assertEquals(atraccion, unaAtraccion);
	}

	@Test
	public void toStringTest() {
		
		Atraccion atraccion1 = new Atraccion("Moria", 10, 2, 2);
		
		String mensaje = "Atracción: Moria\n"
				+ "-Duración: 2 horas \n"
				+ "-Precio: 10 monedas de oro";
		assertEquals(mensaje, atraccion1.toString());
		
	}
}
