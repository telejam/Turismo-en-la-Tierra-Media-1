package tierramedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ItinerarioTest {

	@Test
	public void estaCargadaAtraccion() {
		Usuario usuario = new Usuario("Sam", 10, 10);
		
		Itinerario itinerario = new Itinerario(usuario);
		
		Atraccion atraccion1 = new Atraccion("Mordor", 10, 10, 2);
		assertFalse(itinerario.estaCargada(atraccion1));

		itinerario.agregar(atraccion1);
		assertTrue(itinerario.estaCargada(atraccion1));

	}

	@Test
	public void estaCargadaPromocion() {
		Usuario usuario = new Usuario("Sam", 10, 10);
		
		Itinerario itinerario = new Itinerario(usuario);
		
		Atraccion atraccion1 = new Atraccion("Mordor", 10, 10, 2);
		Atraccion atraccion2 = new Atraccion("Comarca", 10, 5.5, 2);
		
		List<Atraccion> lista1 = new ArrayList<Atraccion>();
		
		lista1.add(atraccion1);
		lista1.add(atraccion2);
		
		Promocion promocion1 = new PromocionAbsoluta("Baratita1", lista1, 1);
		
		assertFalse(itinerario.estaCargada(promocion1));
		
		itinerario.agregar(promocion1);

		assertTrue(itinerario.estaCargada(promocion1));
		
	}
	
	@Test
	public void agregarAtraccion() {
		Usuario usuario = new Usuario("Sam", 10, 10);
		
		Itinerario itinerario = new Itinerario(usuario);
		
		Atraccion atraccion1 = new Atraccion("Mordor", 10, 10, 2);
		
		assertFalse(itinerario.estaCargada(atraccion1));
		
		itinerario.agregar(atraccion1);
		
		assertTrue(itinerario.estaCargada(atraccion1));
		
	}
	
	@Test
	public void agregarPromocion() {
		Usuario usuario = new Usuario("Sam", 10, 10);
		
		Itinerario itinerario = new Itinerario(usuario);
		
		Atraccion atraccion1 = new Atraccion("Mordor", 10, 10, 2);
		Atraccion atraccion2 = new Atraccion("Comarca", 10, 5.5, 2);
		
		List<Atraccion> lista1 = new ArrayList<Atraccion>();
		
		lista1.add(atraccion1);
		lista1.add(atraccion2);
		
		Promocion promocion1 = new PromocionAbsoluta("Baratita1", lista1, 1);
	
		assertFalse(itinerario.estaCargada(promocion1));
		assertFalse(itinerario.estaCargada(atraccion1));
		assertFalse(itinerario.estaCargada(atraccion2));
	
		itinerario.agregar(promocion1);

		assertTrue(itinerario.estaCargada(promocion1));
		assertTrue(itinerario.estaCargada(atraccion1));
		assertTrue(itinerario.estaCargada(atraccion2));
	
	}
	
	@Test
	public void toStringTest() {
		Usuario usuario = new Usuario("Eowyn", 10, 10);
		
		Itinerario itinerario = new Itinerario(usuario);
		
		Atraccion atraccion1 = new Atraccion("Moria", 10, 2, 2);
		
		itinerario.agregar(atraccion1);

		String mensaje = "Este es su Itinerario:  Eowyn\n\n"
				+ " Moria 2 horas\n\n\n"
				+ " Su Costo total: 10 monedas de oro \n\n"
				+ " Su Tiempo total: 2 horas.\n\n"
				+ "Que disfrute su visita a la Tierra Media.\n\n"
				+ "-------------------------------------------------------------------\n";
		assertEquals(mensaje, itinerario.toString());
		
	}
	
}
