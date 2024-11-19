package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.Municipio;
import edu.uniquindio.estructura.util.Herramientas;

public class MunicipioAccesoDato extends CsvAccesoDatos<Municipio, String>{

	public MunicipioAccesoDato() throws IOException {
		super(Herramientas.getDirectorioSolicitudUtilitario() + "\\municipiosColombia.csv");
	}

}