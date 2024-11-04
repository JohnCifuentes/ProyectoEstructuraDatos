package edu.uniquindio.estructura.modelo.csv;

import java.util.List;

public interface IAccessoDatos<ClaseEntidad, TipoId> {

    public List<ClaseEntidad> obtenerTodos();
}
