package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.Municipio;

public class MunicipioAccesoDato extends CsvAccesoDatos<Municipio, String>{

	public MunicipioAccesoDato() throws IOException {
		super("C:\\Users\\johnc\\eclipse-workspace\\ProyectoEstructuraDatos\\recursos\\Utilitario\\municipiosColombia.csv");
	}

}