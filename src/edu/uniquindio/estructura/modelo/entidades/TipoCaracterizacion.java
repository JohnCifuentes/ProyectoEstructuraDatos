package edu.uniquindio.estructura.modelo.entidades;

public enum TipoCaracterizacion {
	INHABILITAR("Inhabilitar", 1), EMBARGAR("Embargar", 2);
	
	private String nombreTipoCaracterizacion;
	private int codigoTipoCaracterizacion;
	
	private TipoCaracterizacion(String nombreTipoCaracterizacion, int codigoTipoCaracterizacion) {
		this.nombreTipoCaracterizacion = nombreTipoCaracterizacion;
		this.codigoTipoCaracterizacion = codigoTipoCaracterizacion;
	}

	public String getNombreTipoCaracterizacion() {
		return nombreTipoCaracterizacion;
	}

	public int getCodigoTipoCaracterizacion() {
		return codigoTipoCaracterizacion;
	}

}