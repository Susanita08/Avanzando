package primeraclase.servicio;

import java.util.ArrayList;
import java.util.List;

import primeraclase.modelo.Employee;

public class GestorEmp {
	
	public static List<Employee> generateRandomEmployees(int cantidad, String nombreBase, int legajoBase, Employee report){
		List<Employee> employees = new ArrayList<Employee>();
		Employee emp = null;
		for (int i = 1; i <= cantidad; i++) {
			emp = new Employee();
			emp.setLegajo(legajoBase + i);
			emp.setName(nombreBase+emp.getLegajo());
			emp.setUbicacion(report.getUbicacion());
			emp.setReportTo(report);
			employees.add(emp);
		}
		
		return employees;
	}
	
	public static void  establecerJerarquia(Employee empleado, Employee manager) {
		empleado.setReportTo(manager);
		manager.getReportees().add(empleado);
	}
}
