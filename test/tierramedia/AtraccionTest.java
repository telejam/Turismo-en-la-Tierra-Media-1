package tierramedia;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class AtraccionTest {

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
}
