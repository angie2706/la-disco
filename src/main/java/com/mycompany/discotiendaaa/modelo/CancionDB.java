/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.modelo;

import com.mycompany.discotiendaaa.pojo.Cancion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author familia manrique
 */
public class CancionDB {

    Connection conn = null;
    Statement stm;
    ResultSet rs;
    int resultUpdate = 0;

    Cancion cancion;
    int id_cancion, id_disco;
    double precio;
    String nombre, nombreDisco, duracion;

    public void agregarCancion(String nombre, String duracion, int id_disco, float precio) {
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("INSERT INTO cancion(nombre, duracion, id_disco, precio)VALUES ('" + nombre + "', '" + duracion + "', " + id_disco + ", " + precio + ")");
            System.out.println("Canción agregada.");
            if (resultUpdate != 0) {
                ConexionDB.cerrar();
            } else {
                ConexionDB.cerrar();
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
        }
    }
}
