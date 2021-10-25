package tierramedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ItinerarioTest {

	@Test
	public void estaCargadaYAgregar() {
		Usuario usuario = new Usuario("Sam", 10, 10);
		
		Itinerario itinerario = new Itinerario(usuario);
		
		Atraccion atraccion1 = new Atraccion("Mordor", 10, 10, 2);
		Atraccion atraccion2 = new Atraccion("Comarca", 10, 5.5, 2);
		Atraccion atraccion3 = new Atraccion("Erebor", 10, 5, 2);
		Atraccion atraccion4 = new Atraccion("Moria", 10, 15, 2);
		
		List<Atraccion> lista1 = new ArrayList<Atraccion>();
		List<Atraccion> lista2 = new ArrayList<Atraccion>();
		
		lista1.add(atraccion1);
		lista1.add(atraccion2);
		lista2.add(atraccion3);
		lista2.add(atraccion4);
		
		Promocion promocion1 = new PromocionAbsoluta("Baratita1", lista1, 1);
		Promocion promocion2 = new PromocionAbsoluta("Baratita2", lista2, 2);
		
		assertFalse(itinerario.estaCargada(atraccion1));
		assertFalse(itinerario.estaCargada(atraccion2));
		assertFalse(itinerario.estaCargada(atraccion3));
		assertFalse(itinerario.estaCargada(atraccion4));
		assertFalse(itinerario.estaCargada(promocion1));
		assertFalse(itinerario.estaCargada(promocion2));

		itinerario.agregar(promocion1);
		assertTrue(itinerario.estaCargada(atraccion1));
		assertTrue(itinerario.estaCargada(atraccion2));
		assertTrue(itinerario.estaCargada(promocion1));

		itinerario.agregar(atraccion3);
		assertTrue(itinerario.estaCargada(atraccion3));
		assertFalse(itinerario.estaCargada(atraccion4));
		assertTrue(itinerario.estaCargada(promocion2));
		
	}

}
