package amarron;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// INICIO DE LA BIBLIOTECA
		Biblioteca bib = new Biblioteca();
		Initializer(bib);
		Escaner esc = new Escaner();
		
		
		// COMIENZO DE LA APLICACION
		int ele = 0;
		
		do {
			System.out.println("1- Realizar una reserva \n"
								+ "2- Devolver un libro \n"
								+ "3- Alta cliente \n"
								+ "4- Alta libro \n"
								+ "5- Ver reservas activas \n"
								+ "6- Ver todas las reservas \n"
								+ "7- ver todos los clientes y libros \n"
								+ "10- Salir y guardar.");
			System.out.println("Escriba la opcion");
			ele = esc.nextInt();
			switch (ele) {
			case 1:
				bib.altaReserva();
				break;
			case 2:
				bib.devolL();
				break;
			case 3:
				bib.altaSocio();
				break;
			case 4:
				bib.altaLibro();
				break;
			case 5:
				bib.searchReserActi();
				break;
			case 6:
				bib.searchReser();
				break;
			case 7:
				for (Socio soci : bib.getSocios()) {
					System.out.println(soci.toString());
					System.out.println("-------------------------");
				}
				
				for (Libro lib : bib.getLibros()) {
					System.out.println(lib.toString());
					System.out.println("-------------------------");
					
				}
				
				break;
			case 10:
				System.out.println("Saliendo y guardando...");
				break;

			default:
				System.out.println("Opcion no valida");
				break;
			}
			
		}while(ele !=10);
		
	bib.guardarLibros();
	bib.guardarSocios();
	bib.guardarReservas();
		
	}
	
	public static void Initializer(Biblioteca bib) {
		
		bib.cargaL();
		bib.cargaS();
		bib.cargaR();
		
	}

}
