package edu.uniquindio.estructura.controlador;

import java.io.IOException;
import java.util.List;

import edu.uniquindio.estructura.modelo.csv.entidad.DepartamentoAccesoDato;
import edu.uniquindio.estructura.modelo.csv.entidad.MunicipioAccesoDato;
import edu.uniquindio.estructura.modelo.csv.entidad.TipoDocumentoAccesoDato;
import edu.uniquindio.estructura.modelo.entidades.Departamento;
import edu.uniquindio.estructura.modelo.entidades.Municipio;
import edu.uniquindio.estructura.modelo.entidades.TipoDocumento;

public class ControladorArchivosUtilitario {
	private List<TipoDocumento> tiposDocumento;
	private List<Departamento> departamentos;
	private List<Municipio> municipios;
	
	public ControladorArchivosUtilitario() throws IOException {
		this.tiposDocumento = cargarTipoDocumento(); 
		this.departamentos = cargarDepartamento();
		this.municipios = cargarMunicipio();
	}
	
	/**
	 * Gestor - Tipo Documento
	 **/
	public List<TipoDocumento> cargarTipoDocumento() throws IOException {
		TipoDocumentoAccesoDato tipoDocumentoAccesoDato = new TipoDocumentoAccesoDato();
		return tipoDocumentoAccesoDato.obtenerTodos();		
	}
	
	public boolean existeTipoDocumento(String codigoTipoDocumento) {
		for(TipoDocumento t: this.tiposDocumento) {
			if(t.getCodigoTipoDocumento().equals(codigoTipoDocumento)) {
				return true;
			}
		}
		return false;
	}
	
	public TipoDocumento getTipoDocumento(String codigoTipoDocumento) {
		for(TipoDocumento t: this.tiposDocumento) {
			if(t.getCodigoTipoDocumento().equals(codigoTipoDocumento)) {
				return t;
			}
		}
		return null;		
	}
	
	/**
	 * Gestor Departamentos
	 **/
	public List<Departamento> cargarDepartamento() throws IOException{
		DepartamentoAccesoDato departamentoAccesoDato = new DepartamentoAccesoDato();
		return departamentoAccesoDato.obtenerTodos();
	}
	
	public boolean existeDepartamento(String codigoDepartamento) {
		for(Departamento d: this.departamentos) {
			if(d.getCodigoDepartamento().equals(codigoDepartamento)) {
				return true;
			}
		}
		return false;
	}
	
	public Departamento getDepartamento(String codigoDepartamento) {
		for(Departamento d: this.departamentos) {
			if(d.getCodigoDepartamento().equals(codigoDepartamento)) {
				return d;
			}
		}
		return null;
	}
	
	/**
	 * Gestor Municipios
	 **/
	public List<Municipio> cargarMunicipio() throws IOException{
		MunicipioAccesoDato municipioAccesoDato = new MunicipioAccesoDato();
		return municipioAccesoDato.obtenerTodos();
	}
	
	public boolean existeMunicipio(String codigoMunicipio) {
		for(Municipio m: this.municipios) {
			if(m.getCodigoMunicipio().equals(codigoMunicipio)) {
				return true;
			}
		}
		return false;
	}
	
	public Municipio getMunicipio(String codigoMunicipio) {
		for(Municipio m: this.municipios) {
			if(m.getCodigoMunicipio().equals(codigoMunicipio)) {
				return m;
			}
		}
		return null;
	}
	
	/**
	 **/
	public List<TipoDocumento> getTiposDocumento() {
		return tiposDocumento;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

}