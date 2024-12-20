package gc._4.pr2.grupo2.service;

import java.util.List;

import gc._4.pr2.grupo2.entity.GuardiaDeSeguridad;

public interface IGuardiaDeSeguridadService {
	public List<GuardiaDeSeguridad>mostrarTodos();
	public GuardiaDeSeguridad mostrarGuardiaPorId(Long id);
	public GuardiaDeSeguridad guardar(GuardiaDeSeguridad guardia);
    public GuardiaDeSeguridad actualizarGuardia(Long id, GuardiaDeSeguridad guardiaDetalles);
	public void eliminarPorId(Long id);
	public boolean existe(Long id);
}
