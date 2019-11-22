/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.modelo;


import com.mycompany.discotiendaaa.pojo.Compras;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author alice
 */
public class ComprasDB {
    
    Connection conn = null;
    Statement stm;
    ResultSet rs;
    int resultUpdate = 0;
    
    public ArrayList<Compras> consultarCanciones() {
        ArrayList<Compras> canciones = new ArrayList();
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT a.nombre, a.duracion, b.nombre AS nombre_disco, b.caratula, c.nombre AS nombre_artista, c.apellido, a.precio\n"
                    + "	FROM cancion a, disco b, artista c WHERE a.id_disco =b.id_disco AND b.id_artista = c.id_artista order by id_cancion asc");
            System.out.println("Consulta de canciones realizada");
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConexionDB.cerrar();
                return null;
            } else {
                do {
                    Compras cancion= new Compras(rs.getString("nombre"),rs.getString("duracion"),rs.getString("nombre_artista")+" "+ rs.getString("apellido"),rs.getString("nombre_disco"),rs.getString("caratula"),rs.getFloat("precio"));
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

    public ArrayList<String> consultarNombreArtista() {
        ArrayList<String> nombresArtistas = new ArrayList();
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT nombre AS nombre_artista, apellido FROM artista");
            System.out.println("Consulta de nombres discos realizada");
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConexionDB.cerrar();
                return null;
            } else {
                do {
                    nombresArtistas.add(rs.getString("nombre_artista")+" "+rs.getString("apellido"));
                } while (rs.next());
                ConexionDB.cerrar();
                return nombresArtistas;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            return null;
        }
    }
}
