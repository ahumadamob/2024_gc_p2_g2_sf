package gc._4.pr2.grupo2.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="registro_de_ingreso_y_egreso")
public class RegistroDeIngresoYEgreso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate fechaIngreso;	
	private LocalTime horaIngreso;		
	private LocalDate fechaEgreso;		
	private LocalTime horaEgreso;		
	private String guardiaDeSeguridad;
	private String visita;
	private String observaciones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalTime getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(LocalTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public LocalDate getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(LocalDate fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public LocalTime getHoraEgreso() {
		return horaEgreso;
	}

	public void setHoraEgreso(LocalTime horaEgreso) {
		this.horaEgreso = horaEgreso;
	}

	public String getGuardiaDeSeguridad() {
		return guardiaDeSeguridad;
	}

	public void setGuardiaDeSeguridad(String guardiaDeSeguridad) {
		this.guardiaDeSeguridad = guardiaDeSeguridad;
	}

	public String getVisita() {
		return visita;
	}

	public void setVisita(String visita) {
		this.visita = visita;
	}

	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
