package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.SolicitudCotizanteRegistro;

public class SolicitudCotizanteRegistroAccesoDato extends CsvAccesoDatos<SolicitudCotizanteRegistro, String>{

	public SolicitudCotizanteRegistroAccesoDato(String rutaArchivo) throws IOException {
		super(rutaArchivo);
	}

}
