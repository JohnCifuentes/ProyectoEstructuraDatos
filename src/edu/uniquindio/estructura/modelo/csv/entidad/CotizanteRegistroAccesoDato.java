package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.registros.CotizanteRegistro;
import edu.uniquindio.estructura.util.Herramientas;

public class CotizanteRegistroAccesoDato extends CsvAccesoDatos<CotizanteRegistro, String>{

	public CotizanteRegistroAccesoDato() throws IOException {
		super(Herramientas.getDirectorioSolicitud() + "\\listaCotizantes.csv");
	}

}