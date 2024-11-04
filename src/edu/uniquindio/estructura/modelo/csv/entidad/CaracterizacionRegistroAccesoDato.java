package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.CaracterizacionRegistro;

public class CaracterizacionRegistroAccesoDato extends CsvAccesoDatos<CaracterizacionRegistro, String>{

	public CaracterizacionRegistroAccesoDato() throws IOException {
		super("");
	}
	
	public CaracterizacionRegistroAccesoDato(String ruta) throws IOException {
		super(ruta);
	}

}
