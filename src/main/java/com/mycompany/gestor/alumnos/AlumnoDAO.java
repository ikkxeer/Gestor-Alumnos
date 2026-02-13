/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestor.alumnos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Classe que servirá para realizar las consultas a la base de datos
 * 
 * @author Iker Aramburu
 */
public class AlumnoDAO {
    // Declaracion y inicializacion de los atributos de la classe
    private DB baseDeDatos = new DB();
    private Connection conn = baseDeDatos.conectarMysql();

    /**
     * Funcion para insertar alumnos
     * 
     * @param alumno Objeto Alumno
     */
    public void InsertarAlumno(AlumnoDTO alumno) {
        String query = "INSERT INTO alumnos (Nombre, PrimerApellido, SegundoApellido, FechaNacimiento, Classe) VALUES(?, ?, ?, ?, ?)";        
        try (PreparedStatement pstm = conn.prepareStatement(query)) {
            // Asignamos los atributos del alumno a la consulta
            pstm.setString(1, alumno.nombre);
            pstm.setString(2, alumno.primerApellido);
            pstm.setString(3, alumno.segundoApellido);
            pstm.setString(4, alumno.fechaNacimiento);
            pstm.setString(5, alumno.classe);
            
            pstm.executeUpdate();
            System.out.println("Alumno " + alumno.nombre + " insertado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Funcion para listar alumnos
     * 
     * @param alumnos Lista de alumnos
     * @return Lista de alumnos
     */
    public ArrayList<AlumnoDTO> ListarAlumnos(ArrayList<AlumnoDTO> alumnos) {
        // Consulta a realizar
        String query = "SELECT id, nombre FROM alumnos";
        
        try (PreparedStatement pstm = conn.prepareStatement(query)) {
            // Preparamos un result set para guardar la ejecuccion
            ResultSet rs = pstm.executeQuery();
  
            // Por cada elemento de la result query
            while(rs.next()) {
                // Guardamos el id
                int id = rs.getInt("id");
                // Guardamos el nombre
                String nombre = rs.getString("nombre");
                // Agregamos a la lista el alumno
                alumnos.add(new AlumnoDTO(id, nombre));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Devolvemos la lista de alumnos completa
        return alumnos;
    }
    
    /**
     * Funcion para eliminar un alumno con su id
     * 
     * @param id Id del alumno a eliminar
     */
    public void EliminarAlumno(int id) {
        // Consulta a realizar
        String query = "DELETE FROM alumnos WHERE id = ?";
        try (PreparedStatement pstm = conn.prepareStatement(query)) {
            // Ponemos el id segun el que nos han pasado
            pstm.setInt(1, id);
            // Ejecutamos el delete
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
