package edu.uniquindio.estructura.modelo.entidades;

public class Cotizante extends Persona{
	
	public Cotizante(TipoDocumento tipoDocumento, String documento, String nombreCompleto, String fechaNacimiento,
			Departamento departamentoNacimiento, Municipio ciudadNacimiento, Departamento departamentoResidencia,
			Municipio ciudadResidencia) {
		super(tipoDocumento, documento, nombreCompleto, fechaNacimiento, departamentoNacimiento, ciudadNacimiento, departamentoResidencia, ciudadResidencia);
	}

}