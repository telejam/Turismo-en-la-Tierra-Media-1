package tierramedia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Itinerario {
	private ArrayList<Atraccion> atracciones;
	private double costoDeVisita;
	private double tiempoDeVisita;
	private Usuario usuario;

	public Itinerario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void agregar(Ofertable ofertable) {
		for (Atraccion atraccion : ofertable.obtenerContenido()) {
			atracciones.add(atraccion);
			atraccion.restarCupo();
		}
		usuario.reducirTiempo(ofertable.obtenerDuracion());
		this.tiempoDeVisita += ofertable.obtenerDuracion();
		usuario.reducirPresupuesto(ofertable.obtenerCosto());
		this.costoDeVisita +=ofertable.obtenerCosto();
	}

	public boolean estaCargada(Ofertable ofertable) {
		boolean esta = false;
		for (Atraccion atraccion : ofertable.obtenerContenido()) {
			if (atracciones.contains(atraccion)) {
				esta = true;
			}
		}
		return esta;
	}

	public void generarArchivo() {
		String lineaAtraccion = "";

		BufferedWriter archivo = null;
		try {
			archivo = new BufferedWriter(new FileWriter("archivos/out/" + usuario.getNombre() + ".txt"));
			archivo.write("Itinerario de " + usuario.getNombre());
			archivo.newLine();
			archivo.newLine();
			for (Atraccion atraccion : atracciones) {
				lineaAtraccion = " " + atraccion.getNombre() + " " + atraccion.obtenerDuracion() + " horas";
				archivo.write(lineaAtraccion);
				archivo.newLine();
			}
			if (lineaAtraccion.equals("")) {
				archivo.newLine();
				archivo.write("Usted no ha elegido ninguna oferta.");
			} else {
				archivo.newLine();
				archivo.write(" Costo total: " + this.costoDeVisita + " monedas de oro");
				archivo.newLine();
				archivo.newLine();
				archivo.write(" Tiempo total: " + this.tiempoDeVisita + " horas.");
				archivo.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				archivo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		DecimalFormat f = new DecimalFormat("#.##");
		String listaAtracciones = "";
		String mensaje = "Este es su Itinerario:  " + usuario.getNombre() + "\n\n";
		for (Atraccion atraccion : atracciones) {
			listaAtracciones += " " + atraccion.getNombre() + " " + f.format(atraccion.obtenerDuracion()) + " horas\n";
		}
		if (listaAtracciones.equals("")) {
			mensaje += "Usted no ha elegido ninguna oferta. ";
		} else {
			mensaje += listaAtracciones + "\n\n Su Costo total: " + f.format(this.costoDeVisita) + " monedas de oro "
					+ "\n\n Su Tiempo total: " + f.format(this.tiempoDeVisita) + " horas.";
		}
		return mensaje + "\n\nQue disfrute su visita a la Tierra Media."
				+ "\n\n-------------------------------------------------------------------\n";
	}

}
