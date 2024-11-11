package edu.uniquindio.estructura.controlador;

import java.io.IOException;
import java.util.ArrayList;

import edu.CargarArchivos;
import edu.uniquindio.estructura.modelo.csv.entidad.CaracterizacionRegistroAccesoDato;
import edu.uniquindio.estructura.modelo.entidades.Caracterizacion;
import edu.uniquindio.estructura.modelo.entidades.CaracterizacionRegistro;
import edu.uniquindio.estructura.modelo.entidades.Persona;
import edu.uniquindio.estructura.modelo.entidades.TipoCaracterizacion;
import edu.uniquindio.estructura.modelo.entidades.TipoEntidad;
import edu.uniquindio.estructura.util.AdministrarArchivosDirectorio;
import edu.uniquindio.estructura.util.Herramientas;

public class ControladorCaracterizacion {
	private static final String DIRECTORIO = "C:\\Users\\johnc\\eclipse-workspace\\ProyectoEstructuraDatos\\recursos\\Caracterizaciones";
	private static final int TAMANO_NOMBRE_ARCHIVO = 14; 
	
	private CargarArchivos cargarArchivos;
	private ArrayList<Caracterizacion> caracterizaciones;
	
	public ControladorCaracterizacion(CargarArchivos cargarArchivos) {
		this.cargarArchivos = cargarArchivos;
		this.caracterizaciones = cargarCaracterizaciones();
	}
	
	private ArrayList<Caracterizacion> cargarCaracterizaciones(){
		ArrayList<Caracterizacion> caracterizaciones = new ArrayList<>();
		
		for(String a: new AdministrarArchivosDirectorio().obtenerNombresObjetosEnDirectorio(DIRECTORIO)) {
			if(validarEstructuraNombreArchivo(a)) {
				try {
					for(CaracterizacionRegistro c: new CaracterizacionRegistroAccesoDato(DIRECTORIO + "\\" + a).obtenerTodos()) {
						if(validarEstructuraRegistroArchivo(c)) {
							caracterizaciones.add(new Caracterizacion(
									TipoEntidad.getTipoEntidad(a.substring(0,  2)),
									(new Persona(this.cargarArchivos.getArchivosUtilitario().getTipoDocumento(c.getTipoDocumento()), c.getDocumento(), c.getNombreCompleto())),
									TipoCaracterizacion.getTipoCaracterizacion(c.getCaracterizacion())));
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return caracterizaciones;
	}
	
	private boolean validarEstructuraNombreArchivo(String nombreArchivo) {		
		if(nombreArchivo.length() > TAMANO_NOMBRE_ARCHIVO || !TipoEntidad.existe(nombreArchivo.substring(0,  2)) || !Herramientas.validarFormatoFecha(nombreArchivo.substring(2, 10))) {
			return false;
		}
		return true;
	}
	
	private boolean validarEstructuraRegistroArchivo(CaracterizacionRegistro caracterizacionRegistro) {
		if(!this.cargarArchivos.getArchivosUtilitario().existeTipoDocumento(caracterizacionRegistro.getTipoDocumento()) || !TipoCaracterizacion.existe(caracterizacionRegistro.getCaracterizacion())) {
			return false;
		}
		return true;
	}
	
	public TipoCaracterizacion existeCaracterizacion(Persona persona) {
		for(Caracterizacion c: this.caracterizaciones) {
			if(c.getPersona().getTipoDocumento().equals(persona.getTipoDocumento()) && c.getPersona().getDocumento().equals(persona.getDocumento())) {
				return c.getTipoCaracterizacion();
			}
		}
		return null;
	}
}