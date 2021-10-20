package tierramedia;

public class Atraccion {
	private String nombre;
	private double costoDeVisita;
	private double tiempoDeVisita;
	private int cupoDiarioDePersonas;
	
	
	public double obtenerCosto() {
		return this.costoDeVisita;
	}
    public double obtenerDuracion() {
		return this.tiempoDeVisita;
	} 
    public String obtenerNombre() {
		return this.nombre;
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