package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.ListaNegraRegistro;

public class ListaNegraRegistroAccesoDato extends CsvAccesoDatos<ListaNegraRegistro, String>{

	public ListaNegraRegistroAccesoDato() throws IOException {
		super("C:\\Users\\Steba\\IdeaProjects\\ProyectoEstructuraDatos\\recursos\\Caracterizaciones\\listaNegra.csv");
	}
	
}