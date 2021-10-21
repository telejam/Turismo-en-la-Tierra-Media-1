package tierramedia;

import java.util.ArrayList;
import java.util.List;

public class Atraccion {
	private String nombre;
	private double costoDeVisita;
	private double tiempoDeVisita;
	private int cupoDiarioDePersonas;
	
	public Atraccion(String name, double price, double time, int limit) {
		this.nombre = name;
		this.costoDeVisita = price;
		this.tiempoDeVisita = time;
		this.cupoDiarioDePersonas = limit;
	}
	
	public double obtenerCosto() {
		return this.costoDeVisita;
	}
    public double obtenerDuracion() {
		return this.tiempoDeVisita;
	} 
    public String obtenerNombre() {
		return this.nombre;
	}

    public List<Atraccion> obtenerContenido(){
        List<Atraccion> contenido = new ArrayList<Atraccion>();
        contenido.add(this);
        return contenido;
    }

	public boolean hayCupo() {
		return this.cupoDiarioDePersonas>0;
	}
    public int restarCupo() {
        if(this.hayCupo()){
            this.cupoDiarioDePersonas -= 1;
        } else {
            System.out.println("Operación no permitida por falta de cupo");
        }

        return this.cupoDiarioDePersonas;
    }

}