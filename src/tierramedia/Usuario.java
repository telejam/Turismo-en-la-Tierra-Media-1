
package tierramedia;

import java.util.Objects;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	
	public Usuario(String nombre, double presupuesto, double tiempoDisponible) {

		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
	}

	
	public  double reducirPresupuesto() {
		this.presupuesto--;
	}

	public void reducirTiempo() {
		this.tiempoDisponible--;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	@Override
	public String toString() {
		return "Usuario [nombre= " + nombre + ", presupuesto= " + presupuesto + ", tiempoDisponible= " + tiempoDisponible
				+ "]\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, presupuesto, tiempoDisponible);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(presupuesto) == Double.doubleToLongBits(other.presupuesto)
				&& Double.doubleToLongBits(tiempoDisponible) == Double.doubleToLongBits(other.tiempoDisponible);
	}

}
