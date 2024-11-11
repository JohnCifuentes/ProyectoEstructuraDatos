package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.Departamento;

public class DepartamentoAccesoDato extends CsvAccesoDatos<Departamento, String>{

	public DepartamentoAccesoDato() throws IOException {
		super("C:\\Users\\johnc\\eclipse-workspace\\ProyectoEstructuraDatos\\recursos\\Utilitario\\departamentosColombia.csv");
	}

}