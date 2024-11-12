package edu.uniquindio.estructura.modelo.entidades;

public class ListaNegra extends Caracterizacion{
	private String fechaRegistro;

	public ListaNegra(TipoEntidad tipoEntidad, Persona persona, TipoCaracterizacion tipoCaracterizacion) {
		super(tipoEntidad, persona, tipoCaracterizacion);
	}

	public ListaNegra(TipoEntidad tipoEntidad, Persona persona, TipoCaracterizacion tipoCaracterizacion,
			String fechaRegistro) {
		super(tipoEntidad, persona, tipoCaracterizacion);
		this.fechaRegistro = fechaRegistro;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}