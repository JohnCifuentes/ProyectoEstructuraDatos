package edu.uniquindio.estructura.modelo.entidades;

public class SolicitudCotizante {
	private String nombreArchivoOrigen;
	private Persona persona;
	private FondosOrigen fondoOrigen;
	private int prePensionado;
	private InstitucionesPublicas institucionPublica;
	private int condecoracion;
	private int hijosInpec;
	private int familiaPolicia;
	private int observacionDisciplinaria;
	private int numeroSemanas;

	public SolicitudCotizante(String nombreArchivoOrigen, Persona persona, FondosOrigen fondoOrigen, int prePensionado,
			InstitucionesPublicas institucionPublica, int condecoracion, int hijosInpec, int familiaPolicia,
			int observacionDisciplinaria, int numeroSemanas) {
		super();
		this.nombreArchivoOrigen = nombreArchivoOrigen;
		this.persona = persona;
		this.fondoOrigen = fondoOrigen;
		this.prePensionado = prePensionado;
		this.institucionPublica = institucionPublica;
		this.condecoracion = condecoracion;
		this.hijosInpec = hijosInpec;
		this.familiaPolicia = familiaPolicia;
		this.observacionDisciplinaria = observacionDisciplinaria;
		this.numeroSemanas = numeroSemanas;
	}

	public String getNombreArchivoOrigen() {
		return nombreArchivoOrigen;
	}

	public void setNombreArchivoOrigen(String nombreArchivoOrigen) {
		this.nombreArchivoOrigen = nombreArchivoOrigen;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public FondosOrigen getFondoOrigen() {
		return fondoOrigen;
	}

	public void setFondoOrigen(FondosOrigen fondoOrigen) {
		this.fondoOrigen = fondoOrigen;
	}

	public int getPrePensionado() {
		return prePensionado;
	}

	public void setPrePensionado(int prePensionado) {
		this.prePensionado = prePensionado;
	}

	public InstitucionesPublicas getInstitucionPublica() {
		return institucionPublica;
	}

	public void setInstitucionPublica(InstitucionesPublicas institucionPublica) {
		this.institucionPublica = institucionPublica;
	}

	public int getCondecoracion() {
		return condecoracion;
	}

	public void setCondecoracion(int condecoracion) {
		this.condecoracion = condecoracion;
	}

	public int getHijosInpec() {
		return hijosInpec;
	}

	public void setHijosInpec(int hijosInpec) {
		this.hijosInpec = hijosInpec;
	}

	public int getFamiliaPolicia() {
		return familiaPolicia;
	}

	public void setFamiliaPolicia(int familiaPolicia) {
		this.familiaPolicia = familiaPolicia;
	}

	public int getObservacionDisciplinaria() {
		return observacionDisciplinaria;
	}

	public void setObservacionDisciplinaria(int observacionDisciplinaria) {
		this.observacionDisciplinaria = observacionDisciplinaria;
	}

	public int getNumeroSemanas() {
		return numeroSemanas;
	}

	public void setNumeroSemanas(int numeroSemanas) {
		this.numeroSemanas = numeroSemanas;
	}
	
	@Override
	public String toString() {
		return this.nombreArchivoOrigen
			+ " - " + this.persona.datosBasicosFechaNacimiento()
			+ " - " + this.fondoOrigen.getNombreFondoOrigen()
			+ " - " + this.institucionPublica.getNombreInstitucionPublica();
	}
}