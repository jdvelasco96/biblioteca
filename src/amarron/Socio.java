package amarron;

public class Socio {

	private int id;
	private String nombre;
	private int tlfno;
	private String email;
	
	private static int ultimoId = 0;
	
	public Socio() {
		
		id = 0;
		nombre = "";
		tlfno = 0;
		email ="";
		
	}

	public Socio( String nombre, int tlfno, String email) {
		setId();
		this.nombre = nombre;
		this.tlfno = tlfno;
		this.email = email;
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
	
	
	
	

}
