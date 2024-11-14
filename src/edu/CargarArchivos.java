package edu;

import java.io.IOException;

import edu.uniquindio.estructura.controlador.ControladorArchivosUtilitario;
import edu.uniquindio.estructura.controlador.ControladorCaracterizacion;
import edu.uniquindio.estructura.controlador.ControladorListaNegra;
import edu.uniquindio.estructura.controlador.ControladorSolicitudCotizante;

public class CargarArchivos {
	private ControladorArchivosUtilitario archivosUtilitario;
	private ControladorCaracterizacion caracterizaciones;
	private ControladorSolicitudCotizante solicitudesCotizante;
	private ControladorListaNegra listaNegra;
	
	public CargarArchivos() throws IOException {
		this.archivosUtilitario = new ControladorArchivosUtilitario();
		this.caracterizaciones = new ControladorCaracterizacion(this);
		this.solicitudesCotizante = new ControladorSolicitudCotizante(this);
		this.listaNegra = new ControladorListaNegra(this);
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

	public ControladorListaNegra getListaNegra() {
		return listaNegra;
	}
}