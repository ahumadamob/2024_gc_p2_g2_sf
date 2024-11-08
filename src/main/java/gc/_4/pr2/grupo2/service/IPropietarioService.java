package gc._4.pr2.grupo2.service;

import java.util.List;

import gc._4.pr2.grupo2.entity.Propietario;

public interface IPropietarioService {
	 List<Propietario>mostrar();
	public Propietario mostrarPorId(Long id);
	 Propietario guardar(Propietario propietario);
	public void eliminarPorId(Long id);
	public boolean existe(Long id);
	Propietario ActualizarPropietario(Long id, Propietario PropietarioDetalles);
}
