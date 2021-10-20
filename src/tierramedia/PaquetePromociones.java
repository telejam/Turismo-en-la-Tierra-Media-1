package tierramedia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaquetePromociones( paqueteAtracciones ) {

	private List<Promocion> promociones;

	public void cargarPromociones() { 





		
		ArrayList<Promocion> promociones = new ArrayList<Promocion>();

		// Instanciamos el fichero donde estan los datos
		File fichero = new File(promociones.csv);
		Scanner s = null;

		try {
			// Leemos el contenido del fichero

			s = new Scanner(fichero);
			// Obtengo los datos de las atracciones del fichero
			while (s.hasNextLine()){
				String linea = s.nextLine();	// Obtengo una linea del fichero 
				String [] cortarString = linea.split(",");	// Obtengo los datos de las atracciones
				//Promocion listaPromocion = new Promocion();	// Creo un objeto de la clase "Promocion"

			
				if(cortarString[1]==%) {
				
							
				promociones.add(new PromocionPorcentual((cortarString[0]),(cortarString[2]),Integer.parseint(cortarString[3])));
				
				}
				if(cortarString[1]==$) {
					
							
					promociones.add(new PromocionAbsoluta(cortarString[0],cortarString[2],Integer.parseint(cortarString[3])));
				
				}
				if(cortarString[1]==x) {
				
					
							String [] cortarString1 = linea.split("-");	
				
							promociones.add(new PromocionAxB(cortarString[0],cortarString[2],cortarString1(cortarString[2])));
				
				
				
			}
				
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
}
