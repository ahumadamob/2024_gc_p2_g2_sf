package gc._4.pr2.grupo2.service;

import java.util.List;

import gc._4.pr2.grupo2.entity.Visita;

public interface IVisitaService {
	public List<Visita>mostrarTodos();
	public Visita mostrarVisitaPorId(Long id);
	public Visita guardar(Visita visita);
	public void eliminarPorId(Long id);

}
