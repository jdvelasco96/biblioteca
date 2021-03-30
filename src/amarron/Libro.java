package amarron;

public class Libro {
	
	private int isbn;
	private int ejemplares;
	private float precio;
	private String autor;
	private String titulo;
	
	private static int ultimoIsbn = 0;
	
	public Libro(String titulo, String autor, int ejemplares, float precio) {
		setIsbn();
		this.titulo = titulo;
		this.autor = autor;
		this.ejemplares = ejemplares;
		this.precio = precio;
		
	}
	

	public Libro() {
		isbn = 0;
		ejemplares = 0;
		precio = 0;
		autor = "";
		titulo = "";
	}


	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn() {
		
		if(ultimoIsbn >=100) {
			isbn = ultimoIsbn + 1;
			ultimoIsbn += 1;
		}else {
			if(ultimoIsbn == 0) {
				isbn = 100;
				ultimoIsbn = 100;
			}
		}
		
	}
	
	public String getV() {
		return getTitulo() + ";" + getAutor() + ";" + getEjemplares() + ";" + getPrecio() + "\n";
	}
	
	public void setIsbn(int iSBN) {
		isbn = iSBN;
	}
	public int getEjemplares() {
		return ejemplares;
	}
	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		return "El ISBN es: " + getIsbn() + "\n"
				 + "Con titulo: " + getTitulo() + "\n"
				 + "Del autor: " + getAutor() + "\n"
				 + "Con Stock de: " + getEjemplares() + "\n"
				 + "Con precio de: " + getPrecio();
	}
	
	
	

}
