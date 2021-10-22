package tierramedia;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaqueteAtracciones p = new PaqueteAtracciones();
		List<Atraccion> Atracciones =  new ArrayList<Atraccion>();
		Atraccion a;
		
		p.cargarAtracciones();
		
		System.out.println("\nAtracciones desde archivo:\n");
		
		p.Listar();
		
		p.Ordenar();
		
		System.out.println("\nAtracciones ordnadas:\n");
		
		p.Listar();
		
		Atracciones = p.getAtracciones();
		
		for(int i = 0; i < Atracciones.size(); i++){
			a = Atracciones.get(i);
			System.out.println(a.getNombre());
			System.out.println(a.getCupo());
			a.restarCupo();
			a.restarCupo();
			a.restarCupo();
			a.restarCupo();
			a.restarCupo();
			System.out.println(a.getNombre());
			System.out.println(a.getCupo());
		}
		
	 
	}

}
