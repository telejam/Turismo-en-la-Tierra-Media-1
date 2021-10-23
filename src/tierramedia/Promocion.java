package tierramedia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


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


