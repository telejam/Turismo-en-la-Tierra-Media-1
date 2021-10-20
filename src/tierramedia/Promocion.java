package tierramedia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public abstract class Promocion implements Ofertable(String nombre, String[] atracciones) {

	protected String nombre;
	protected String[] atracciones;
	
	
	public abstract Boolean hayCupo();

	public abstract Double obtenerDuracion();
	
	List<Atraccion> obtenerContenido();
	}

