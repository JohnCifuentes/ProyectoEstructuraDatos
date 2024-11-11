package edu.uniquindio.estructura.modelo.csv;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class CsvAccesoDatos<ClaseEntidad, TipoId>
        implements IAccessoDatos<ClaseEntidad, TipoId> {

    private Class<ClaseEntidad> claseEntidad;
    protected GestorEntidad GestorEntidad;

    @SuppressWarnings("unchecked")
    public CsvAccesoDatos(String rutaArchivo) throws IOException {

        this.claseEntidad = (Class<ClaseEntidad>) (
                (ParameterizedType) getClass().getGenericSuperclass()
        ).getActualTypeArguments()[0];

        this.GestorEntidad = new GestorEntidad(rutaArchivo);
        
    }

    @Override
    public List<ClaseEntidad> obtenerTodos() {
        return this.GestorEntidad.obtenerTodos(this.claseEntidad);
    }
}
