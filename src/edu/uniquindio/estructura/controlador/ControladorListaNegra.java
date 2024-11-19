package edu.uniquindio.estructura.controlador;

import java.io.IOException;
import java.util.ArrayList;

import edu.CargarArchivos;
import edu.uniquindio.estructura.modelo.csv.EscribirRegistroArchivo;
import edu.uniquindio.estructura.modelo.csv.entidad.ListaNegraRegistroAccesoDato;
import edu.uniquindio.estructura.modelo.entidades.ListaNegra;
import edu.uniquindio.estructura.modelo.entidades.Persona;
import edu.uniquindio.estructura.modelo.entidades.TipoCaracterizacion;
import edu.uniquindio.estructura.modelo.entidades.TipoEntidad;
import edu.uniquindio.estructura.modelo.entidades.registros.ListaNegraRegistro;
import edu.uniquindio.estructura.util.Herramientas;

public class ControladorListaNegra {
	private CargarArchivos cargarArchivos;
	private ArrayList<ListaNegra> listaNegra;
	
	public ControladorListaNegra(CargarArchivos cargarArchivos) throws IOException {
		this.cargarArchivos = cargarArchivos;
		this.listaNegra = cargarListaNegra();
	}
	
	public void actualizarListaNegra() throws IOException {
		this.listaNegra = cargarListaNegra();
	}
	
	public ArrayList<ListaNegra> cargarListaNegra() throws IOException{
		ArrayList<ListaNegra> listaNegra = new ArrayList<>();
		for(ListaNegraRegistro l: new ListaNegraRegistroAccesoDato().obtenerTodos()) {
			listaNegra.add(new ListaNegra(
					TipoEntidad.getTipoEntidad(String.format("%02d", Integer.parseInt(l.getTipoCaracterizacion()))),
					(new Persona(this.cargarArchivos.getArchivosUtilitario().getTipoDocumento(l.getTipoDocumento()), l.getDocumento(), l.getNombreCompleto())),
					TipoCaracterizacion.getTipoCaracterizacion(l.getTipoCaracterizacion()),
					l.getFechaRegistro()
					));
		}
		return listaNegra; 
	}

	public ArrayList<ListaNegra> getListaNegra() {
		return listaNegra;
	}

	public void setListaNegra(ArrayList<ListaNegra> listaNegra) {
		this.listaNegra = listaNegra;
	}
	
	public boolean existeSolicitudCotizanteInhabilitada(Persona persona) {
		boolean existeRegistro = this.listaNegra.stream().anyMatch(registro -> (
					registro.getPersona().getTipoDocumento().equals(persona.getTipoDocumento()) 
					&& registro.getPersona().getDocumento().equals(persona.getDocumento())
					&& registro.getTipoCaracterizacion() == TipoCaracterizacion.INHABILITAR
					&& Herramientas.fechaInhabilitadoSeisMeses(registro.getFechaRegistro())
				));
		
		return existeRegistro;
	}
	
	/**
	 * El metodo tiene como proposito agregar una nueva solicitud de cotizante. Valida si la persona ya existe en la lista negra, evitando solicitud de cotizantes duplicados.
	 * Si el tipo de caracterizacion es INHABILITAR y existe un registro con fecha de hace más de seis meses actualiza la fecha con fecha actual 
	 * @param listaNegra
	 */
	public void agregarListaNegra(ListaNegra listaNegra) {
		if(listaNegra.getTipoCaracterizacion() == TipoCaracterizacion.INHABILITAR) {
			for(ListaNegra l: this.listaNegra) {
				if(l.getPersona().getTipoDocumento().equals(listaNegra.getPersona().getTipoDocumento()) && l.getPersona().getDocumento().equals(listaNegra.getPersona().getDocumento())) {
					/**
					 * Si la persona existe actualmente en la lista negra, se valida si la fecha del registro fue hace más de seis meses
					 */
					if(!Herramientas.fechaInhabilitadoSeisMeses(l.getFechaRegistro())) {
						/**
						 * Si la fecha del registro fue hace más de seis meses, se actualiza con la fecha actual
						 */
						l.setFechaRegistro(Herramientas.generarFechaFormato());
					}
					return;
				}
			}
			/**
			 * Si la persona no existe actualmente en la lista negra, se agrega el nuevo registro.
			 */
			agregarListaNegraCsv(listaNegra);
		}
		
		/**
		 * Si el tipo de caracterizacion es EMBARGADO y la persona no existe en la lista negra, se agrega un nuevo registro.
		 */
		boolean existeRegistro = this.listaNegra.stream().anyMatch(registro -> (registro.getPersona().getTipoDocumento().equals(listaNegra.getPersona().getTipoDocumento()) && registro.getPersona().getDocumento().equals(listaNegra.getPersona().getDocumento())));
		if(!existeRegistro) {
			agregarListaNegraCsv(listaNegra);
		}
	}
	
	/**
	 * Se agrega el cotizante a la lista negra
	 * @param listaNegra
	 */
	private void agregarListaNegraCsv(ListaNegra listaNegra) {
		EscribirRegistroArchivo<ListaNegraRegistro> registroArchivo = new EscribirRegistroArchivo<ListaNegraRegistro>(Herramientas.getDirectorioSolicitud() + "\\listaSolicitudInhabilitados.csv");
		/**
		 * Se agrega el registro al archivo csv
		 */
		registroArchivo.escribirObjeto(
				(new ListaNegraRegistro(listaNegra.getTipoEntidad().getCodigoTipoEntidad(), listaNegra.getPersona().getTipoDocumento().getCodigoTipoDocumento(), listaNegra.getPersona().getDocumento(), listaNegra.getPersona().getNombreCompleto(), listaNegra.getTipoCaracterizacion().getCodigoTipoCaracterizacion(), listaNegra.getFechaRegistro())));
		/**
		 * Se agrega el registro a la lista negra de inhabilitados
		 */
		this.listaNegra.add(listaNegra);
	}

}