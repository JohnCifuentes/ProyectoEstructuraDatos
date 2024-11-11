package edu.uniquindio.estructura.controlador;

import java.io.IOException;
import java.util.ArrayList;

import edu.CargarArchivos;
import edu.uniquindio.estructura.modelo.csv.entidad.SolicitudCotizanteRegistroAccesoDato;
import edu.uniquindio.estructura.modelo.entidades.FondosOrigen;
import edu.uniquindio.estructura.modelo.entidades.InstitucionesPublicas;
import edu.uniquindio.estructura.modelo.entidades.Persona;
import edu.uniquindio.estructura.modelo.entidades.SolicitudCotizante;
import edu.uniquindio.estructura.modelo.entidades.SolicitudCotizanteRegistro;
import edu.uniquindio.estructura.util.AdministrarArchivosDirectorio;
import edu.uniquindio.estructura.util.Herramientas;

public class ControladorSolicitudCotizante {
	private static final String DIRECTORIO = "C:\\Users\\johnc\\eclipse-workspace\\ProyectoEstructuraDatos\\recursos\\SolicitudesEntrantes";
	
	private CargarArchivos cargarArchivos;
	private ArrayList<SolicitudCotizante> solicitudCotizantes;
	
	public ControladorSolicitudCotizante(CargarArchivos cargarArchivos) throws IOException {
		this.cargarArchivos = cargarArchivos; 
		this.solicitudCotizantes = cargarSolicitudCotizantes();
	}
	
	public ArrayList<SolicitudCotizante> cargarSolicitudCotizantes() throws IOException{
		ArrayList<SolicitudCotizante> solicitudCotizantes = new ArrayList<>();
		
		for(String a: new AdministrarArchivosDirectorio().obtenerNombresObjetosEnDirectorio(DIRECTORIO)) {
			for(SolicitudCotizanteRegistro s: new SolicitudCotizanteRegistroAccesoDato(DIRECTORIO + "\\" + a).obtenerTodos()) {
				if(validarEstructuraRegistroArchivo(s)) {
					solicitudCotizantes.add(
							new SolicitudCotizante(
									new Persona(
											this.cargarArchivos.getArchivosUtilitario().getTipoDocumento(s.getTipoDocumento()), 
											s.getNumeroDocumento(),
											s.getNombreCompleto(),
											s.getFechaNacimiento(),
											this.cargarArchivos.getArchivosUtilitario().getDepartamento(s.getDepartamentoNacimiento()),
											this.cargarArchivos.getArchivosUtilitario().getMunicipio(s.getCiudadNacimiento()),
											this.cargarArchivos.getArchivosUtilitario().getDepartamento(s.getDepartamentoNacimiento()),
											this.cargarArchivos.getArchivosUtilitario().getMunicipio(s.getCiudadResidencia())),
									FondosOrigen.getFondoOrigen(s.getFondoOrigen()),
									Integer.parseInt(s.getPrePensionado()),
									InstitucionesPublicas.getInstitucionPublica(s.getInstitucionPublica()),
									Integer.parseInt(s.getCondecoracion()),
									Integer.parseInt(s.getHijosInpec()),
									Integer.parseInt(s.getFamiliaPolicia()),
									Integer.parseInt(s.getObservacionDisciplinaria()),
									Integer.parseInt(s.getNumeroSemanas())
								)
						);
				}
			}
		};
		
		return solicitudCotizantes;
	}
	
	public boolean validarEstructuraRegistroArchivo(SolicitudCotizanteRegistro solicitudCotizanteRegistro) {
		if(!this.cargarArchivos.getArchivosUtilitario().existeTipoDocumento(solicitudCotizanteRegistro.getTipoDocumento())) {
			return false;
		}
				
		if(!Herramientas.validarFormatoFecha(solicitudCotizanteRegistro.getFechaNacimiento())) {
			return false;
		}
		
		if(!this.cargarArchivos.getArchivosUtilitario().existeDepartamento(solicitudCotizanteRegistro.getDepartamentoNacimiento())) {
			return false;
		}
		
		if(!this.cargarArchivos.getArchivosUtilitario().existeMunicipio(solicitudCotizanteRegistro.getCiudadNacimiento())) {
			return false;
		}
		
		if(!this.cargarArchivos.getArchivosUtilitario().existeDepartamento(solicitudCotizanteRegistro.getDepartamentoResidencia())) {
			return false;
		}
		
		if(!this.cargarArchivos.getArchivosUtilitario().existeMunicipio(solicitudCotizanteRegistro.getCiudadResidencia())) {
			return false;
		}
		
		if(!FondosOrigen.existe(solicitudCotizanteRegistro.getFondoOrigen())) {
			System.out.println("departamento");
			return false;
		}
		
		if(!Herramientas.esNumero(solicitudCotizanteRegistro.getPrePensionado())) {
			return false;
		} else if(Integer.parseInt(solicitudCotizanteRegistro.getPrePensionado()) > 1){
			return false;
		}
		
		if(!InstitucionesPublicas.existe(solicitudCotizanteRegistro.getInstitucionPublica())) {
			return false;
		}
		
		if(!Herramientas.esNumero(solicitudCotizanteRegistro.getCondecoracion())) {
			return false;
		} else if(Integer.parseInt(solicitudCotizanteRegistro.getCondecoracion()) > 1){
			return false;
		}
		
		if(!Herramientas.esNumero(solicitudCotizanteRegistro.getHijosInpec())) {
			return false;
		} else if(Integer.parseInt(solicitudCotizanteRegistro.getHijosInpec()) > 1){
			return false;
		}
		
		if(!Herramientas.esNumero(solicitudCotizanteRegistro.getFamiliaPolicia())) {
			return false;
		} else if(Integer.parseInt(solicitudCotizanteRegistro.getFamiliaPolicia()) > 1){
			return false;
		}
		
		if(!Herramientas.esNumero(solicitudCotizanteRegistro.getObservacionDisciplinaria())) {
			return false;
		} else if(Integer.parseInt(solicitudCotizanteRegistro.getObservacionDisciplinaria()) > 1){
			return false;
		}
		
		if(!Herramientas.esNumero(solicitudCotizanteRegistro.getNumeroSemanas())) {
			return false;
		}
		
		return true;
	}

	public ArrayList<SolicitudCotizante> getSolicitudCotizantes() {
		return solicitudCotizantes;
	}

}