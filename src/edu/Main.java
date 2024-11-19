package edu;

import java.io.IOException;

import edu.uniquindio.estructura.controlador.ControladorArchivosUtilitario;
import edu.uniquindio.estructura.controlador.ControladorCotizante;
import edu.uniquindio.estructura.controlador.ControladorValidarSolicitudCotizante;
import edu.uniquindio.estructura.modelo.entidades.Caracterizacion;
import edu.uniquindio.estructura.modelo.entidades.SolicitudCotizante;
import edu.uniquindio.estructura.util.AdministrarArchivosDirectorio;
import edu.uniquindio.estructura.util.GenerarArchivosEntrantes;
import edu.uniquindio.estructura.util.Herramientas;

public class Main {
	
	public static void main(String[] args) throws IOException {

	}
	
	/**
	 * Prueba - Generar 10.000 archivos de prueba en la carpeta SolicitudesEntrantes
	 */
	public static void generarArchivosEntrates() {
		GenerarArchivosEntrantes generarArchivosEntrantes = new GenerarArchivosEntrantes();
		generarArchivosEntrantes.generarArchivosEntrantes();
	}
	
	/**
	 * Prueba - Cargar Caracterizaciones
	 * @throws IOException
	 */
	public static void testCaracterizaciones() throws IOException {
		CargarArchivos cargarArchivos = new CargarArchivos(new ControladorArchivosUtilitario());
		cargarArchivos.getCaracterizaciones().actualizarCaracterizaciones();
		for(Caracterizacion c: cargarArchivos.getCaracterizaciones().getCaracterizaciones()) {
			System.out.println(c.toString());
		}
	}

	/**
	 * Prueba - Cargar Solicitudes Entrantes
	 * @throws IOException
	 */
	public static void testSolicitudesEntrantes() throws IOException {
		CargarArchivos cargarArchivos = new CargarArchivos(new ControladorArchivosUtilitario());
		cargarArchivos.getSolicitudesCotizante().actualizarSolicitudCotizaciones();
		for(SolicitudCotizante s: cargarArchivos.getSolicitudesCotizante().getSolicitudCotizantes()) {
			System.out.println(s.toString());
		}
	}
	
	/**
	 * Metodo que se llamara cada 60min
	 * CargaLista: Caracterizaciones - ListaNegra - SolicitudCotizantes
	 * Aplica: ReglasEntidades - ReglasNegocio
	 * @throws IOException 
	 */
	public void validarSolicitudCotizante() throws IOException {
		ControladorArchivosUtilitario archivoUtilitario = new ControladorArchivosUtilitario();
		CargarArchivos cargarArchivos = new CargarArchivos(archivoUtilitario);
		ControladorValidarSolicitudCotizante validarSolicitudCotizante = new ControladorValidarSolicitudCotizante(cargarArchivos);
		validarSolicitudCotizante.validarSolicitudCotizantes();
	}
	
	/**
	 * Metodo que se llamara cada 24horas
	 * CargaLista: SolicitudCotizanteAprobado
	 * @throws IOException 
	 */
	public void traspasarSolicitudCotizantesAprobados() throws IOException {
		ControladorArchivosUtilitario archivoUtilitario = new ControladorArchivosUtilitario();
		CargarArchivos cargarArchivos = new CargarArchivos(archivoUtilitario);
		ControladorCotizante controladorCotizante = new ControladorCotizante(cargarArchivos.getListaCotizantesAprobados().getSolicitudCotizantesAprobados());
		controladorCotizante.trasladarCotizantes();
	}
	
	/**
	 * Metodo que se llamara cada 24horas
	 * Comprimi todos los archivos existentes en la carpeta SolicitudesEnProcesamiento
	 * El archivo .zip se llamará SolicitudesProcesadas_yyyy_mm_dd.zip
	 */
	public static void comprimirArchivos() {
		AdministrarArchivosDirectorio administrarArchivosDirectorio = new AdministrarArchivosDirectorio();
        String nombreArchivo = "SolicitudesProcesadas_" + Herramientas.obtenerFechaActual() + ".zip";
        administrarArchivosDirectorio.comprimirDirectorio(Herramientas.getDirectorioSolicitudProceso(), Herramientas.getDirectorioSolicitudProcesadas() + "\\" + nombreArchivo);
        administrarArchivosDirectorio.limpiarCarpeta(Herramientas.getDirectorioSolicitudProceso());
	}

}