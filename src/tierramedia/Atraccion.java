package tierramedia;

public class Atraccion {
	String nombre;
	double costoDeVisita;
	double tiempoDeVisita;
	int cupoDiarioDePersonas;
	
	
	public double obtenerCosto() {
		return this.costoDeVisita;
	}
	
	public boolean hayCupo() {
		return this.cupoDiarioDePersonas>0;
	}
	
	public double obtenerDuracion() {
		return this.tiempoDeVisita;
	} 
	
	public String getNombre() {
		return this.nombre;
	}

    public boolean restarCupo() {
        if(this.hayCupo()){
            this.cupoDiarioDePersonas -= 1;
        } else {
            System.out.println("Operación no permitida por falta de cupo");
        }
    }

}