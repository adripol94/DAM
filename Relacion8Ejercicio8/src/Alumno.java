
public class Alumno {
	private String nombre;
	private double nota;
	
	Alumno(String nombre, double nota) throws AlumnoException {
		setNombre(nombre);
		setNota(nota);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws AlumnoException {
		if (nombre.isEmpty())
			throw new AlumnoException("Nombre vacío");
		this.nombre = nombre;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) throws AlumnoException {
		if (nota < 0 || nota > 10)
			throw new AlumnoException("Nota erronea");
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nota=" + nota + "]";
	}
	
}
