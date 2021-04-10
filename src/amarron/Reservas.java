package amarron;

import java.time.LocalDate;
import java.time.Period;
import static java.time.temporal.ChronoUnit.DAYS;
public class Reservas {
	private int id;
	private int rDni;
	private int rIsbn;
	private float total;
	private LocalDate finicial;
	private LocalDate ffin;
	private boolean devuelto;
	private long dias;
	
	private static int ultIdRes = 0;
	
	public Reservas() {
		id = 0;
		rDni = 0;
		rIsbn = 0;
		total = 0;
		finicial = null;
		ffin = null;
		devuelto = false;
		dias = 0;
		
	}
	

	public Reservas(int rDni, int rIsbn, float total, LocalDate finicial, LocalDate ffin, boolean devuelto,int id,long dias) {
		this.id = id;
		this.rDni = rDni;
		this.rIsbn = rIsbn;
		this.total = total;
		this.finicial = finicial;
		this.ffin = ffin;
		this.devuelto = devuelto;
		this.dias = dias;
		ultId(id);
	}

	public int getId() {
		return id;
	}

	public void setId() {
		
		if(ultIdRes >=100) {
			id = ultIdRes + 1;
			ultIdRes += 1;
		}else {
			if(ultIdRes == 0) {
				id = 100;
				ultIdRes = 100;
			}
		}
		
	}
	public void ultId(int dato) {
		ultIdRes = dato;
	}

	public int getrDni() {
		return rDni;
	}
	public void setrDni(int rDni) {
		this.rDni = rDni;
	}
	public int getrIsbn() {
		return rIsbn;
	}
	public void setrIsbn(int rIsbn) {
		this.rIsbn = rIsbn;
	}
	public float getTotal() {
		return total;
	}
	public long getDias() {
		
		return dias;
	}
	public void setDias() {
		dias = DAYS.between(finicial, ffin);
		
	}
	public void setTotal(float precio) {
		
		this.total = precio * (getDias());
	}
	public LocalDate getFinicial() {
		return finicial;
	}
	public void setFinicial() {
		this.finicial = LocalDate.now();
	}
	public LocalDate getFfin() {
		return ffin;
	}
	public void setFfin() {
		this.ffin = LocalDate.now();	
	}
	public boolean isDevuelto() {
		return devuelto;
	}
	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}
	 
	public String getV() {
		return getrIsbn() + ";" + getrDni() + ";" + getTotal() + ";" + getFinicial() + ";" + getFfin() + ";" + isDevuelto()+ ";"+getId()+";"+getDias()+";";
	}



	@Override
	public String toString() {
		
		String res = "Reservas: \n"
				+ "Dni: " + getrDni() + " \n"
				+ "ISBN: " + getrIsbn() + "\n"
				+ "Fecha Inicial: " + getFinicial() +"\n"
				+ "ID: " + getId()+ "\n"; 
		if (isDevuelto()) {
			res += "Fecha final: " + getFfin() + "\n"
					+ "Dias: " + getDias() + "\n"
				+ "Total: " + getTotal() + "\n";
		}
		
		return res;
	}

}
