package edu.uniquindio.estructura.modelo.csv.entidad;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.csv.CsvAccesoDatos;
import edu.uniquindio.estructura.modelo.entidades.registros.CaracterizacionRegistro;

public class CaracterizacionRegistroAccesoDato extends CsvAccesoDatos<CaracterizacionRegistro, String>{

	public CaracterizacionRegistroAccesoDato(String rutaArchivo) throws IOException {
		super(rutaArchivo);
	}

}
