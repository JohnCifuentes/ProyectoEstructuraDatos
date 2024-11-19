package edu.uniquindio.estructura.modelo.entidades;

public class SolicitudCotizanteAprobado extends Cotizante{

	public SolicitudCotizanteAprobado(TipoDocumento tipoDocumento, String documento, String nombreCompleto,
			String fechaNacimiento, Departamento departamentoNacimiento, Municipio ciudadNacimiento,
			Departamento departamentoResidencia, Municipio ciudadResidencia) {
		super(tipoDocumento, documento, nombreCompleto, fechaNacimiento, departamentoNacimiento, ciudadNacimiento,
				departamentoResidencia, ciudadResidencia);
	}
	
	
}