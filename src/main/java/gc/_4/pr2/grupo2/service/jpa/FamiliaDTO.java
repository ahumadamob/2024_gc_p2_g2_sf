package gc._4.pr2.grupo2.service.jpa;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class FamiliaDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@SuppressWarnings("unused")
	private String apellido;
	private String dni;
    private String relacion; //  "Padre", "Madre", "Hijo", "Hija"
    private String propiedad;
    private boolean viveEnPropiedad;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRelacion() {
		return relacion;
	}
	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}
	public boolean isViveEnPropiedad() {
		return viveEnPropiedad;
	}
	public void setViveEnPropiedad(boolean viveEnPropiedad) {
		this.viveEnPropiedad = viveEnPropiedad;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
		
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPropiedad() {
		return propiedad;
	}
	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}
	

}
