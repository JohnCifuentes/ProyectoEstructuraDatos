package edu.uniquindio.estructura.controlador;

import java.io.IOException;
import java.util.ArrayList;

import edu.CargarArchivos;
import edu.uniquindio.estructura.modelo.entidades.Caracterizacion;
import edu.uniquindio.estructura.modelo.entidades.ListaNegra;
import edu.uniquindio.estructura.modelo.entidades.SolicitudCotizante;
import edu.uniquindio.estructura.modelo.entidades.TipoCaracterizacion;
import edu.uniquindio.estructura.util.Herramientas;

public class ControladorValidarSolicitudCotizante {
	private CargarArchivos cargarArchivos;
	private ArrayList<Caracterizacion> caracterizaciones;
	private ArrayList<SolicitudCotizante> solicitudCotizantes;
	
	public ControladorValidarSolicitudCotizante(CargarArchivos cargarArchivos){
		this.cargarArchivos = cargarArchivos;
		this.caracterizaciones = new ArrayList<>();
		this.solicitudCotizantes = new ArrayList<>();
	}
	
	/**
	 * Actualiza listas: Caracterizaciones - SolicitudCotizantes
	 * Valida solicitud cotizantes: Inhabilitados - Embargados - Reglas de negocio
	 * Se ejecuta cada 60min
	 * @throws IOException
	 */
	public void validarSolicitudCotizantes() throws IOException {
		this.cargarArchivos.getSolicitudesCotizante().actualizarSolicitudCotizaciones();
		this.solicitudCotizantes = this.cargarArchivos.getSolicitudesCotizante().getSolicitudCotizantes();
		
		this.cargarArchivos.getCaracterizaciones().actualizarCaracterizaciones();
		this.caracterizaciones = this.cargarArchivos.getCaracterizaciones().getCaracterizaciones();
		
		for(SolicitudCotizante solicitudCotizante: this.solicitudCotizantes) {
			Caracterizacion caracterizacion = this.cargarArchivos.getCaracterizaciones().obtenerCaracterizacion(solicitudCotizante.getPersona());
			if(caracterizacion.getTipoCaracterizacion() == TipoCaracterizacion.INHABILITAR) {
				agregarListaNegra(caracterizacion);
			} else {
				if(validarSolicitudCotizanteReglasInternas(solicitudCotizante, caracterizacion)) {
					agregarSolicitudCotizanteAprobado();
				} else {
					agregarSolicitudCotizanteRechado();
				}
			}
		}
		
	}
	
	private boolean validarSolicitudCotizanteReglasInternas(SolicitudCotizante solicitudCotizante, Caracterizacion caracterizacion) {
		
		return true;
	}
	
	private void agregarListaNegra(Caracterizacion caracterizacion) {
		this.cargarArchivos.getListaNegra().agregarListaNegra(new ListaNegra(caracterizacion.getTipoEntidad(), caracterizacion.getPersona(), caracterizacion.getTipoCaracterizacion(), Herramientas.generarFechaFormato()));
	}
	
	private void agregarSolicitudCotizanteAprobado() {
		
	}
	
	private void agregarSolicitudCotizanteRechado() {
		
	}

}