/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.modelo;

import com.mycompany.discotiendaaa.pojo.Disco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author familia manrique
 */
public class DiscoDB {

    Connection conn = null;
    Statement stm;
    ResultSet rs;
    int resultUpdate = 0;

    Disco disco;
    int id_disco, id_artista;
    String nombre, caratula, nombre_artista, apellido_artista, nombre_completo;

    
    public void agregarDisco(String nombre, String caratula, String nombre_artista, String apellido_artista) {
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("INSERT INTO disco(nombre, caratula, id_artista)VALUES ('" + nombre + "', '" + caratula + "', "
                    + "(SELECT id_disco FROM disco WHERE '" + nombre_artista + "' = nombre and '"+ apellido_artista + "' = nombre)" + ")");
            System.out.println("Disco agregado.");
            if (resultUpdate != 0) {
                ConexionDB.cerrar();
            } else {
                ConexionDB.cerrar();
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
        }
    }
    
    public ArrayList<Disco> consultaDiscos() {
        ArrayList<Disco> listadoDiscos = new ArrayList();
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT a.id_disco, a.nombre, a.caratula, b.nombre AS nombre_artista, b.apellido AS apellido_artista\n" +
"                    FROM disco a, artista b WHERE a.id_artista = b.id_artista order by id_disco asc");
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConexionDB.cerrar();
                return null;
            } else {
                do {
                    id_disco = rs.getInt("id_disco");
                    nombre = rs.getString("nombre");
                    caratula = rs.getString("caratula");
                    nombre_artista= rs.getString("nombre_artista");
                    apellido_artista=rs.getString("apellido_artista");
                    nombre_completo = rs.getString("nombre_artista")+rs.getString("apellido_artista");

                    disco = new Disco(id_disco, nombre, caratula, nombre_artista);
                    listadoDiscos.add(disco);
                } while (rs.next());
                ConexionDB.cerrar();
                return listadoDiscos;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            return null;
        }
    }
    
    public ArrayList<String> consultarNombreArtistas() {
        ArrayList<String> nombresDiscos = new ArrayList();
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT nombre AS nombre_artista, apellido AS apellido_artista FROM artista");
            System.out.println("Consulta de nombres artistas realizada");
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConexionDB.cerrar();
                return null;
            } else {
                do {
                    nombre_completo = rs.getString("nombre_artista")+rs.getString("apellido_artista");
                    nombresDiscos.add(nombre_completo);
                } while (rs.next());
                ConexionDB.cerrar();
                return nombresDiscos;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            return null;
        }
    }
}
