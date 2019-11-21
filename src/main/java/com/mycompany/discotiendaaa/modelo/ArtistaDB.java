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
import java.util.ArrayList;

/**
 *
 * @author angie
 */
public class ArtistaDB {

    Connection conn = null;
    Statement stm;
    ResultSet rs;
    int resultUpdate = 0;

    public void agregarArtista(Artista artista) {
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

    public ArrayList<Artista> consultaArtistas() {
        ArrayList<Artista> artistas = new ArrayList();
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("Select * from artista order by id_artista");
            System.out.println("Consulta de artistas realizada");
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConexionDB.cerrar();
                return null;
            } else {
                do {
                    Artista artista = new Artista();
                    artista.setId_artista(rs.getInt("id_artista"));
                    artista.setNombre(rs.getString("nombre"));
                    artista.setApellido(rs.getString("apellido"));
                    artista.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                    artista.setNacionalidad(rs.getString("nacionalidad"));
                    artistas.add(artista);
                } while (rs.next());
                ConexionDB.cerrar();
                return artistas;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            return null;
        }
    }

    public void modificarArtista(Artista artista) {
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("update artista set nombre='" + artista.getNombre() + "', apellido='" + artista.getApellido() + "',\n"
                    + "fecha_nacimiento='" + artista.getFechaNacimiento() + "', nacionalidad='" + artista.getNacionalidad() + "' \n"
                    + " where id_artista=" + artista.getId_artista() + "");
            if (resultUpdate != 0) {
                ConexionDB.cerrar();
            } else {
                ConexionDB.cerrar();
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            System.out.println(e);
        }
    }

    public void eliminarArtista(int id_artista) {
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            resultUpdate = stm.executeUpdate("delete from artista where id_artista='" + id_artista + "'");
            System.out.println("Artista eliminado con éxito");
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
