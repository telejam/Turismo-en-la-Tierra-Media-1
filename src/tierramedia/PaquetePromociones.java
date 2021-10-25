package tierramedia;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PaquetePromociones {

	private List<Promocion> promociones= new ArrayList<Promocion>();
	
	public PaquetePromociones(List<Atraccion> lista) {
		cargarPromociones(lista);
		
	}
	public void cargarPromociones(List<Atraccion> lista) { 


        ArrayList<Promocion> promociones = new ArrayList<Promocion>();

		// Instanciamos el fichero donde estan los datos
		File fichero = new File("archivos/in/promociones.csv");
		Scanner s = null;

		try {
		
			s = new Scanner(fichero);
			List<Atraccion> pasarAtracciones;
			List <Atraccion >listaAPagar;	
			while (s.hasNextLine()){
				String linea = s.nextLine();	
				String [] cortarString = linea.split(",");	

			
				
				
			String [] listaAtracciones=cortarString[2].split("-");
		       pasarAtracciones= new ArrayList<Atraccion>();
			for(String unaAtraccion:listaAtracciones) {
				for(Atraccion atraccion :lista) {
					if(atraccion.getNombre().equals(unaAtraccion)) {
						pasarAtracciones.add(atraccion);
					}
				}
				
			}
				
				if(cortarString[1].equals("%")) {
				

							
				promociones.add(new PromocionPorcentual(cortarString[0],pasarAtracciones, Double.parseDouble(cortarString[3])));
				
				}
				if(cortarString[1].equals("$")) {
				
				         
					
							
					promociones.add(new PromocionAbsoluta(cortarString[0],pasarAtracciones, Double.parseDouble(cortarString[3])) );
				
				}
				if(cortarString[1].equals("x")) {
					
				String [] listaAtraccionesGratuitas=cortarString[3].split("-");
				listaAPagar = new ArrayList<Atraccion>();
				listaAPagar.addAll(pasarAtracciones);
			      
				for(String unaAtraccion:listaAtraccionesGratuitas) {
					for(Atraccion atraccion :lista) {
						if(atraccion.getNombre().equals(unaAtraccion)) {
							pasarAtracciones.add(atraccion);
						}
					}
					
				}	
				
							promociones.add(new PromocionAxB(cortarString[0],pasarAtracciones,listaAPagar) );
				
				
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



	 public void ordenar() {
	    	Collections.sort(promociones, new ComparadorOfertables());
	    }

	 public List<Promocion> getPromociones(){
		 return promociones;
	 }


}	

