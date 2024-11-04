package edu.uniquindio.estructura.controlador;

import java.util.ArrayList;
import java.util.List;

import edu.uniquindio.estructura.modelo.entidades.Caracterizacion;
import edu.uniquindio.estructura.util.AdministrarArchivosDirectorio;

public class ControladorCaracterizacion {
	private static final String directorio = "C:\\Users\\johnc\\eclipse-workspace\\ProyectoEstructuraDatos\\recursos\\Caracterizaciones";
	private AdministrarArchivosDirectorio administrarArchivosDirectorio = new AdministrarArchivosDirectorio();
	
	public ArrayList<Caracterizacion> caracterizaciones(){
		List<String> nombreArchivos = this.administrarArchivosDirectorio.obtenerNombresObjetosEnDirectorio(directorio);
		nombreArchivos.forEach(d -> {
			System.out.println(d);
		});
		return null;
	}

}