package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.registros.ListaNegraRegistro;
import edu.uniquindio.estructura.util.Herramientas;

public class ListaNegraRegistroAccesoDato extends CsvAccesoDatos<ListaNegraRegistro, String>{

	public ListaNegraRegistroAccesoDato() throws IOException {
		super(Herramientas.getDirectorioSolicitud()  + "\\listaSolicitudInhabilitados.csv");
	}
	
}