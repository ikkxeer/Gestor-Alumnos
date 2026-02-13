/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestor.alumnos;

/**
 * Classe que representa un objeto alumno de la base de datos
 *
 * @author Iker Aramburu
 */
public class AlumnoDTO {
    // Declaracion de los atributos del alumno
    public int id;
    public String nombre;
    public String primerApellido;
    public String segundoApellido;
    public String fechaNacimiento;
    public String classe;

    /**
     * Constructor de la classe parametrizado
     * 
     * @param id ID del usuario
     * @param nombre Nombre del alumno
     * @param primerApellido Primer apellido del alumno
     * @param segundoApellido Segundo apellido del alumno
     * @param fechaNacimiento Fecha de nacimiento del alumno
     * @param classe Classe del alumno
     */
    public AlumnoDTO(int id, String nombre, String primerApellido, String segundoApellido, String fechaNacimiento, String classe) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.classe = classe;
    }
    
        /**
     * Constructor de la classe sin id parametrizado
     * 
     * @param nombre Nombre del alumno
     * @param primerApellido Primer apellido del alumno
     * @param segundoApellido Segundo apellido del alumno
     * @param fechaNacimiento Fecha de nacimiento del alumno
     * @param classe Classe del alumno
     */
    public AlumnoDTO(String nombre, String primerApellido, String segundoApellido, String fechaNacimiento, String classe) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.classe = classe;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getClasse() {
        return classe;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
    
    /**
     * Override para mostrar el nombre por default
     * 
     * @return Nombre del alumno
     */
    @Override
    public String toString() {
        return nombre;
    }
}
