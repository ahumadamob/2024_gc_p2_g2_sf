package gc._4.pr2.grupo2.service;

import java.util.List;


import gc._4.pr2.grupo2.entity.Visita;

public interface IVisitaService {
    Visita guardarVisita(Visita visita);
    List<Visita> obtenerTodasLasVisitas();
    Visita obtenerVisitaPorId(Long id);
    Visita actualizarVisita(Long id, Visita visitaDetalles);
    void eliminarVisita(Long id);
    public boolean existe(Long id);

}
    






