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
        // Consulta a realizar con todos los campos
        String query = "SELECT id, nombre, PrimerApellido, SegundoApellido, FechaNacimiento, Classe FROM alumnos";

        try (PreparedStatement pstm = conn.prepareStatement(query)) {
            // Preparamos un result set para guardar la ejecución
            ResultSet rs = pstm.executeQuery();

            // Por cada elemento del result query
            while(rs.next()) {
                // Guardamos todos los campos
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String primerApellido = rs.getString("PrimerApellido");
                String segundoApellido = rs.getString("SegundoApellido");
                String fechaNacimiento = rs.getString("FechaNacimiento");
                String classe = rs.getString("Classe");

                // Agregamos a la lista el alumno con todos sus datos
                alumnos.add(new AlumnoDTO(id, nombre, primerApellido, segundoApellido, fechaNacimiento, classe));
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
    
    public void ActualizarAlumno(String nuevoNombre, String nuevoPrimerApellido, String nuevoSegundoApellido, String nuevaFechaNacimiento, String nuevaClasse, int id) {
            String query = "UPDATE alumnos SET Nombre = ?, PrimerApellido = ?, SegundoApellido = ?, FechaNacimiento = ?, Classe = ? WHERE id = ?";
            try (PreparedStatement pstm = conn.prepareStatement(query)) {
                // Ponemos los parametros
                pstm.setString(1, nuevoNombre);
                pstm.setString(2, nuevoPrimerApellido);
                pstm.setString(3, nuevoSegundoApellido);
                pstm.setString(4, nuevaFechaNacimiento);
                pstm.setString(5, nuevaClasse);
                pstm.setInt(6, id);
                
                // Ejecutamos el update
                pstm.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
