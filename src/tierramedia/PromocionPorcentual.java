package tierramedia;

import java.util.List;

public class PromocionPorcentual extends Promocion  {
	
	private Double porcentajeDeDescuento;
	
	public PromocionPorcentual( String nombre, List<Atraccion> atraccionesPromo,double porcentaje) {
		super(nombre,atraccionesPromo);
	    this.porcentajeDeDescuento=porcentaje;
	}
	
	public Double obtenerCosto() {
		
		int sumaCostos = 0;
		for(Atraccion x : ) {
			sumaCostos += x.getCosto();
			}
		return (sumaCostos - montoPromo) * 100 / sumaCostos ;
		
		


}
}