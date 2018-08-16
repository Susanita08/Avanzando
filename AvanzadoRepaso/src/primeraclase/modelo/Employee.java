package primeraclase.modelo;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Votador {
	int legajo;
	String ubicacion;
	Employee reportTo;
	String name;
	List<Employee> reportees;
	private Boolean voto;
	
	public Employee() {
		reportees = new ArrayList();
	}
	
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Employee getReportTo() {
		return reportTo;
	}
	public void setReportTo(Employee reportTo) {
		this.reportTo = reportTo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Employee> getReportees() {
		return reportees;
	}

	public void setReportees(List<Employee> reportees) {
		this.reportees = reportees;
	}

	/*public static Employee createEmployee(String nombre, String ubicacion, int legajo){
		Employee emp = new Employee();
		emp.setLegajo(legajo);
		emp.setName(nombre);
		emp.setUbicacion(ubicacion);
		return emp;
	}*/
	
	/*@Override
	public boolean puedeVotar() {
		return (reportees != null && reportees.size()>2);
	}*/

	@Override
	public void elegirVoto() {
		Boolean valorRetorno = null;
		if(reportees !=null && reportees.size()>=2) {
			valorRetorno = false;
			if(ubicacion.equals(SENADO) && legajo % 2 ==0) {
				valorRetorno = Boolean.TRUE;
			}
			if(ubicacion.equals(DIPUTADO) && legajo % 3 ==0) {
				valorRetorno = Boolean.TRUE;
			}
		}
		voto = valorRetorno;
		
	}

	@Override
	public Boolean getDecisionVoto() {
		System.out.println(name+" voto ");
		return voto;
	}

	@Override
	public boolean puedeVotar() {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public String quienVoto(Employee empleado) {
		String s=empleado.getName()+ " voto: ";	
		empleado.elegirVoto();
		return null;
	}
}
