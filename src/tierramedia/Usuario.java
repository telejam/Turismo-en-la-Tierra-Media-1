
package tierramedia;


public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	
	public Usuario(String nombre, double presupuesto, double tiempoDisponible) {

		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
	}

	
	public void  reducirPresupuesto(double costoDeVisita) {
		this.presupuesto -= costoDeVisita;
	}

	public void reducirTiempo(double tiempoDeVisita) {
		this.tiempoDisponible -= tiempoDeVisita;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempo() {
		return tiempoDisponible;
	}
}
