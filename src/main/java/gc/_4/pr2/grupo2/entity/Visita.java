package gc._4.pr2.grupo2.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Visita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String invitado;
	private LocalDate fechaVisita;
	private LocalTime horaIngreso;
	private LocalTime horaEgreso;
	private String propiedadVisitada;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInvitado() {
		return invitado;
	}
	public void setInvitado(String invitado) {
		this.invitado = invitado;
	}
	public LocalDate getFechaVisita() {
		return fechaVisita;
	}
	public void setFechaVisita(LocalDate fechaVisita) {
		this.fechaVisita = fechaVisita;
	}
	public LocalTime getHoraIngreso() {
		return horaIngreso;
	}
	public void setHoraIngreso(LocalTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
	public LocalTime getHoraEgreso() {
		return horaEgreso;
	}
	public void setHoraEgreso(LocalTime horaEgreso) {
		this.horaEgreso = horaEgreso;
	}
	public String getPropiedadVisitada() {
		return propiedadVisitada;
	}
	public void setPropiedadVisitada(String propiedadVisitada) {
		this.propiedadVisitada = propiedadVisitada;
	}
	
}
