package edu.uniquindio.estructura.controlador;

import java.io.IOException;
import java.util.ArrayList;

import edu.CargarArchivos;
import edu.uniquindio.estructura.modelo.csv.EscribirRegistroArchivo;
import edu.uniquindio.estructura.modelo.csv.entidad.SolicitudCotizanteRechazadoAccesoDato;
import edu.uniquindio.estructura.modelo.entidades.SolicitudCotizanteRechazado;
import edu.uniquindio.estructura.modelo.entidades.registros.SolicitudCotizanteRechazadoRegistro;
import edu.uniquindio.estructura.util.Herramientas;

public class ControladorSolicitudCotizanteRechazado {
	private CargarArchivos cargarArchivos;
	private ArrayList<SolicitudCotizanteRechazado> solicitudCotizantesRechazados;
	
	public ControladorSolicitudCotizanteRechazado(CargarArchivos cargarArchivos) {
		this.cargarArchivos = cargarArchivos;
		this.solicitudCotizantesRechazados = new ArrayList<>();
	}
	
	public void actualizarSolicitudCotizantesRechazados() throws IOException {
		this.solicitudCotizantesRechazados = cargarSolicitudCotizantesRechazados();
	}
	
	public ArrayList<SolicitudCotizanteRechazado> cargarSolicitudCotizantesRechazados() throws IOException{
		ArrayList<SolicitudCotizanteRechazado> solicitudCotizantesRechazados = new ArrayList<>();
		for(SolicitudCotizanteRechazadoRegistro s: new SolicitudCotizanteRechazadoAccesoDato().obtenerTodos()) {
			solicitudCotizantesRechazados.add(new SolicitudCotizanteRechazado(
					this.cargarArchivos.getArchivosUtilitario().getTipoDocumento(s.getTipoDocumento()),
					s.getNumeroDocumento(),
					s.getNombreCompleto(),
					s.getFechaNacimiento(),
					this.cargarArchivos.getArchivosUtilitario().getDepartamento(s.getDepartamentoNacimiento()),
					this.cargarArchivos.getArchivosUtilitario().getMunicipio(s.getCiudadNacimiento()),
					this.cargarArchivos.getArchivosUtilitario().getDepartamento(s.getDepartamentoResidencia()),
					this.cargarArchivos.getArchivosUtilitario().getMunicipio(s.getCiudadResidencia()),
					s.getDeclaraRenta().equals("1")?true:false
				));
		}
		return solicitudCotizantesRechazados;
	}

	public ArrayList<SolicitudCotizanteRechazado> getSolicitudCotizantesRechazados() {
		return solicitudCotizantesRechazados;
	}

	public void setSolicitudCotizantesRechazados(ArrayList<SolicitudCotizanteRechazado> solicitudCotizantesRechazados) {
		this.solicitudCotizantesRechazados = solicitudCotizantesRechazados;
	}
	
	public void agregarSolicitudCotizante(SolicitudCotizanteRechazado solicitudCotizanteRechazado) {
		for(SolicitudCotizanteRechazado c: this.solicitudCotizantesRechazados) {
			if(c.getTipoDocumento().equals(solicitudCotizanteRechazado.getTipoDocumento()) && c.getDocumento().equals(solicitudCotizanteRechazado.getDocumento())) {
				return;
			}
		}
		agregarSolicitudCotizanteCsv(solicitudCotizanteRechazado);
	}
	
	private void agregarSolicitudCotizanteCsv(SolicitudCotizanteRechazado solicitudCotizanteRechazado) {
		EscribirRegistroArchivo<SolicitudCotizanteRechazadoRegistro> registroArchivo = new EscribirRegistroArchivo<>(Herramientas.getDirectorioSolicitud() + "\\listaSolicitudCotizantesRechazados.csv");
		registroArchivo.escribirObjeto(new SolicitudCotizanteRechazadoRegistro(
				solicitudCotizanteRechazado.getTipoDocumento().getCodigoTipoDocumento(),
				solicitudCotizanteRechazado.getDocumento(),
				solicitudCotizanteRechazado.getNombreCompleto(),
				solicitudCotizanteRechazado.getFechaNacimiento(),
				solicitudCotizanteRechazado.getDepartamentoNacimiento().getCodigoDepartamento(),
				solicitudCotizanteRechazado.getCiudadNacimiento().getCodigoMunicipio(),
				solicitudCotizanteRechazado.getDepartamentoResidencia().getCodigoDepartamento(),
				solicitudCotizanteRechazado.getCiudadResidencia().getCodigoMunicipio(),	
				solicitudCotizanteRechazado.esDeclarante()?"1":"0"
			));
		this.solicitudCotizantesRechazados.add(solicitudCotizanteRechazado);
	}

}