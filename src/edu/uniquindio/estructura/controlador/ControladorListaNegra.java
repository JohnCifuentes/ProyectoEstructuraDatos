package edu.uniquindio.estructura.controlador;

import java.io.IOException;
import java.util.ArrayList;

import edu.CargarArchivos;
import edu.uniquindio.estructura.modelo.csv.entidad.ListaNegraRegistroAccesoDato;
import edu.uniquindio.estructura.modelo.entidades.ListaNegra;
import edu.uniquindio.estructura.modelo.entidades.ListaNegraRegistro;
import edu.uniquindio.estructura.modelo.entidades.Persona;
import edu.uniquindio.estructura.modelo.entidades.TipoCaracterizacion;
import edu.uniquindio.estructura.modelo.entidades.TipoEntidad;

public class ControladorListaNegra {
	private CargarArchivos cargarArchivos;
	private ArrayList<ListaNegra> listaNegra;
	
	public ControladorListaNegra(CargarArchivos cargarArchivos) throws IOException {
		this.cargarArchivos = cargarArchivos;
		this.listaNegra = cargarListaNegra();
	}
	
	public ArrayList<ListaNegra> cargarListaNegra() throws IOException{
		ArrayList<ListaNegra> listaNegra = new ArrayList<>();
		for(ListaNegraRegistro l: new ListaNegraRegistroAccesoDato().obtenerTodos()) {
			listaNegra.add(
					new ListaNegra(
							TipoEntidad.getTipoEntidad(l.getTipoEntidad()),
							(new Persona(this.cargarArchivos.getArchivosUtilitario().getTipoDocumento(l.getTipoDocumento()), l.getDocumento(), l.getNombreCompleto())),
							TipoCaracterizacion.getTipoCaracterizacion(l.getTipoCaracterizacion()),
							l.getFechaRegistro()
							));
		}
		return listaNegra;
	}

	public ArrayList<ListaNegra> getListaNegra() {
		return listaNegra;
	}
	
	public void agregarListaNegra(ListaNegra listaNegra) {
		for(ListaNegra l: this.listaNegra) {
			if(l.getPersona().getTipoDocumento().equals(listaNegra.getPersona().getTipoDocumento()) 
					&& l.getPersona().getDocumento().equals(listaNegra.getPersona().getDocumento()) 
					&& l.getTipoCaracterizacion().equals(listaNegra.getTipoCaracterizacion())) {
				return;
			}
		}
		this.listaNegra.add(listaNegra);
	}
	
	public ListaNegra obtenerListaNegra(Persona persona) {
		
		return null;
	}
	
	
}