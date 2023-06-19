/**
 *<h3>Main</h3> 
 * 
 */

package main;

import Entity.Carrera;
import Entity.Cursa;
import Entity.Estudiante;
import repository.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.persistence.Entity;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class Main {

	public static void main(String[] args) throws ParseException  {
		
		RepoEstudiante re = new RepoEstudiante();
		RepoCarrera rc = new RepoCarrera();
		RepoCursa rcu = new RepoCursa();
		
		//LoadTableEstudiante(re);
		//LoadTableCarrera(rc);
		RunMenu(re, rc, rcu);	
	
	}

	
	        
		
      private static void RunMenu(RepoEstudiante re,RepoCarrera rc, RepoCursa rcu) throws ParseException{
    	  
    	  String date_time = "11/27/2020";
          SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yyyy");
          String respuesta = "";
        
          while(respuesta != "X") {
			System.out.println("Ingrese A para crear un estudiante");
			System.out.println("Ingrese B para matricular un estudiante a una carrera");
			System.out.println("Ingrese C para listar estudiantes ordenados por apellido (orden: desc)");
			System.out.println("Ingrese D para buscar estudiante por numero de libreta");
			System.out.println("Ingrese E para listar estudiantes por genero");
			System.out.println("Ingrese F para listar carreras con estudiantes inscriptos (orden: por cant de inscriptos)");
			System.out.println("Ingrese G para listar los alumnos de una carrera (filtro: ciudad de residencia)");
			System.out.println("Ingrese H para generar reporte de carreras con cantidad de inscriptos y egresados (orden: carreras alfabeticamente y años cronologicamente)");
			System.out.println("Ingrese X para salir del sistema");
			
			Scanner in = new Scanner(System.in);
			
			respuesta = in.nextLine();
			
			switch (respuesta.toUpperCase()) {
			
			case "A":
				Estudiante es01= new Estudiante("Luis","Mas",dateParser.parse(date_time),"M",22333444,"Tres Arroyos");
				re.create(es01);				
				System.out.println("El estudiante Luis Mas, fue creado");
				System.out.println('\n');
				break;

				
			case "B":
				Estudiante es02= new Estudiante("Pedro","Menos",dateParser.parse(date_time),"M",40354875,"Tres Arroyos");
				re.create(es02);
				Carrera ca01=new Carrera ("Enfermeria", 2);
				rc.create(ca01);
				Cursa cu = new Cursa(es02,ca01, dateParser.parse(date_time), null);
				rcu.create(cu);
				System.out.println("El estudiante Pedro Menos, fue matriculado a la carrera de Enfermeria");
				System.out.println('\n');
				break;
			
			case "C":
				System.out.println(re.getEstudiantes());
				System.out.println('\n');
				break;
				
			case "D":
				System.out.println("Ingrese el numero de libreta de estudiante a buscar (del 1 al 100)");
				int num_libreta = in.nextInt();
				System.out.println(re.findById(num_libreta));
				System.out.println('\n');
				break;
			
			case "E":
				System.out.println("Ingrese el genero a listar, opciones: M / F ");
				String genero = in.nextLine();
				if(genero.equals("m") || genero.equals("M") || genero.equals("F") || genero.equals("f")){
					System.out.println(re.getEstudiantesByGenero(genero));
					System.out.println('\n');
				}else {
					System.out.println("La opcion tipeada es incorrecta");
					System.out.println('\n');
				}
				break;
				
			case "F":
				System.out.println(rc.getCarrerasConEstudiantesInscriptos());
				System.out.println('\n');
				break;
				
			case "G":
				System.out.println(re.getEstudiantesPorCiudadDeResidencia("Enfermeria","Tres Arroyos"));
				System.out.println('\n');
				break;
				
			case "H":
				System.out.println(rc.getReporte());
				System.out.println('\n');
				break;
			
			case "X":
				System.exit(0);				
				break;
				
			default:
				System.out.println("La opciones seleccionada no corresponde a ninguna de las habilitadas");;
				System.out.println('\n');
			}
		
         } 
      }		
		
	@SuppressWarnings("deprecation")
	private static void LoadTableEstudiante(RepoEstudiante es) {		
	
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/csv/estudiantes.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//e.create();
		for(CSVRecord row: parser) {
			Estudiante est=new Estudiante (String.valueOf(row.get("nombres")), String.valueOf(row.get("apellido")), new Date(row.get("fecha_Nacimiento")), String.valueOf(row.get("genero")), Integer.valueOf(row.get("dni")), String.valueOf(row.get("ciudad_Residencia"))) ;
			es.create(est) ;
		}
		
	}	
	
	@SuppressWarnings("deprecation")
	private static void LoadTableCarrera(RepoCarrera c) {		
		
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("src/csv/carreras.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//c.create();
		for(CSVRecord row: parser) {
			Carrera r = new Carrera (String.valueOf(row.get("nombre_carrera")),Integer.valueOf(row.get("duracion")));
			c.create(r);
		}		
	}
	
}
