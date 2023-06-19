# Trabajo Integrador n° 3

## About
**Bataman** 
Manage students through an api. Is a system developed by a group of UNICEN (Universidad Nacional del Centro) students for the "Arquitecturas Web" class.
[Universidad Nacional del Centro](https://exa.unicen.edu.ar/)

## Requeriments

- JAVA v. SE 11. is a development environment for building applications using the Java programming language. [Docs Java](https://www.oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html)
- MAVEN as dependency manager. [Docs Maven](https://maven.apache.org/)
- SPRING BOOT makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run". [Docs Spring](https://spring.io/projects/spring-boot)
- H2 is free SQL database written in Java. [Docs H2](https://www.h2database.com/html/main.html)


## Build 
When running the project, port 8080 of localhost is exposed with the following endpoints:
1. (POST) http://localhost:8080/students

    {
    "dni": 348,
    "bornDate": "2001-09-11",
    "gender": "M",
    "name": "Gabriel",
    "surname": "Ballone",
    "city": "Tres Arroyos"
}

2. (POST) http://localhost:8080/register
    
    {
    "collegeNotebook": 3,
    "id_career": 1,
    "inscriptionDate": "2022-10-12"
}
3. (GET) http://localhost:8080/students  

4. (GET) http://localhost:8080/students?order={atributo_de_estudiante}

5. (GET) http://localhost:8080/students/{numero_libreta_universitaria}

6. (GET) http://localhost:8080/students/genero/{M_o_F}

7. (GET) http://localhost:8080/careers

8. (GET) http://localhost:8080/students/careerCity/{carrera}/{ciudad}

9. (GET) http://localhost:8080/careerReport

Extras: 

10. (PUT) http://localhost:8080/students/{numero_libreta_universitaria}
    
    {
    "dni": 348,
    "bornDate": "2021-08-11",
    "gender": "M",
    "name": "Gabriel",
    "surname": "Ballone",
    "city": "Tres Arroyos"
}

11. (GET) http://localhost:8080/courses

**or import file in postman or thunder client (vscode)** [endpoints.json](https://github.com/franbayugar/integradorArquitecturas/blob/main/TP3/extra/endpoints.json)

## Deploy
To consult the database visit: http://localhost:8080/h2-console/

![Login Database](https://github.com/franbayugar/integradorArquitecturas/blob/main/TP3/extra/1.png)

![View database](https://github.com/franbayugar/integradorArquitecturas/blob/main/TP3/extra/2.png)

## Group 3
- Bayugar, Franco
- Crespi, Federico
- Molfese, Juan
- Pisarra, Guido
- Tisera, Cristian
