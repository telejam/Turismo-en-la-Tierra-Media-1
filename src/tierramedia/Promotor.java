package tierramedia;

import java.util.Scanner;

public class Promotor {

	PaqueteAtracciones paqueteAtracciones = new PaqueteAtracciones();
	ListadoUsuarios listadoUsuarios = new ListadoUsuarios();
	PaquetePromociones paquetePromociones = new PaquetePromociones(paqueteAtracciones.getAtracciones());
	Itinerario itinerario;

	public void iniciar() {
		// El Promotor recorre la lista de usuarios y para cada uno crea un Itinerario y
		// le asigna el Usuario.
		// Evalua lo que le puede sugerir.
		for (Usuario usuario : listadoUsuarios.getUsuarios()) {

			itinerario = new Itinerario(usuario);

			System.out.println("Nombre de visitante: " + usuario.getNombre().toUpperCase() + "\n");

			//Las promociones y las atracciones no se mezclan por lo tanto 
			//unirlas en una sola lista de ofertables no suma utilidad pero gasta más recursos.
			//Por eso se procesan separadas.
			paquetePromociones.ordenar();
			for (Promocion promocion : paquetePromociones.getPromociones()) {
				procesar(promocion, usuario);
			}

			paqueteAtracciones.ordenar();
			for (Atraccion atraccion : paqueteAtracciones.getAtracciones()) {
				procesar(atraccion, usuario);
			}
			
			System.out.println(itinerario);
			itinerario.generarArchivo();

		}
	}

	private void procesar(Ofertable oferta, Usuario usuario) {

		//		verificar Ya Cargada
		if (!itinerario.estaCargada(oferta)) {
			//		verificar Cupo
			if (oferta.hayCupo()) {
				//		verificar Usuario Presupuesto
				if (usuario.getPresupuesto() >= oferta.obtenerCosto()) {
					//		verificar Usuario Tiempo
					if (usuario.getTiempo() >= oferta.obtenerDuracion()) {
						//		sugerir
						System.out.println(oferta);
						
						Scanner entrada = new Scanner(System.in);
						String respuesta = "";
						
						while (!respuesta.equals("S") && !respuesta.equals("N")) {
							System.out.println("\n¿Acepta sugerencia? Ingrese S o N");
							respuesta = (entrada.nextLine()).toUpperCase();
						}

						//		si acepta Sugerencia agregar Al Itinerario
						if (respuesta.equals("S")) {
							System.out.println("¡Sugerencia Aceptada!");
							itinerario.agregar(oferta);
							
						}else {
							System.out.println("¡Sugerencia Rechazada!");
						}
						System.out.println("\n-------------------------------------------------------------------\n");
						entrada.close();
					}
				}
			}
		}
	}

}
