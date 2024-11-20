package edu.uniquindio.estructura.controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import edu.CargarArchivos;
import edu.uniquindio.estructura.modelo.csv.EscribirRegistroArchivo;
import edu.uniquindio.estructura.modelo.csv.entidad.CotizanteRegistroAccesoDato;
import edu.uniquindio.estructura.modelo.entidades.Cotizante;
import edu.uniquindio.estructura.modelo.entidades.SolicitudCotizanteAprobado;
import edu.uniquindio.estructura.modelo.entidades.registros.CotizanteRegistro;
import edu.uniquindio.estructura.util.Herramientas;

public class ControladorCotizante {
	private CargarArchivos cargarArchivos;
	private List<Cotizante> cotizantes;
	
	public ControladorCotizante(CargarArchivos cargarArchivos) {
		this.cargarArchivos = cargarArchivos;
		this.cotizantes = new ArrayList<>();
	}

	public void actualizarCotizantes() throws IOException {
		this.cotizantes = cargarCotizantes();
	}
	
	public List<Cotizante> cargarCotizantes() throws IOException{
		ArrayList<Cotizante> cotizantes = new ArrayList<>();
		for(CotizanteRegistro c: new CotizanteRegistroAccesoDato().obtenerTodos()) {
			cotizantes.add(new Cotizante(
					this.cargarArchivos.getArchivosUtilitario().getTipoDocumento(c.getTipoDocumento()),
					c.getNumeroDocumento(),
					c.getNombreCompleto(),
					c.getFechaNacimiento(),
					this.cargarArchivos.getArchivosUtilitario().getDepartamento(c.getDepartamentoNacimiento()),
					this.cargarArchivos.getArchivosUtilitario().getMunicipio(c.getCiudadNacimiento()),
					this.cargarArchivos.getArchivosUtilitario().getDepartamento(c.getDepartamentoResidencia()),
					this.cargarArchivos.getArchivosUtilitario().getMunicipio(c.getCiudadResidencia())
					));
		}
		return cotizantes;
	}
	
	public List<Cotizante> getCotizantes() {
		return cotizantes;
	}

	public void setCotizantes(ArrayList<Cotizante> cotizantes) {
		this.cotizantes = cotizantes;
	}
	
	public void trasladarCotizantes() throws IOException {
	    this.cargarArchivos.getListaCotizantesAprobados().actualizarSolicitudCotizantesAprobados();
	    /**
	     * Se actualiza la lista de los cotizantes aprobados y de cotizantes
	     */
	    ArrayList<SolicitudCotizanteAprobado> cotizantesAprobados = this.cargarArchivos.getListaCotizantesAprobados().getSolicitudCotizantesAprobados();
	    actualizarCotizantes();

	    PriorityQueue<SolicitudCotizanteAprobado> colaPrioridad = new PriorityQueue<>((c1, c2) -> {
	    	/**
	    	 * Criterios para ordenar la lista de los cotizantes aprobados
	    	 * Prioridad Total: menores de 35
	    	 * Prioridad Secundaria: no obligadas a declarar renta
	    	 */
	        boolean c1Menor35 = !esMayorDe35(c1); 
	        boolean c2Menor35 = !esMayorDe35(c2);
	        if (c1Menor35 != c2Menor35) {
	            return Boolean.compare(c2Menor35, c1Menor35); 
	        }

	        if (c1.esDeclarante() != c2.esDeclarante()) {
	            return Boolean.compare(c1.esDeclarante(), c2.esDeclarante()); 
	        }

	        return Integer.compare(c1.getEdad(), c2.getEdad());
	    });

	    colaPrioridad.addAll(cotizantesAprobados);
	   
	    int contador = 0;
	    while (contador < Herramientas.getTrasladosAprobadosXDia() && !colaPrioridad.isEmpty()) {
	        SolicitudCotizanteAprobado cotizanteAprobado = colaPrioridad.poll(); 
	        agregarCotizante(new Cotizante(
	        		cotizanteAprobado.getTipoDocumento(),
	        		cotizanteAprobado.getDocumento(),
	        		cotizanteAprobado.getNombreCompleto(),
	        		cotizanteAprobado.getFechaNacimiento(),
	        		cotizanteAprobado.getDepartamentoNacimiento(),
	        		cotizanteAprobado.getCiudadNacimiento(),
	        		cotizanteAprobado.getDepartamentoResidencia(),
	        		cotizanteAprobado.getCiudadResidencia()
	        		));
	        contador++;
	    }
	    
	    this.cargarArchivos.getListaCotizantesAprobados().actualizarArchivoListaSolicitudCotizantesAprobados(new ArrayList<>(colaPrioridad));
	}
	
	private boolean esMayorDe35(Cotizante cotizante) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
	    LocalDate fechaNacimiento = LocalDate.parse(cotizante.getFechaNacimiento(), formatter);
	    
	    LocalDate hoy = LocalDate.now();
	    Period edad = Period.between(fechaNacimiento, hoy);

	    return edad.getYears() <= 35? true:false;
	}
    
	public void agregarCotizante(Cotizante cotizante) {
		for(Cotizante c: this.cotizantes) {
			if(c.getTipoDocumento().equals(cotizante.getTipoDocumento()) && c.getDocumento().equals(cotizante.getDocumento())) {
				return;
			}
		}
		agregarCotizanteCsv(cotizante);
	}
	
	private void agregarCotizanteCsv(Cotizante cotizante) {
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
