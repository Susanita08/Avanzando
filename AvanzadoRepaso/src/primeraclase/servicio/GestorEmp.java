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
	
	public static Employee createEmployee(String nombre, String ubicacion, int legajo){
		Employee emp = new Employee();
		emp.setLegajo(legajo);
		emp.setName(nombre);
		emp.setUbicacion(ubicacion);
		return emp;
	}
	
	public static void generarEmpleados(Employee empleado) {
		empleado.setReportees(GestorEmp.generateRandomEmployees(Utilidades.generarRandomInt(10,100), empleado.getUbicacion(), empleado.getLegajo(), empleado));
	}
	
	public static void generarAsesores(Employee empleado) {
		empleado.setReportees(GestorEmp.generateRandomEmployees(Utilidades.generarRandomInt(0,10), empleado.getUbicacion(), empleado.getLegajo(), empleado));
	}
}
