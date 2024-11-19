package edu.uniquindio.estructura.controlador;

import java.util.ArrayList;

import edu.uniquindio.estructura.modelo.csv.EscribirRegistroArchivo;
import edu.uniquindio.estructura.modelo.entidades.Cotizante;
import edu.uniquindio.estructura.modelo.entidades.SolicitudCotizanteAprobado;
import edu.uniquindio.estructura.modelo.entidades.registros.CotizanteRegistro;
import edu.uniquindio.estructura.util.Herramientas;

public class ControladorCotizante {
	private ArrayList<SolicitudCotizanteAprobado> cotizantesAprobados;
	private ArrayList<Cotizante> cotizantes;
	
	public ControladorCotizante(ArrayList<SolicitudCotizanteAprobado> cotizantesAprobados) {
		this.cotizantes = new ArrayList<>();
		this.cotizantesAprobados = cotizantesAprobados;
	}

	public ArrayList<Cotizante> getCotizantes() {
		return cotizantes;
	}

	public void setCotizantes(ArrayList<Cotizante> cotizantes) {
		this.cotizantes = cotizantes;
	}
	
	public void trasladarCotizantes() {
		this.cotizantesAprobados.forEach(solicitudCotizanteAprobado -> {
			
		});
	}
	
	public void agregarCotizante(Cotizante cotizante) {
		for(Cotizante c: this.cotizantes) {
			if(c.getTipoDocumento().equals(cotizante.getTipoDocumento()) && c.getDocumento().equals(cotizante.getDocumento())) {
				return;
			}
		}
		agregarCotizanteCsv(cotizante);
	}
	
	public void agregarCotizanteCsv(Cotizante cotizante) {
		EscribirRegistroArchivo<CotizanteRegistro> registroArchivo = new EscribirRegistroArchivo<>(Herramientas.getDirectorioSolicitud() + "\\listaCotizantes.csv");
		registroArchivo.escribirObjeto(new CotizanteRegistro(
				cotizante.getTipoDocumento().getCodigoTipoDocumento(),
				cotizante.getDocumento(),
				cotizante.getNombreCompleto(),
				cotizante.getFechaNacimiento(),
				cotizante.getDepartamentoNacimiento().getCodigoDepartamento(),
				cotizante.getCiudadNacimiento().getCodigoMunicipio(),
				cotizante.getDepartamentoResidencia().getCodigoDepartamento(),
				cotizante.getCiudadResidencia().getCodigoMunicipio()
				));
		this.cotizantes.add(cotizante);
	}
}
