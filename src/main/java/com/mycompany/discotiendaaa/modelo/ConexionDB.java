/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author familia manrique
 */
public class ConexionDB {

    static Connection conexion = null;
    private static final String url = "jdbc:postgresql://localhost:5433/discotienda";
    private static final String usuario = "postgres";
    private static final String contraseña = "1234";

    public static Connection abrir() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexion establecida");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error:" + e);
        }
        return conexion;
    }

    public static void cerrar() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println("Error: No se logró cerrar conexión:\n" + e);
        }
    }

}
