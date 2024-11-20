package edu.uniquindio.estructura.controlador;

import java.io.IOException;
import java.util.ArrayList;

import edu.CargarArchivos;
import edu.uniquindio.estructura.modelo.csv.EscribirRegistroArchivo;
import edu.uniquindio.estructura.modelo.csv.entidad.SolicitudCotizanteAprobadoAccesoDato;
import edu.uniquindio.estructura.modelo.entidades.SolicitudCotizanteAprobado;
import edu.uniquindio.estructura.modelo.entidades.registros.SolicitudCotizanteAprobadoRegistro;
import edu.uniquindio.estructura.util.Herramientas;

public class ControladorSolicitudCotizanteAprobado {
	private CargarArchivos cargarArchivos;
	private ArrayList<SolicitudCotizanteAprobado> solicitudCotizantesAprobados;

	public ControladorSolicitudCotizanteAprobado(CargarArchivos cargarArchivos) {
		this.cargarArchivos = cargarArchivos;
		this.solicitudCotizantesAprobados = new ArrayList<>();
	}
	
	public void actualizarSolicitudCotizantesAprobados() throws IOException {
		this.solicitudCotizantesAprobados = cargarSolicitudCotizantesAprobados();
	}
	
	public ArrayList<SolicitudCotizanteAprobado> cargarSolicitudCotizantesAprobados() throws IOException{
		ArrayList<SolicitudCotizanteAprobado> solicitudCotizantesAprobados = new ArrayList<>();
		for(SolicitudCotizanteAprobadoRegistro s: new SolicitudCotizanteAprobadoAccesoDato().obtenerTodos()) {
			solicitudCotizantesAprobados.add(new SolicitudCotizanteAprobado(
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
		return solicitudCotizantesAprobados;
	}
	
	public ArrayList<SolicitudCotizanteAprobado> getSolicitudCotizantesAprobados() {
		return solicitudCotizantesAprobados;
	}

	public void setSolicitudCotizantesAprobados(ArrayList<SolicitudCotizanteAprobado> solicitudCotizantesAprobados) {
		this.solicitudCotizantesAprobados = solicitudCotizantesAprobados;
	}

	public void actualizarArchivoListaSolicitudCotizantesAprobados(ArrayList<SolicitudCotizanteAprobado> listaSolicitudesAprobadasRestante) {
		EscribirRegistroArchivo<SolicitudCotizanteAprobadoRegistro> registroArchivo = new EscribirRegistroArchivo<>(Herramientas.getDirectorioSolicitud() + "\\listaSolicitudCotizantesAprobados.csv");
		registroArchivo.actualizarListaCotizantes();
		listaSolicitudesAprobadasRestante.forEach(l -> {
			agregarSolicitudCotizanteCsv(l);
		});
	}
	
	public void agregarSolicitudCotizante(SolicitudCotizanteAprobado solicitudCotizanteAprobado) {
		for(SolicitudCotizanteAprobado c: this.solicitudCotizantesAprobados) {
			if(c.getTipoDocumento().equals(solicitudCotizanteAprobado.getTipoDocumento()) && c.getDocumento().equals(solicitudCotizanteAprobado.getDocumento())) {
				return;
			}
		}
		agregarSolicitudCotizanteCsv(solicitudCotizanteAprobado);
	}
	
	private void agregarSolicitudCotizanteCsv(SolicitudCotizanteAprobado solicitudCotizanteAprobado) {
		EscribirRegistroArchivo<SolicitudCotizanteAprobadoRegistro> registroArchivo = new EscribirRegistroArchivo<>(Herramientas.getDirectorioSolicitud() + "\\listaSolicitudCotizantesAprobados.csv");
		registroArchivo.escribirObjeto(new SolicitudCotizanteAprobadoRegistro(
				solicitudCotizanteAprobado.getTipoDocumento().getCodigoTipoDocumento(),
				solicitudCotizanteAprobado.getDocumento(),
				solicitudCotizanteAprobado.getNombreCompleto(),
				solicitudCotizanteAprobado.getFechaNacimiento(),
				solicitudCotizanteAprobado.getDepartamentoNacimiento().getCodigoDepartamento(),
				solicitudCotizanteAprobado.getCiudadNacimiento().getCodigoMunicipio(),
				solicitudCotizanteAprobado.getDepartamentoResidencia().getCodigoDepartamento(),
				solicitudCotizanteAprobado.getCiudadResidencia().getCodigoMunicipio(),
				solicitudCotizanteAprobado.esDeclarante()?"1":"0"
			));
		this.solicitudCotizantesAprobados.add(solicitudCotizanteAprobado);
	}
		
}