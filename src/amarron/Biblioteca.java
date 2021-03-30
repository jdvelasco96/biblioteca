package amarron;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Biblioteca {
	
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private ArrayList<Socio> socios = new ArrayList<Socio>();
	
	// LECTURA Y CARGA DE LOS LIBROS
	public void cargaL() {
		String fichero = "C:\\Users\\Ceinmark\\eclipse-workspace\\amarron\\src\\amarron\\datos.csv";
		Libro libro = new Libro();
		
		BufferedReader br;
		String[] datos = new String[4];
		try {
			br = new BufferedReader(new FileReader(fichero));
			
			do {
				datos = (br.readLine().split(";"));
				libro = new Libro(datos[0],datos[1],Integer.parseInt(datos[2]),Float.parseFloat(datos[3]));
				
				this.libros.add(libro);
				
			}while(br.ready());
			
		} catch (Exception e) {
			System.out.println("ocurrio un error");
		}
		
		
	}
	
	// LECTURA Y CARGA DE LOS SOCIOS
	public void cargaS() {
	
		Socio socio = new Socio();
		String fichero = "";
		BufferedReader br;
		String[] datos = new String[3];
		try {
			br = new BufferedReader(new FileReader(fichero));
			
			do {
				datos = (br.readLine().split(";"));
				socio= new Socio(datos[0],Integer.parseInt(datos[1]),datos[2]);
				this.socios.add(socio);
				
			}while(br.ready());
			
		} catch (Exception e) {
			System.out.println("ocurrio un error");
		}
		
		
	}
	
	public ArrayList<Libro> getLibros(){
		return this.libros;
	}
	public ArrayList<Socio> getSocios(){
		return this.socios;
	}
	
	public void guardarDatos() {
		
		BufferedWriter bw = null;
		try {
			for (Libro libro : libros) {
				bw = new BufferedWriter(new FileWriter("Copia.txt",false));
				bw.write(libro.getV());
				
			}
			bw.close();
		} catch (Exception e) {
			System.out.println("error");
		}
		
	}
	
	
	public void altaLibro() {
		Libro libroNuevo = new Libro();
		Escaner esc = new Escaner();
		
		if(libros.size() > 0) {
			libroNuevo.setIsbn(libros.get(libros.size() - 1).getIsbn()+1);
			
		}else {
			libroNuevo.setIsbn(100);
		}
		
		System.out.println("Introduzca un titulo");
		libroNuevo.setTitulo(esc.next());
		
		System.out.println("Introduzca un autor");
		libroNuevo.setAutor(esc.next());
		
		System.out.println("Introduzca la cantidad de ejemplares");
		libroNuevo.setEjemplares(esc.nextInt());
		
		System.out.println("Introduzca un precio");
		libroNuevo.setPrecio(esc.nextFloat());
	
		libros.add(libroNuevo);
	}
	
	public void altaSocio() {
		Socio soci = new Socio();
		Escaner esc = new Escaner();
		soci.setId();
		System.out.println("Intoduzca el nombre");
		soci.setNombre(esc.next());
		System.out.println("Introduzca el email");
		// crear metodo correo teclado
		soci.setEmail(esc.next());
		System.out.println("Introduzca el telefono");
		soci.setTlfno(esc.nextInt());
		socios.add(soci);
	}
	public ArrayList<Socio> searchSocioNombre(String nombre) {
		ArrayList<Socio> auxList = new ArrayList<>();
		for (Socio socio : auxList) {
			if (socio.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
				auxList.add(socio);
			}
		}
		
		return auxList;
	}
	public Socio searchSocioId(int id) {
		Socio retorno = new Socio();
		for (Socio buscar : socios) {
			if (buscar.getId() == id) {
				retorno = buscar;
			}
		}
		return retorno;
		
	}

	public Libro searchLibroIsbn(int ISBN) {
		Libro retorno = new Libro();
		for (Libro bus : libros) {
			if (bus.getIsbn() == ISBN) {
				retorno = bus;
			}
		}
		return retorno;
		
	}
	public ArrayList<Libro> searchLibroAutor(String autor) {
		ArrayList<Libro> auxList = new ArrayList<>();
		for (Libro Buscar : auxList) {
			if (Buscar.getAutor().toLowerCase().contains(autor.toLowerCase())) {
				auxList.add(Buscar);
			}
		}
		
		return auxList;
	}
	public ArrayList<Libro> searchLibroT(String titulo) {
		ArrayList<Libro> auxList = new ArrayList<>();
		for (Libro Buscar : auxList) {
			if (Buscar.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
				auxList.add(Buscar);
			}
		}
		
		return auxList;
	}
	
}
