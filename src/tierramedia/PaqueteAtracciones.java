package tierramedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PaqueteAtracciones {
    private List<Atraccion> Atracciones =  new ArrayList<Atraccion>();
    
    public PaqueteAtracciones() {
    	this.cargarAtracciones();
    }
    
    public List<Atraccion> getAtracciones() {
    	return this.Atracciones;
    }
    
    public Atraccion linea2atraccion(String linea) {
    	String[] elemento = linea.split(","); //name, price, time, limit
    	Atraccion aux = new Atraccion(elemento[0], Integer.parseInt(elemento[1]),Double.parseDouble(elemento[2]),Integer.parseInt(elemento[3]));
    	return aux;
    }
    
    public void cargarAtracciones() {
    	FileReader fr = null;
    	BufferedReader br = null;
    	
    	try {
    		fr = new FileReader("archivos/in/atracciones.csv");
    		br = new BufferedReader(fr);
    		String linea = br.readLine();
    		while((linea != null)) {
    			//System.out.println(linea);
    			this.Atracciones.add(linea2atraccion(linea));
    			linea = br.readLine();
    		}
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			if(fr != null) {
    				fr.close();
    			}
    		}
    		catch (Exception e2){
    			e2.printStackTrace();
    		}
    	}
    	
    }
    
    public void ordenar() {
    	Collections.sort(Atracciones, new ComparadorOfertables());
    }
}