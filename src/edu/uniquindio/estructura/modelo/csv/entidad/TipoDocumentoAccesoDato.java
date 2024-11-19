package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.TipoDocumento;
import edu.uniquindio.estructura.util.Herramientas;

public class TipoDocumentoAccesoDato extends CsvAccesoDatos<TipoDocumento, String>{

	public TipoDocumentoAccesoDato() throws IOException {
		super(Herramientas.getDirectorioSolicitudUtilitario() + "\\tiposDocumento.csv");
	}

}
