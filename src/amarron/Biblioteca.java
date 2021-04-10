package amarron;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;



public class Biblioteca {
	
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private ArrayList<Socio> socios = new ArrayList<Socio>();
	private ArrayList<Reservas> lReservas = new ArrayList<Reservas>();
	
	// LECTURA Y CARGA DE LOS LIBROS
	public void cargaL() {
		String fichero = "libros.csv";
		Libro libro = new Libro();
		
		BufferedReader br;
		String[] datos;
		try {
			br = new BufferedReader(new FileReader(fichero));
			
			do {
				datos = (br.readLine().split(";"));
				libro = new Libro(datos[0],datos[1],Integer.parseInt(datos[2]),Float.parseFloat(datos[3]),Integer.parseInt(datos[4]));
				this.libros.add(libro);
				
			}while(br.ready());
			
		} catch (Exception e) {
			System.out.println("No se encuentran los libros o aun no existen.");
		}
		
		
	}
	
	// LECTURA Y CARGA DE LOS SOCIOS
	public void cargaS() {
	
		Socio socio = new Socio();
		String fichero = "socios.csv";
		BufferedReader br;
		String[] datos;
		try {
			br = new BufferedReader(new FileReader(fichero));
			
			do {
				datos = (br.readLine().split(";"));
				socio= new Socio(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),datos[2],Integer.parseInt(datos[3]),datos[4]);
				this.socios.add(socio);
				
			}while(br.ready());
			
		} catch (Exception e) {
			System.out.println("No se encuentran los socios o aun no existen.");
		}
		
		
	}
	
	// LECTURA Y CARGA DE LAS RESERVAS
	public void cargaR() {
		Reservas reserva;
		String fichero = "reserva.csv";
		BufferedReader br;
		String[] datos;
		LocalDate fini;
		LocalDate ffin;
		boolean reservado;
		
		try {
			br = new BufferedReader(new FileReader(fichero));
			
			do {
				datos = (br.readLine().split(";"));
				fini = LocalDate.parse(datos[3]);
				
				if (datos[4].equals("null")) {
					ffin = null;
				}
				else {
					ffin = LocalDate.parse(datos[4]);
				}
				if (datos[5].equals("false")) {
					reservado = false;
				}else {
					reservado = true;
				}
			
				reserva= new Reservas(Integer.parseInt(datos[1]),Integer.parseInt(datos[0]),Float.parseFloat(datos[2]),
						fini,ffin,reservado,Integer.parseInt(datos[6]),Long.parseLong(datos[7]));
				reserva.ultId(Integer.parseInt(datos[6]));
				this.lReservas.add(reserva);
				
				
			}while(br.ready());
			
		} catch (Exception e) {
			System.out.println("No se encuentran las reservas o aun no existen.");
		}
	}
	
	public ArrayList<Libro> getLibros(){
		return this.libros;
	}
	
	public ArrayList<Socio> getSocios(){
		return this.socios;
	}
		
	public ArrayList<Reservas> getReservas(){
		return lReservas;
	}
	
	public void guardarLibros() {
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("libros.csv",false));
			for (Libro libro : libros) {
				
				bw.write(libro.getV());
				bw.newLine();
				
			}
			bw.close();
		} catch (Exception e) {
			System.out.println("error al guardar los libros");
		}
		
	}
	
	public void guardarSocios() {
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("socios.csv",false));
			for (Socio socio : socios) {
				
				bw.write(socio.getV());
				
			}
			bw.close();
		} catch (Exception e) {
			System.out.println("error al guardar los socios");
		}
		
	}
	
	public void guardarReservas() {
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("reserva.csv",false));
			for (Reservas rese : lReservas) {
				bw.write(rese.getV());
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			System.out.println("error reserva" + e.getMessage());
		}
		
	}
	
	public void altaLibro() {
		Libro libroNuevo = new Libro();
		Escaner esc = new Escaner();
		
		libroNuevo.setIsbn();
		
		System.out.println("Introduzca un titulo");
		libroNuevo.setTitulo(esc.nextLine());
		
		System.out.println("Introduzca un autor");
		esc = new Escaner();
		libroNuevo.setAutor(esc.nextLine());
		
		System.out.println("Introduzca la cantidad de ejemplares");
		esc = new Escaner();
		libroNuevo.setEjemplares(esc.nextInt());
		
		System.out.println("Introduzca un precio");
		libroNuevo.setPrecio(esc.nextFloat());
	
		libros.add(libroNuevo);
	}
	
	public int altaSocio() {
		Socio soci = new Socio();
		Escaner esc = new Escaner();
		soci.setId();
		int dni = 0;
		boolean flag = false;
		do {
			flag = false;
			System.out.println("Introduzca el Dni");
			dni = esc.nextInt();
			for (Socio soc : socios) {
				if (soc.getDni() == dni) {
					System.out.println("El cliente ya existe.");
					flag = true;
					break;
				}
			}
		}while(flag);
		soci.setDni(dni);
		
		System.out.println("Intoduzca el nombre");
		soci.setNombre(esc.nextLine());
		System.out.println("Introduzca el email");
		// crear metodo correo teclado
		soci.setEmail(esc.nextLine());
		System.out.println("Introduzca el telefono");
		soci.setTlfno(esc.nextInt());
		socios.add(soci);
		return socios.get(socios.size()-1).getDni();
	}

	public void altaReserva() {
		boolean flag = true;
		int tnt = 0;
		int busca = 0;
		String buscaN = "";
		Reservas reser = new Reservas();
		Escaner esc = new Escaner();
		Socio retor = new Socio();
		
		do {
			flag = true;
			System.out.println("Escriba \n"
					+ "1- Si desea buscar por nombre  \n"
					+ "2- si desea buscar por Dni \n"
					+ "3- si desea busacr por id \n"
					+ "4- si desea dar de alta a un nuevo cliente");
			tnt = esc.nextInt();
			
			switch (tnt) {
			case 4:
				reser.setrDni(altaSocio());
				flag = false;
				break;
				
			case 1:
				
				ArrayList<Socio> res = new ArrayList<Socio>();
				do {
					
					System.out.println("Escriba el nombre");
					buscaN = esc.next();
					res =searchSocioNombre(buscaN);
					if(res == null) {
						System.out.println("El nombre no se encontro vuelva a intentarlo");
					}
					if (res.size() == 1) {
						reser.setrDni(res.get(res.size()-1).getDni());
						
					}else if(res.size() >= 1) {
						int contador = res.size();
						for (int i = 0; i < res.size(); i++) {
							System.out.println("Opcion " + (i+1) +"\n" + res.get(i).toString());
						}
						
						System.out.println("Elija una opcion");
						tnt = esc.nextInt();
						if (tnt > 0 && tnt <= contador) {
							reser.setrDni(res.get(tnt-1).getDni());
							System.out.println("seleccionado " + res.get(tnt-1).getNombre() );
						}else {
							System.out.println("Elija una opcion valida");
						}
					}
					
				}while(res == null);
				
				flag = false;
				break;
				
			case 2:
				do {
					System.out.println("Escriba el Dni");
					busca = esc.nextInt();
					retor = searchSocioDni(busca);
					if (retor != null) {
						reser.setrDni(busca);
					}
				}while(retor == null);
				flag = false;
				break;
				
			case 3:
				do {
					System.out.println("Escriba el ID");
					busca = esc.nextInt();
					retor = searchSocioId(busca);
					if (retor != null) {
						reser.setrDni(busca);
					}
				}while(retor == null);
				flag = false;
				break;
	
			default: 
				System.out.println("Opcion invalida vuelva a intentarlo");
				break;
			}
			

		} while (flag);
		
		flag = true;
		tnt = 0;
		
		do {
			
			System.out.println("Buscar Libro por:"
					+ "\n\t 1- ISBN "
					+ "\n\t 2- Titulo"
					+ "\n\t 3- Cancelar");
			tnt = esc.nextInt();
			switch (tnt) {
			case 1:
				
				System.out.println("Escriba el ISBN");
				esc = new Escaner();
				tnt = esc.nextInt();
				reser.setrIsbn(searchLibroIsbn(tnt).getIsbn());
				flag = false;
				break;
			case 2:
				
				ArrayList<Libro> res = new ArrayList<Libro>();
					do {
						flag = true;
						System.out.println("Escriba el titulo");
						esc = new Escaner();
						buscaN = esc.next();
						res = searchLibroT(buscaN);
						if (res.size()==0) {
							System.out.println("Titulo no encontrado vuelva a intentarlo");
						}
						else if (res.size() == 1) {
							reser.setrIsbn(res.get(res.size()-1).getIsbn());
							System.out.println(res.get(res.size()-1).getIsbn());
							System.out.println("Libro encontrado");
							flag = false;
							
						}
						else if(res.size()>1 ) {
							int contador = res.size();
							for (int i = 0; i < res.size(); i++) {
								System.out.println("Opcion " + (i+1)+"\n" + res.get(i).toString() + "\n" );
							}
							
							System.out.println("Elija una opcion");
							esc = new Escaner();
							tnt = esc.nextInt();
							if (tnt > 0 && tnt <= contador) {
								reser.setrIsbn(res.get(tnt-1).getIsbn());
								System.out.println("Libro seleccionado " + reser.getrIsbn());
																
								for (Libro lLib : libros) {
									if (reser.getrIsbn() == lLib.getIsbn()) {
										if (lLib.getEjemplares()>0) {
											lLib.setEjemplares(lLib.getEjemplares()-1);
											reser.setFinicial();
											reser.setDevuelto(false);
											lReservas.add(reser);
											lReservas.get(lReservas.size()-1).setId();
											flag = false;
											break;
											
										}else {
											flag = true;
											System.out.println("No quedan ejemplares, vuelva a intentarlo ");
										}
										
									}
								}
							}else {
								System.out.println("Elija una opcion valida");
							}
							
						}	
					}while(flag);
					
				break;
			case 3:
				flag = false;
				break;
			
			default:
				System.out.println("Opcion no valida vuelva a intentarlo");
				break;
					
				}
			}while(flag);
		
			flag = true;
			
			
			
		}
		
	public ArrayList<Socio> searchSocioNombre(String nombre) {
		ArrayList<Socio> auxList = new ArrayList<>();
		for (Socio socio : socios) {
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
	
	public Socio searchSocioDni(int dni) {
		Socio retorno = new Socio();
		for (Socio buscar : socios) {
			if (buscar.getDni() == dni) {
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
		for (Libro Buscar : libros) {
			if (Buscar.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
				auxList.add(Buscar);
			}
		}
		
		return auxList;
	}
	
	public ArrayList<Reservas> searchReserActi(){
		ArrayList<Reservas> res2 = new ArrayList<Reservas>();
		String res ="";
		for (Reservas reservas : lReservas) {
			if (reservas.isDevuelto()==false) {
				res2.add(reservas);
				res+= "ID: " +reservas.getId() + "\n";
				for (Socio soc : socios) {
					if (reservas.getrDni() == soc.getDni()) {
						res += "Nombre: " + soc.getNombre() + "\n"
							+ "Dni: " + reservas.getrDni() + "\n";
						break;
					}
				}
				for (Libro lib : libros) {
					if (reservas.getrIsbn() == lib.getIsbn()) {
						res+= "Titulo: " + lib.getTitulo() + "\n"
							+ "Autor: " + lib.getAutor() +"\n"
							+ "ISBN: " + reservas.getrIsbn() + "\n"
							+"------------------------------- \n";
						break;
					}
				}
				
			}
		}
		System.out.println(res);
		return res2;
		
	}
	
	public void searchReser() {
		String res ="";
		for (Reservas reservas : lReservas) {
				for (Socio soc : socios) {
					if (reservas.getrDni() == soc.getDni()) {
						res += "Nombre: " + soc.getNombre() + "\n"
							+ "Dni: " + reservas.getrDni() + "\n";
						break;
					}
				}
				for (Libro lib : libros) {
					if (reservas.getrIsbn() == lib.getIsbn()) {
						res+= "Titulo: " + lib.getTitulo() + "\n"
							+ "Autor: " + lib.getAutor() +"\n"
							+ "ISBN: " + reservas.getrIsbn() + "\n";
						break;
					}
				}
				res += "Fecha Inicial: " + reservas.getFinicial() + "\n";
				if (reservas.isDevuelto()==true) {
					res += "Fecha Final: " + reservas.getFfin() + "\n"
							+ "Dias totales: " + reservas.getDias() + "\n"
							+ "Total Pagado: " + reservas.getTotal()+"€" + "\n";
					
				}
				res += "----------------------------------------------- \n";
			}
		System.out.println(res);
		
	}
	
	public void devolL() {
		Escaner esc = new Escaner();
		boolean bol;
		boolean flag = true;
		int id = 0;
		Libro lec = new Libro();
		
			if (searchReserActi() != null) {
		
				do {
					System.out.println("Seleccione una reserva valida escribiendo el ID");
					id = esc.nextInt();
					for (Reservas reservas : lReservas) {
						if (id==reservas.getId()) {
							System.out.println("Desea devolver el libro?");
							bol = esc.bool();
								if (bol) {
									flag = false;
									reservas.setDevuelto(true);
									reservas.setFfin();
									reservas.setDias();
									if(reservas.getDias()!= 0) {
										for (Libro libro : libros) {
											if (reservas.getrIsbn() == libro.getIsbn()) {
												lec = libro;
												reservas.setTotal(libro.getPrecio());
											}
										}
										System.out.println("\n Se ha realizado la devolucion del libro: " + lec.getTitulo()
														+ "\n El total de dias es: " + reservas.getDias()+ 
														"\n Con un precio total de: " + reservas.getTotal() +"€" + "\n");
									}else {
										System.out.println("El libro se ha devuelto el mismo dia no tendra costo. Muchas gracias... \n");
									}
								}
						}
					}
				}while(flag);
			}else {
				System.out.println("No hay reservas disponibles para devolver.");
			}

	}
}
