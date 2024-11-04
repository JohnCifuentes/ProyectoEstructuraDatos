package edu.uniquindio.estructura.modelo.entidades;

public class TipoDocumento {
	private String codigoTipoDocumento;
	private String nombreTipoDocumento;
	
	public TipoDocumento() {
		this.codigoTipoDocumento = null;
		this.nombreTipoDocumento = null;
	}
	
	public TipoDocumento(String codigoTipoDocumento, String nombreTipoDocumento) {
		this.codigoTipoDocumento = codigoTipoDocumento;
		this.nombreTipoDocumento = nombreTipoDocumento;
	}

	public String getCodigoTipoDocumento() {
		return codigoTipoDocumento;
	}

	public void setCodigoTipoDocumento(String codigoTipoDocumento) {
		this.codigoTipoDocumento = codigoTipoDocumento;
	}
	
	public String getNombreTipoDocumento() {
		return nombreTipoDocumento;
	}

	public void setNombreTipoDocumento(String nombreTipoDocumento) {
		this.nombreTipoDocumento = nombreTipoDocumento;
	}

}