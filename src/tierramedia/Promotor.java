package tierramedia;

import java.util.Scanner;

public class Promotor {

	PaqueteAtracciones paqueteAtracciones = new PaqueteAtracciones();
	ListadoUsuarios listadoUsuarios = new ListadoUsuarios();
	PaquetePromociones paquetePromociones = new PaquetePromociones(paqueteAtracciones);
	Itinerario itinerario;

	public void iniciar() {
		// El Promotor recorre la lista de usuarios y para cada uno crea un Itinerario y
		// le asigna el Usuario.
		// Evalua lo que le puede sugerir.
		for (Usuario usuario : listadoUsuarios.usuarios) {

			itinerario = new Itinerario(usuario.getNombre());

			System.out.println("Nombre de visitante: " + usuario.getNombre().toUpperCase() + "\n");

			for (Promocion promocion : paquetePromociones.promociones) {
				procesar(promocion, usuario);
			}

			paqueteAtracciones.ordenarPorPrecio();
			for (Atraccion atraccion : paqueteAtracciones.atracciones) {
				procesar(atraccion, usuario);
			}

			paqueteAtracciones.ordenarPorTiempo();
			for (Atraccion atraccion : paqueteAtracciones.atracciones) {
				procesar(atraccion, usuario);
			}

		}
	}

	/*
	 * Por cada posible Promocion/Atraccion, verifica en el Itinerario si ya está
	 * cargada (decirle eso es tarea del Itinerario). Si no está y el Usuario la
	 * acepta, agrega la Atraccion en la lista del Itinerario (setter?) Suma al
	 * costo de la visita ya acumulado el costo de esa Atraccion (o atracciones si
	 * es una promo). Ahí Itinerario debería tener un método para hacer eso que
	 * pueda llamar el Promotor (acumularCosto por ej.) Algo parecido para el tiempo
	 * de visita. Cuando ya no queda más para ofrecerle al Usuario, llama a los
	 * métodos del Iterador para mostrar el recorrido y generar el archivo de ese
	 * Usuario. Pasa al siguiente usuario y vuelta a empezar.
	 */
	private void procesar(Ofertable oferta, Usuario usuario) {

		//		verificar Ya Cargada
		if (!oferta.estaCargada()) {
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
							
						}else {
							System.out.println("¡Sugerencia Rechazada!");
						}
						System.out.println("\n-------------------------------------------------------------------\n");
					}
				}
			}
		}
	}

}
