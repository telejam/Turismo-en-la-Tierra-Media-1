package tierramedia;

import java.util.List;


public abstract class Promocion implements Ofertable {

	protected String nombre;
	protected List<Atraccion> atracciones;

	public Promocion(String nombre, List<Atraccion> atraccionesPromo) {
		this.nombre = nombre;
		this.atracciones= atraccionesPromo;
	}

	public boolean hayCupo() {
		boolean cupo = true;
		for (Atraccion atraccion : this.atracciones) {
			if( !atraccion.hayCupo()) {
				cupo = false;
			}
			
		}
		return cupo;
	}
	public double obtenerDuracion() {

		double sumaTiempos = 0;
		for (Atraccion atraccion : this.atracciones) {
			sumaTiempos += atraccion.obtenerDuracion();
		}
		return sumaTiempos;
	}
	public List<Atraccion> obtenerContenido() {

          return atracciones;

	}
	
}


