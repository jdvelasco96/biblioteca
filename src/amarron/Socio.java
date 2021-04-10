package amarron;

public class Socio {

	private int dni;
	private int id;
	private String nombre;
	private int tlfno;
	private String email;
	
	private static int ultimoId = 0;
	
	public Socio() {
		dni = 0;
		id = 0;
		nombre = "";
		tlfno = 0;
		email ="";
		
	}
	
	public Socio( int id,int dni,String nombre, int tlfno, String email) {
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.tlfno = tlfno;
		this.email = email;
		ultId(id);
	}

	public int getId() {
		return id;
	}

	public void setId() {
		
		if(ultimoId >=100) {
			id = ultimoId + 1;
			ultimoId += 1;
		}else {
			if(ultimoId == 0) {
				id = 100;
				ultimoId = 100;
			}
		}
		
	}
	public void ultId(int dato) {
		ultimoId = dato;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTlfno() {
		return tlfno;
	}

	public void setTlfno(int tlfno) {
		this.tlfno = tlfno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getV() {
		
		return getId()+";"+getDni()+";"+getNombre().trim()+";"+getTlfno()+";"+getEmail().trim()+";"+"\n";
	}

	@Override
	public String toString() {
		return "Socio: \n"
				+ "Id =" + getId() + "\n"
						+ "Dni =" + getDni() + "\n"
								+ "Nombre =" + getNombre().trim() + "\n"
										+ "Telefono =" + getTlfno() + "\n"
												+ "Email =" + getEmail().trim() + "\n";
	}
	
	

}
