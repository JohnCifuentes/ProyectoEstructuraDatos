package edu;

import java.io.IOException;

import edu.uniquindio.estructura.controlador.ControladorArchivosUtilitario;
import edu.uniquindio.estructura.controlador.ControladorCaracterizacion;
import edu.uniquindio.estructura.controlador.ControladorSolicitudCotizante;

public class CargarArchivos {
	private ControladorCaracterizacion caracterizaciones;
	private ControladorArchivosUtilitario archivosUtilitario;
	private ControladorSolicitudCotizante solicitudesCotizante;
	
	public CargarArchivos() throws IOException {
		this.archivosUtilitario = new ControladorArchivosUtilitario();
		this.caracterizaciones = new ControladorCaracterizacion(this);
		this.solicitudesCotizante = new ControladorSolicitudCotizante(this);
	}

	public ControladorArchivosUtilitario getArchivosUtilitario() {
		return archivosUtilitario;
	}
	
	public ControladorCaracterizacion getCaracterizaciones() {
		return caracterizaciones;
	}

	public ControladorSolicitudCotizante getSolicitudesCotizante() {
		return solicitudesCotizante;
	}

}