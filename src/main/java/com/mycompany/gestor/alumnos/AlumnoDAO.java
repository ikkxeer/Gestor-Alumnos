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
    
    public ArrayList<AlumnoDTO> ListarAlumnos(ArrayList<AlumnoDTO> alumnos) {
        String query = "SELECT id, nombre FROM alumnos";
        try (PreparedStatement pstm = conn.prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
                    
        while(rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            alumnos.add(new AlumnoDTO(id, nombre));
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return alumnos;
    }
    
    public void EliminarAlumno(int id) {
        String query = "DELETE FROM alumnos WHERE id = ?";
        try (PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
