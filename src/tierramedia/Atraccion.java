package tierramedia;

public class Atraccion {
	String nombre;
	double costoDeVisita;
	double tiempoDeVisita;
	int cupoDiarioDePersonas;
	
	
	public double obtenerCosto(Promocion promo) {
		return costoDeVisita - promo.preciodePromo;
	}
	
	public boolean hayCupo() {
		boolean cupo = false;
		if(cupoDiarioDePersonas>0) {
			cupo = true;
		}
		return cupo;
	}\\
	
	public double obtenerDuracion() {
		return tiempoDeVisita;
	} 
	
	public String getNombre() {
		return nombre;
	}

    public boolean comprar() {
        if()
    }

}