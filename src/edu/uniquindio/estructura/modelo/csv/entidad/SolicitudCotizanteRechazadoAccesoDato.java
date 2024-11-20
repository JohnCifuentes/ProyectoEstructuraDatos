package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.registros.SolicitudCotizanteRechazadoRegistro;
import edu.uniquindio.estructura.util.Herramientas;

public class SolicitudCotizanteRechazadoAccesoDato extends CsvAccesoDatos<SolicitudCotizanteRechazadoRegistro, String>{

	public SolicitudCotizanteRechazadoAccesoDato() throws IOException {
		super(Herramientas.getDirectorioSolicitud() + "\\listaSolicitudCotizantesRechazados.csv");
	}

}
