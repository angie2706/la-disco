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
import java.util.ArrayList;

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
    float precio;
    String nombre, nombre_disco, duracion;

    public void agregarCancion(String nombre, String duracion, String nombre_disco, float precio) {
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("INSERT INTO cancion(nombre, duracion, id_disco, precio)VALUES ('" + nombre + "', '" + duracion + "', "
                    + "(SELECT id_disco FROM disco WHERE '" + nombre_disco + "' = nombre)" + ", " + precio + ")");
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

    public ArrayList<Cancion> consultaCanciones() {
        ArrayList<Cancion> canciones = new ArrayList();
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT a.id_cancion, a.nombre, a.duracion, b.nombre AS nombre_disco, a.precio\n"
                    + "	FROM cancion a, disco b WHERE a.id_disco = b.id_disco order by id_cancion asc");
            System.out.println("Consulta de canciones realizada");
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConexionDB.cerrar();
                return null;
            } else {
                do {
                    id_cancion = rs.getInt("id_cancion");
                    nombre = rs.getString("nombre");
                    duracion = rs.getString("duracion");
                    precio = rs.getFloat("precio");
                    nombre_disco = rs.getString("nombre_disco");

                    cancion = new Cancion(id_cancion, nombre, duracion, nombre_disco, precio);
                    canciones.add(cancion);
                } while (rs.next());
                ConexionDB.cerrar();
                return canciones;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            return null;
        }
    }

    public ArrayList<String> consultarNombreDiscos() {
        ArrayList<String> nombresDiscos = new ArrayList();
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT nombre AS nombre_disco FROM disco");
            System.out.println("Consulta de nombres discos realizada");
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConexionDB.cerrar();
                return null;
            } else {
                do {
                    nombre_disco = rs.getString("nombre_disco");
                    nombresDiscos.add(nombre_disco);
                } while (rs.next());
                ConexionDB.cerrar();
                return nombresDiscos;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            return null;
        }
    }

    public void modificarCancion(int id_cancion, String nombre, String duracion, String nombre_disco, float precio) {
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("update cancion set nombre='" + nombre + "', duracion='" + duracion + "', \n"
                    + "	id_disco=(SELECT id_disco FROM disco WHERE '" + nombre_disco + "' = nombre), precio='" + precio + "'\n"
                    + "where id_cancion=" + id_cancion + "");

            if (resultUpdate != 0) {
                ConexionDB.cerrar();
            } else {
                ConexionDB.cerrar();
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
        }
    }

    public void eliminarCancion(int id_cancion) {
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("delete from cancion where id_cancion='" + id_cancion + "'");
            System.out.println("Canción eliminada con éxito");
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
