/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.controlador;

import com.mycompany.discotiendaaa.modelo.ArtistaDB;
import com.mycompany.discotiendaaa.pojo.Artista;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angie
 */
@Named(value = "crudArtista")
@SessionScoped
public class CrudArtista implements Serializable {

    private String nombre;
    private int id_artista;
    private String apellido;
    private Date fechaNacimiento;
    private String nacionalidad;
    private List<Artista> artistas;
    private ArtistaDB db;
    private List<Artista> eliminados;
    private Artista artista;

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }


    public int getId_artista() {
        return id_artista;
    }

    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void crearArtista() {
        artista = llenarArtista();
        db.agregarCancion(artista);
    }

    public Artista llenarArtista() {
        artista.setNombre(nombre);
        artista.setApellido(apellido);
        artista.setFechaNacimiento(fechaNacimiento);
        artista.setNacionalidad(nacionalidad);
        return artista;
    }

    @PostConstruct
    public void consultarArtista() {
        artistas.addAll(db.consultaArtistas());
    }

    public CrudArtista() {
        artista = new Artista();
        artistas = new ArrayList();
        eliminados = new ArrayList();
        db = new ArtistaDB();
    }

    public void onRowCancel(RowEditEvent event) {
        try {
            FacesMessage msg = new FacesMessage("Edición Cancelada: ", ((Artista) event.getObject()).getNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            Logger.getLogger(CrudCancion.class.getName()).log(Level.SEVERE,
                    "error onRowCancel:" + CrudArtista.class.getName() + " " + e, e);
        }

    }

    public void onRowEdit(RowEditEvent event) {
        try {
            artista.setId_artista(((Artista) event.getObject()).getId_artista());
            artista.setNombre(((Artista) event.getObject()).getNombre());
            artista.setApellido(((Artista) event.getObject()).getApellido());
            artista.setFechaNacimiento(((Artista) event.getObject()).getFechaNacimiento());
            artista.setNacionalidad(((Artista) event.getObject()).getNacionalidad());
            db.modificarArtista(artista);
            FacesMessage msg = new FacesMessage("Correcto todo bien todo bonito", ((Artista) event.getObject()).getNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            Logger.getLogger(CrudArtista.class.getName()).log(Level.SEVERE,
                    "error onRowEdit:" + CrudArtista.class.getName() + " " + e, e);
        }
    }

    public void eliminar() {
        try {
            for (Artista c : artistas) {
                if (c.isSeleccion()) {
                    eliminados.add(c);
                }
            }
            if (!eliminados.isEmpty()) {
                for (Artista s : eliminados) {
                    db.eliminarArtista(s.getId_artista());
                }
                artistas.removeAll(eliminados);
            }
            FacesMessage msg = new FacesMessage("Eliminados con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
        }

    }

    public ArtistaDB getDb() {
        return db;
    }

    public void setDb(ArtistaDB db) {
        this.db = db;
    }

    public List<Artista> getEliminados() {
        return eliminados;
    }

    public void setEliminados(List<Artista> eliminados) {
        this.eliminados = eliminados;
    }

}
