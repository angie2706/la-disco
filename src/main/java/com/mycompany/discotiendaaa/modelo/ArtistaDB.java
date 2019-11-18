/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.modelo;

import com.mycompany.discotiendaaa.pojo.Artista;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author angie
 */
public class ArtistaDB {
    Connection conn = null;
    Statement stm;
    ResultSet rs;
    int resultUpdate = 0;

    
    public void agregarCancion(Artista artista) {
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            java.sql.Date sDate = new java.sql.Date(artista.getFechaNacimiento().getTime());
            resultUpdate = stm.executeUpdate("INSERT INTO artista(nombre, apellido, fecha_nacimiento, nacionalidad) VALUES ('"
                    + artista.getNombre() + "', '" + artista.getApellido() + "', '" + sDate + "', '" + artista.getNacionalidad() + "')");
            if (resultUpdate != 0) {
                ConexionDB.cerrar();
            } else {
                ConexionDB.cerrar();
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error en la base de datos.");
        }
    }
}
