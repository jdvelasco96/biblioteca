package amarron;

import java.util.ArrayList;

public class Biblioteca {
	
	private ArrayList<Libro> libros = new ArrayList<>();
	private ArrayList<Socio> socios = new ArrayList<>();
	
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
