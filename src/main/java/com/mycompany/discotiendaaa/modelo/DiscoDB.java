/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.modelo;

import com.mycompany.discotiendaaa.pojo.Cancion;
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
    String nombre, caratula;

    public ArrayList<Disco> consultaDiscos() {
        ArrayList<Disco> listadoDiscos = new ArrayList();
        try {
            conn = ConexionDB.abrir();
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT id_disco, nombre, caratula, id_artista\n"
                    + "	FROM public.disco;");
            if (!rs.next()) {
                System.out.println(" No se encontraron registros");
                ConexionDB.cerrar();
                return null;
            } else {
                do {
                    id_disco = rs.getInt("id_disco");
                    nombre = rs.getString("nombre");
                    caratula = rs.getString("caratula");
                    id_artista = rs.getInt("id_artista");

                    disco = new Disco(id_disco, nombre, caratula, id_artista);
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
