package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.registros.SolicitudCotizanteAprobadoRegistro;
import edu.uniquindio.estructura.util.Herramientas;

public class SolicitudCotizanteAprobadoAccesoDato extends CsvAccesoDatos<SolicitudCotizanteAprobadoRegistro, String>{

	public SolicitudCotizanteAprobadoAccesoDato() throws IOException {
		super(Herramientas.getDirectorioSolicitud() + "\\listaSolicitudCotizantesAprobados.csv");
	}

}