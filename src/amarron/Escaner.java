package amarron;


import java.util.Scanner;

public class Escaner {
	Scanner esc;
	
	public Escaner() {
		esc = new Scanner(System.in);
	}
	
	public String next() {
		String string = esc.next();
		return string;
	}
	
	public String nextLine() {
		String string = esc.next();
		return string;
	}


	@SuppressWarnings("unused")
	public int nextInt() {
		boolean noContinuar = true;
		boolean pasa = false;
		String frase = "";
		int ent=0;
		do {
			pasa = false;
			// System.out.println("introduzca un numero");
			frase = esc.nextLine();

			for(int i = 0;i<frase.length();i++) {
				if(!(frase.charAt(i) >= 48 && frase.charAt(i) <= 57)){
					System.out.println("introduzca un numero valido");
					break;
				}
				else if((i+1)==frase.length()) {
					pasa = true;
					break;
				}
			}
				if(pasa) {
					ent = Integer.parseInt(frase);
					break;
				}
		
		}while(noContinuar);
		return ent;
	}
	
	public float nextFloat() {
		float flt = 0.00f;
		boolean noPasar = true;
		String aux ="";
		String nuevoFloat ="";
		
		int cont = 0;
		do {
//			System.out.println("escriba un float");
			aux = esc.next();
			
			if(aux.contains(",")) {
				aux = aux.replace(',', '.');
			}
			
			
			for (int i = 0; i < aux.length(); i++) {
				if(aux.charAt(i) == '.') {
					cont++;
				}
				if(!(aux.charAt(i) >= 48 && aux.charAt(i) <= 57) && aux.charAt(i)!=46) {
					System.out.println("no se puede escribir letras vuelva a escribir el numero");
					break;
				}else if(cont >= 2 && aux.charAt(i) == '.') {
				}else {
					nuevoFloat += aux.charAt(i);
				}
				if(i == aux.length()-1){
					if(!(nuevoFloat.equals("."))) {
						flt = Float.parseFloat(nuevoFloat);
						noPasar = false;
						break;
					}else {
						System.out.println("Tiene que ser un numero");
						break;
					}
				}
				
			}
			
	
		}while(noPasar);
		
		return flt;
	}
	
	// Eleccion del para el setBoolean
		public boolean bool() {
			boolean flag = true;
			boolean pasar = false;
			String eleccion = "";
			System.out.println("escriba: \n- 1 o 2 \n- t o f \n- true o false \n- Si o No\n -S o N");
			eleccion = esc.next();
			
			do {
				if(eleccion.equalsIgnoreCase("1")||
				   eleccion.equalsIgnoreCase("t")||
				   eleccion.equalsIgnoreCase("Si")||
				   eleccion.equalsIgnoreCase("S")||
				   eleccion.equalsIgnoreCase("true")) {
					pasar = true;
					break;
				}else if(eleccion.equalsIgnoreCase("2")||
						   eleccion.equalsIgnoreCase("f")||
						   eleccion.equalsIgnoreCase("No")||
						   eleccion.equalsIgnoreCase("N")||
						   eleccion.equalsIgnoreCase("false")) {
					pasar = false;
					break;
				}else {
					System.out.println("Valor incorrecto "+"\n" + "escriba: \n- 1 o 2 \n- t o f \n- true o false \n- Si o No \n -S o N");
					eleccion = esc.next();
				}
				
			}while(flag);
			return pasar;
			
		}
		
	
	


}
