package edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uniquindio.estructura.controlador.ControladorCaracterizacion;
import edu.uniquindio.estructura.modelo.csv.entidad.TipoDocumentoAccesoDato;
import edu.uniquindio.estructura.modelo.entidades.Caracterizacion;
import edu.uniquindio.estructura.modelo.entidades.TipoDocumento;

public class main {

	public static void main(String[] args) throws IOException{
		ControladorCaracterizacion controladorCaracterizacion = new ControladorCaracterizacion();
		ArrayList<Caracterizacion> caracterizaciones = controladorCaracterizacion.caracterizaciones();
	}
	
	public static void cargarTipoDocumento() throws IOException {
		TipoDocumentoAccesoDato tipoDocumentoAccesoDato = new TipoDocumentoAccesoDato();
		List<TipoDocumento> tiposDocumentos = tipoDocumentoAccesoDato.obtenerTodos();
		for(TipoDocumento x: tiposDocumentos) {
			System.out.println(x.getCodigoTipoDocumento() + " - " + x.getNombreTipoDocumento());
		}		
	}

}
