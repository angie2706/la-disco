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
            rs = stm.executeQuery("SELECT a.nombre, a.duracion, b.nombre AS nombre_disco, b.caratula, c.nombre AS nombre_artista, a.precio\n"
                    + "	FROM cancion a, disco b, artista c WHERE a.id_disco =b.id_disco AND b.id_artista = c.id_artista order by id_cancion asc");
            System.out.println("Consulta de canciones realizada");
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConexionDB.cerrar();
                return null;
            } else {
                do {
                    Compras cancion= new Compras(rs.getString("nombre"),rs.getString("duracion"),rs.getString("nombre_artista"),rs.getString("nombre_disco"),rs.getString("caratula"),rs.getFloat("precio"));
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

    /*public ArrayList<Cancion> consultarCan_Art(int id_artista) {
        ArrayList<Cancion> canciones = new ArrayList();
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT c1.id_cancion, c1.nombre, c1.duracion, d1.nombre\n"
                    + "FROM cancion c1 JOIN disco d1 ON c1.id_disco = d1.id_disco\n"
                    + "WHERE d1.id_artista="+id_artista+" order by id_cancion;");
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
    }*/
}
