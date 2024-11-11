package edu;

import java.io.IOException;

import edu.uniquindio.estructura.modelo.entidades.SolicitudCotizante;

public class Main {

	public static void main(String[] args) throws IOException {
		
		CargarArchivos cargarArchivos = new CargarArchivos();
		for(SolicitudCotizante s: cargarArchivos.getSolicitudesCotizante().getSolicitudCotizantes()) {
			System.out.println(s.getPersona().getTipoDocumento() + " - " + s.getPersona().getDocumento() + " - " + s.getPersona().getNombreCompleto());
		}
		
	}

}