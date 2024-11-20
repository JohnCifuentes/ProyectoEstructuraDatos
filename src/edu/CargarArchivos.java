package edu;

import java.io.IOException;

import edu.uniquindio.estructura.controlador.ControladorArchivosUtilitario;
import edu.uniquindio.estructura.controlador.ControladorCaracterizacion;
import edu.uniquindio.estructura.controlador.ControladorCotizante;
import edu.uniquindio.estructura.controlador.ControladorListaNegra;
import edu.uniquindio.estructura.controlador.ControladorSolicitudCotizante;
import edu.uniquindio.estructura.controlador.ControladorSolicitudCotizanteAprobado;
import edu.uniquindio.estructura.controlador.ControladorSolicitudCotizanteRechazado;

public class CargarArchivos {
	private ControladorArchivosUtilitario archivosUtilitario;
	private ControladorCaracterizacion caracterizaciones;
	private ControladorSolicitudCotizante solicitudesCotizante;
	private ControladorListaNegra ListaSolicitudesInhabilitados;
	private ControladorSolicitudCotizanteAprobado listaCotizantesAprobados;
	private ControladorSolicitudCotizanteRechazado listaCotizantesRechazados;
	private ControladorCotizante listaCotizantes;
	
	public CargarArchivos(ControladorArchivosUtilitario archivosUtilitario) throws IOException {
		this.archivosUtilitario = archivosUtilitario;
		this.caracterizaciones = new ControladorCaracterizacion(this);
		this.solicitudesCotizante = new ControladorSolicitudCotizante(this);
		this.ListaSolicitudesInhabilitados = new ControladorListaNegra(this);
		this.listaCotizantesAprobados = new ControladorSolicitudCotizanteAprobado(this);
		this.listaCotizantesRechazados = new ControladorSolicitudCotizanteRechazado(this);
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

	public ControladorListaNegra getListaSolicitudesInhabilitados() {
		return ListaSolicitudesInhabilitados;
	}

	public ControladorSolicitudCotizanteAprobado getListaCotizantesAprobados() {
		return listaCotizantesAprobados;
	}

	public ControladorSolicitudCotizanteRechazado getListaCotizantesRechazados() {
		return listaCotizantesRechazados;
	}

	public ControladorCotizante getListaCotizantes() {
		return listaCotizantes;
	}

}