/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestor.alumnos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe que servirá para conectar a la base de datos
 *
 * @author Iker Aramburu
 */
public class DB {
    // Datos necesarios para la connexion
    public String driver = "com.mysql.cj.jdbc.Driver";
    public String database = "sys";
    public String hostname = "localhost";
    public String port = "3306";
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?allowPublicKeyRetrieval=true&useSSL=false";
    public String username = "iker";
    public String password = "12345aA!";
    
    /**
     * Funcion para conectar a la base de datos con los atributos de la classe
     * 
     * @return Conexion final
     */
    public Connection conectarMysql() {
        Connection conn = null;
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return conn;
    }    
}
