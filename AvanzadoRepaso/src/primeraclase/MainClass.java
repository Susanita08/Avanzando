package primeraclase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import primeraclase.modelo.Employee;
import primeraclase.modelo.Manager;
import primeraclase.modelo.Votador;
import primeraclase.servicio.GestorEmp;
import primeraclase.servicio.Utilidades;

public class MainClass {

	public static void main(String[] args) {
		/*Manager presidente = createManager("Presidente", "presidencia", 100);
		
		Manager jefeSenado = createManager("Jefe Senado", "senado", 200);
		jefeSenado.setReportTo(presidente);
		jefeSenado.setReportees(generateRandomEmployees(generarRandomInt(10,100), "senado", 200, jefeSenado));
		
		Manager jefeDiputado = createManager("Jefe Diputado", "congreso", 300);
		jefeDiputado.setReportTo(presidente);
		jefeDiputado.setReportees(generateRandomEmployees(generarRandomInt(10, 100), "diputado", 100, jefeDiputado));
		
		impresion(jefeSenado, jefeDiputado);*/
		
		Employee presidente = GestorEmp.createEmployee("Presidente", "presidencia", 100);
		Employee jefeSenado = GestorEmp.createEmployee("Jefe Senado", Votador.SENADO, 200);
		GestorEmp.establecerJerarquia(jefeSenado, presidente);
		GestorEmp.generarEmpleados(jefeSenado);
		//jefeSenado.setReportTo(presidente);
		//jefeSenado.setReportees(GestorEmp.generateRandomEmployees(Utilidades.generarRandomInt(10,100), "senado", 200, jefeSenado));
		Employee jefeDiputado = GestorEmp.createEmployee("Jefe Diputado", Votador.DIPUTADO, 300);
		GestorEmp.establecerJerarquia(jefeDiputado, presidente);
		GestorEmp.generarEmpleados(jefeDiputado);
		
		Employee Asesor = GestorEmp.createEmployee("Asesor", Votador.DIPUTADO, 400);
		Employee AsesorS = GestorEmp.createEmployee("Asesor", Votador.SENADO, 400);
		///GestorEmp.generarEmpleados(Asesor);
		
		
		for(Votador empleado: presidente.getReportees()) {
			//empleado.puedeVotar();
			empleado.elegirVoto();
			System.out.println(empleado.getDecisionVoto());
		}
		
		for(Employee empleado: jefeDiputado.getReportees()) {
			//empleado.puedeVotar();
			GestorEmp.generarAsesores(empleado);
			GestorEmp.establecerJerarquia(Asesor, empleado);
			empleado.elegirVoto();
			System.out.println(empleado.getDecisionVoto());
		}
		
		for(Employee empleado: jefeSenado.getReportees()) {
			//empleado.puedeVotar();
			GestorEmp.generarAsesores(empleado);
			GestorEmp.establecerJerarquia(AsesorS, empleado);
			empleado.elegirVoto();
			System.out.println(empleado.getDecisionVoto());
		}
		
		for(Votador empleado: Asesor.getReportees()) {
			//empleado.puedeVotar();
			empleado.elegirVoto();
			System.out.println(empleado.getDecisionVoto());
		}
		
		for(Votador empleado: AsesorS.getReportees()) {
			//empleado.puedeVotar();
			empleado.elegirVoto();
			System.out.println(empleado.getDecisionVoto());
		}
		//jefeDiputado.setReportTo(presidente);
		//jefeDiputado.setReportees(GestorEmp.generateRandomEmployees(Utilidades.generarRandomInt(10, 100), "diputado", 100, jefeDiputado));
	}
	
	/*private static int generarRandomInt(int minimo, int maximo) {
		Random generadorRandom = new Random();
		int cantidad = generadorRandom.nextInt(maximo);
		while(cantidad < minimo) {
			cantidad = generadorRandom.nextInt(maximo);
		}
		
		return cantidad;
	}*/

	/*private static Manager createManager(String nombre, String ubicacion, int legajo){
		Manager man = new Manager();
		man.setLegajo(legajo);
		man.setName(nombre);
		man.setUbicacion(ubicacion);
		
		return man;
	}*/
	
	/*private static List<Employee> generateRandomEmployees(int cantidad, String nombreBase, int legajoBase, Manager report){
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
	}*/
	
	/*public static void impresion(Manager s, Manager d) {
		//Presidente --> Jefe Senado (#cantidad empleados) ----> Empleade (mostrar solo los primeros 10) --> Jefe Diputados (#cantidad empleados) ----> Empleade (mostrar solo los primeros 10)
		System.out.print(s.reportTo.getName()+" --> "+s.getName()+"(#cantidad empleados= "+s.reportees.size()+")"+" ----> Empleados (");
		for(int i=0;i<s.reportees.size();i++) {
			if(i<10)System.out.print(" "+s.reportees.get(i).getName()+" ");
		}
		System.out.print(") --> Jefe Diputados (#cantidad empleados= "+d.reportees.size()+")"+" ----> Empleados (");
		for(int i=0;i<s.reportees.size();i++) {
			if(i<10)System.out.print(" "+d.reportees.get(i).getName()+" ");
		}
		System.out.print(")");
	}*/
	
}
