package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.Departamento;
import edu.uniquindio.estructura.util.Herramientas;

public class DepartamentoAccesoDato extends CsvAccesoDatos<Departamento, String>{

	public DepartamentoAccesoDato() throws IOException {
		super(Herramientas.getDirectorioSolicitudUtilitario() + "\\departamentosColombia.csv");
	}

}