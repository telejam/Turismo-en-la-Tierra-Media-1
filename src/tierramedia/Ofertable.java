package tierramedia;

import java.util.List;

public interface Ofertable {
	public double obtenerCosto();
	public double obtenerDuracion();
	public boolean hayCupo();
	public List<Atraccion> obtenerContenido();
}
