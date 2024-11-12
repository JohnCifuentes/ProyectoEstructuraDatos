package edu.uniquindio.estructura.modelo.entidades;

public class SolicitudCotizanteRechazado extends SolicitudCotizante{

	public SolicitudCotizanteRechazado(Persona persona, FondosOrigen fondoOrigen, int prePensionado,
			InstitucionesPublicas institucionPublica, int condecoracion, int hijosInpec, int familiaPolicia,
			int observacionDisciplinaria, int numeroSemanas) {
		super(persona, fondoOrigen, prePensionado, institucionPublica, condecoracion, hijosInpec, familiaPolicia,
				observacionDisciplinaria, numeroSemanas);
	}

}