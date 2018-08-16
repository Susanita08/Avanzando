package primeraclase.modelo;

public interface Votador {
	public static final String SENADO = "senado";
	public static final String DIPUTADO = "diputado";
	public boolean puedeVotar();
	public void elegirVoto();
	public Boolean getDecisionVoto();
	public String quienVoto(Employee empleado);
}
