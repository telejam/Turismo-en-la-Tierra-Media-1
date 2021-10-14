package Promocion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Promocion {
	String nombre;
	double preciodePromo;
	double duraciondePromo;
	//int cupoAtraccion;?
	//List <Atraccion> atracciones;

	public class obtenerPrecio{
		// Nos creamos un ArrayList de objetos de la Clase "Atraccion"
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();

		// Instanciamos el fichero donde estan los datos
		File fichero = new File(Atracciones.csv);
		Scanner s = null;

		try {
			// Leemos el contenido del fichero

			s = new Scanner(fichero);
			// Obtengo los datos de las atracciones del fichero
			while (s.hasNextLine()){
				String linea = s.nextLine();	// Obtengo una linea del fichero 
				String [] cortarString = linea.split(",");	// Obtengo los datos de las atracciones
				Atraccion cadaAtraccion = new Atraccion();	// Creo un objeto de la clase "Atraccion"

				// Pongo los atributos al objeto "cadaAtraccion"
				
				cadaAtraccion.nombre(cortarString[0]);
				cadaAtraccion.preciodePromo(Integer.parseint(cortarString[1]));
				cadaAtraccion.duraciondePromo(Integer.parseint(cortarString[2]));
				//cadaAtraccion.cupoAtraccion(Integer.parseInt(cortarString[3]));

				// Añadimos el objeto "Atraccion" al ArrayList
				atracciones.add(partido);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if (s != null)
					s.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}



}

