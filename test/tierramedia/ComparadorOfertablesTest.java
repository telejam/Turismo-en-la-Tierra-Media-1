package tierramedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ComparadorOfertablesTest {

	@Test
	public void ordenarOfertable() {
		Atraccion atraccion1 = new Atraccion("Mordor", 20, 10, 2);
		Atraccion atraccion2 = new Atraccion("Comarca", 10, 5.5, 2);
		Atraccion atraccion3 = new Atraccion("Erebor", 20, 15, 2);
		Atraccion atraccion4 = new Atraccion("Moria", 30, 15, 2);
		
		List<Atraccion> lista1 = new ArrayList<Atraccion>();
		List<Atraccion> lista2 = new ArrayList<Atraccion>();
		List<Atraccion> lista3 = new ArrayList<Atraccion>();
		List<Atraccion> lista4 = new ArrayList<Atraccion>();
		List<Promocion> listaPromo = new ArrayList<Promocion>();
		
		lista1.add(atraccion1);
		lista1.add(atraccion2);
		lista1.add(atraccion3);
		lista1.add(atraccion4);
		
    	Collections.sort(lista1, new ComparadorOfertables());
		assertEquals(atraccion4, lista1.get(0));
		assertEquals(atraccion3, lista1.get(1));
		assertEquals(atraccion1, lista1.get(2));
		assertEquals(atraccion2, lista1.get(3));

		lista2.add(atraccion1);
		lista2.add(atraccion2);
		lista3.add(atraccion2);
		lista3.add(atraccion3);
		lista4.add(atraccion3);
		lista4.add(atraccion4);

		Promocion promocion1 = new PromocionAbsoluta("Baratita1", lista2, 1);
		Promocion promocion2 = new PromocionAbsoluta("Baratita2", lista3, 2);
		Promocion promocion3 = new PromocionAbsoluta("Baratita3", lista4, 3);

		listaPromo.add(promocion1);
		listaPromo.add(promocion2);
		listaPromo.add(promocion3);
		
    	Collections.sort(listaPromo, new ComparadorOfertables());
		assertEquals(promocion3, listaPromo.get(0));
		assertEquals(promocion2, listaPromo.get(1));
		assertEquals(promocion1, listaPromo.get(2));
	}

}
