package trabajo;

import java.util.List;

public class App {

	public static void main(String[] args) {
		// 		private ListadoUsuarios usuarios = new ListadoUsuarios();

		ListadoUsuarios listado = new ListadoUsuarios();
		// archivos/in/usuarios.csv
		
		List<Usuario> usuarios = listado.leerUsuarios("archivosEntrada/usuarios.csv");
		for (Usuario usuario : usuarios) {
			listado.agregarUsuario(usuario);
		}

		System.out.println(listado.getUsuario());
		//System.out.println(listado);

	}
/*
	git@github.com:telejam/Turismo-en-la-Tierra-Media.git
	*/
}
