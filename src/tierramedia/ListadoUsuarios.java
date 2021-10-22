package tierramedia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListadoUsuarios {
private List<Usuario> usuarios= new ArrayList<Usuario>();
	
public void agregarUsuario(Usuario usuario) {
	this.usuarios.add(usuario);
}

	public List<Usuario> getUsuario(){
		return this.usuarios;
	}
	
	public List<Usuario> leerUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("archivos/in/usuarios.csv");
			
			br = new BufferedReader(fr);
			String linea = null;
			while ((linea = br.readLine()) != null) {
				usuarios.add(cargarUsuarios(linea));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} 
		return usuarios;

	}

	private  Usuario cargarUsuarios(String linea)    {
		String[] resultado = linea.split(",");
		Usuario usuarioLista;
		usuarioLista = new Usuario(resultado[0], Integer.parseInt(resultado[1]), Integer.parseInt(resultado[2]));
		
		return usuarioLista;
	}

}
