package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.TipoDocumento;

public class TipoDocumentoAccesoDato extends CsvAccesoDatos<TipoDocumento, String>{

	public TipoDocumentoAccesoDato() throws IOException {
		super("C:\\Users\\Steba\\IdeaProjects\\ProyectoEstructuraDatos\\recursos\\Utilitario\\tiposDocumento.csv");
	}

}
