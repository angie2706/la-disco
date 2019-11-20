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
    String nombre, caratula, nombre_artista;

    
    public void agregarDisco(String nombre, String caratula, String nombre_artista) {
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("INSERT INTO disco(nombre, caratula, id_artista)VALUES ('" + nombre + "', '" + caratula + "', "
                    + "(SELECT id_artista FROM artista WHERE '"+nombre_artista+"' = nombre || apellido)" + ")");
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
                    nombre_artista = rs.getString("nombre_artista")+rs.getString("apellido_artista");

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
                    nombre_artista = rs.getString("nombre_artista")+rs.getString("apellido_artista");
                    nombresDiscos.add(nombre_artista);
                } while (rs.next());
                ConexionDB.cerrar();
                return nombresDiscos;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            return null;
        }
    }
    
    public void modificarDisco(int id_disco, String nombre, String caratula, String nombre_artista) {
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("update disco set nombre='"+nombre+"', caratula='"+caratula+"', \n"
                    + "	id_artista=(SELECT id_artista FROM artista WHERE '"+nombre_artista+"' = nombre || apellido)" + "where id_disco="+id_disco+"");

            if (resultUpdate != 0) {
                ConexionDB.cerrar();
            } else {
                ConexionDB.cerrar();
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
        }
    }

    public void eliminarDisco(int id_disco) {
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("delete from disco where id_disco='"+id_disco+"'");
            System.out.println("Disco eliminado con éxito");
            if (resultUpdate != 0) {
                ConexionDB.cerrar();
            } else {
                ConexionDB.cerrar();
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
        }
    }
    
    public ArrayList<Disco> consultaDisco_Art(int id_artista) {
        ArrayList<Disco> listadoDiscos = new ArrayList();
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT a.id_disco, a.nombre, a.caratula, b.nombre AS nombre_artista, b.apellido AS apellido_artista\n" +
"                    FROM disco a, artista b WHERE a.id_artista b.="+id_artista+" order by id_disco asc");
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConexionDB.cerrar();
                return null;
            } else {
                do {
                    id_disco = rs.getInt("id_disco");
                    nombre = rs.getString("nombre");
                    caratula = rs.getString("caratula");
                    nombre_artista = rs.getString("nombre_artista")+rs.getString("apellido_artista");

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
}
