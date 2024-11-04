package edu.uniquindio.estructura.modelo.entidades;

public class Persona {
	private TipoDocumento tipoDocumento;
	private String documento;
	private String nombreCompleto;
	
	public Persona(TipoDocumento tipoDocumento, String documento, String nombreCompleto) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.nombreCompleto = nombreCompleto;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

}