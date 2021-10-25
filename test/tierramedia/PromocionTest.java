package tierramedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PromocionTest {

	@Test
	public void hayCupo() {
		Atraccion atraccion1 = new Atraccion("Mordor", 10, 10, 2);
		Atraccion atraccion2 = new Atraccion("Comarca", 10, 10, 2);
		List<Atraccion> lista = new ArrayList<Atraccion>();
		lista.add(atraccion1);
		lista.add(atraccion2);
		Promocion promocion = new PromocionAbsoluta("Baratita", lista, 1);
		assertTrue(promocion.hayCupo());
	}

	@Test
	public void noHayCupo() {
		Atraccion atraccion1 = new Atraccion("Mordor", 10, 10, 2);
		Atraccion atraccion2 = new Atraccion("Comarca", 10, 10, 0);
		List<Atraccion> lista = new ArrayList<Atraccion>();
		lista.add(atraccion1);
		lista.add(atraccion2);
		Promocion promocion = new PromocionAbsoluta("Baratita", lista, 1);
		assertFalse(promocion.hayCupo());
	}
	
	@Test
	public void obtenerContenido() {
		Atraccion atraccion1 = new Atraccion("Mordor", 10, 10, 2);
		Atraccion atraccion2 = new Atraccion("Comarca", 10, 10, 2);
		List<Atraccion> lista = new ArrayList<Atraccion>();
		lista.add(atraccion1);
		lista.add(atraccion2);
		Promocion promocion = new PromocionAbsoluta("Baratita", lista, 1);

		List<Atraccion> recibida = promocion.obtenerContenido();
		assertEquals(atraccion1, recibida.get(0));
		assertEquals(atraccion2, recibida.get(1));
		assertEquals(2, recibida.size());
		
	}
	
	@Test
	public void obtenerDuracion() {
		Atraccion atraccion1 = new Atraccion("Mordor", 10, 10, 2);
		Atraccion atraccion2 = new Atraccion("Comarca", 10, 5.5, 2);
		List<Atraccion> lista = new ArrayList<Atraccion>();
		lista.add(atraccion1);
		lista.add(atraccion2);
		Promocion promocion = new PromocionAbsoluta("Baratita", lista, 1);
		
		assertEquals(15.5, promocion.obtenerDuracion(), 0.01);
		
	}
	
	@Test
	public void obtenerCosto() {
		Atraccion atraccion1 = new Atraccion("Mordor", 10, 10, 2);
		Atraccion atraccion2 = new Atraccion("Comarca", 10, 5.5, 2);
		Atraccion atraccion3 = new Atraccion("Erebor", 10, 5, 2);
		List<Atraccion> lista = new ArrayList<Atraccion>();
		List<Atraccion> listaPagas = new ArrayList<Atraccion>();
		lista.add(atraccion1);
		lista.add(atraccion2);
		listaPagas.addAll(lista);
		lista.add(atraccion3);
		Promocion promocionA = new PromocionAbsoluta("Absoluta", lista, 20);
		Promocion promocionP = new PromocionPorcentual("Porcentual", lista, 10);
		Promocion promocionX = new PromocionAxB("AxB", lista, listaPagas);
		
		assertEquals(20, promocionA.obtenerCosto(), 0.01);
		assertEquals(27, promocionP.obtenerCosto(), 0.01);
		assertEquals(20, promocionX.obtenerCosto(), 0.01);
		
	}

	@Test
	public void toStringTest() {
		Atraccion atraccion1 = new Atraccion("Mordor", 10, 10, 2);
		Atraccion atraccion2 = new Atraccion("Comarca", 10, 5.5, 2);
		Atraccion atraccion3 = new Atraccion("Erebor", 10, 5, 2);
		List<Atraccion> lista = new ArrayList<Atraccion>();
		List<Atraccion> listaPagas = new ArrayList<Atraccion>();
		lista.add(atraccion1);
		lista.add(atraccion2);
		listaPagas.addAll(lista);
		lista.add(atraccion3);
		Promocion promocionA = new PromocionAbsoluta("Absoluta", lista, 20);
		Promocion promocionP = new PromocionPorcentual("Porcentual", lista, 10);
		Promocion promocionX = new PromocionAxB("AxB", lista, listaPagas);
		
		assertEquals(20, promocionA.obtenerCosto(), 0.01);
		assertEquals(27, promocionP.obtenerCosto(), 0.01);
		assertEquals(20, promocionX.obtenerCosto(), 0.01);
		
		String mensaje1 ="Promoción: Absoluta\n"
				+ "-Atracciones incluidas: \n"
				+ "    -Mordor, 10 monedas de oro\n"
				+ "    -Comarca, 10 monedas de oro\n"
				+ "    -Erebor, 10 monedas de oro\n"
				+ "\n"
				+ "-Duración: 20,5 horas \n"
				+ "-Precio: 20 monedas de oro\n";
		assertEquals(mensaje1, promocionA.toString());
		
		String mensaje2 = "Promoción: Porcentual\n"
				+ "-Atracciones incluidas: \n"
				+ "    -Mordor, 10 monedas de oro\n"
				+ "    -Comarca, 10 monedas de oro\n"
				+ "    -Erebor, 10 monedas de oro\n"
				+ "\n"
				+ "-Duración: 20,5 horas \n"
				+ "-Precio con descuento: 27 monedas de oro\n";
		assertEquals(mensaje2, promocionP.toString());
		
		String mensaje3 = "Promoción: AxB\n"
				+ "-Atracciones incluidas: \n"
				+ "    -Mordor, 10 monedas de oro\n"
				+ "    -Comarca, 10 monedas de oro\n"
				+ "    -Erebor, 10 monedas de oro\n"
				+ "\n"
				+ " Solo paga por: \n"
				+ "    -Mordor, 10 monedas de oro\n"
				+ "    -Comarca, 10 monedas de oro\n"
				+ "\n"
				+ "-Duración: 20,5 horas \n"
				+ "-Precio: 20 monedas de oro\n";
		assertEquals(mensaje3, promocionX.toString());
		
	}
}
