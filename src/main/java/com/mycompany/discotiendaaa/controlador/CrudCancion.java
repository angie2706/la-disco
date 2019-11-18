/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.controlador;

import com.mycompany.discotiendaaa.modelo.CancionDB;
import com.mycompany.discotiendaaa.pojo.Cancion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author familia manrique
 */
@Named(value = "crudCancion")
@SessionScoped
public class CrudCancion implements Serializable {

    private String nombre;
    private String duracion, disco;
    private float precio;
    private int id_cancion;
    private List<Cancion> listadoCanciones;
    private List<String> nombreDiscos;
    CancionDB cancionDB;
    Cancion cancion;
    private ArrayList<Cancion> cancionesEliminadas;

    /**
     * Creates a new instance of CrudCancion
     */
    public CrudCancion() {
        cancionDB = new CancionDB();
        listadoCanciones = new ArrayList();
        cancionesEliminadas = new ArrayList();
    }

    @PostConstruct
    public void init() {
        llenarListadoDiscos();
        listadoCanciones.addAll(cancionDB.consultaCanciones());
    }

    private void llenarListadoDiscos() {
        nombreDiscos = new ArrayList();
        nombreDiscos.addAll(cancionDB.consultarNombreDiscos());
    }

    public void llenarListaCanciones() {
        try {
            cancionDB.agregarCancion(nombre, duracion, disco, precio);
            listadoCanciones.addAll(cancionDB.consultaCanciones());
        } catch (Exception e) {
            Logger.getLogger(CrudCancion.class.getName()).log(Level.SEVERE,
                    "error método llenarListaCanciones() :" + CrudCancion.class.getName() + " " + e, e);
        }

    }

    public void onRowEdit(RowEditEvent event) {
        try {
            id_cancion = ((Cancion) event.getObject()).getId_cancion();
            nombre = ((Cancion) event.getObject()).getNombre();
            duracion = ((Cancion) event.getObject()).getDuracion();
            disco = ((Cancion) event.getObject()).getNombre_disco();
            precio = ((Cancion) event.getObject()).getPrecio();
            cancionDB.modificarCancion(id_cancion, nombre, duracion, disco, precio);
            FacesMessage msg = new FacesMessage("Vehículo editado con exito", ((Cancion) event.getObject()).getNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            Logger.getLogger(CrudCancion.class.getName()).log(Level.SEVERE,
                    "error onRowEdit:" + CrudCancion.class.getName() + " " + e, e);
        }
    }

    /**
     * Método que cancela la edición de la fila seleccionada
     *
     * @param event
     */
    public void onRowCancel(RowEditEvent event) {
        try {
            FacesMessage msg = new FacesMessage("Edición Cancelada: ", ((Cancion) event.getObject()).getNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            Logger.getLogger(CrudCancion.class.getName()).log(Level.SEVERE,
                    "error onRowCancel:" + CrudCancion.class.getName() + " " + e, e);
        }

    }

    public void eliminar() {
        try {
            for (Cancion c : listadoCanciones) {
                if (c.isSeleccion()) {
                    cancionesEliminadas.add(c);
                }
            }
            if (!cancionesEliminadas.isEmpty()) {
                for (Cancion s : cancionesEliminadas) {
                    cancionDB.eliminarCancion(s.getId_cancion());
                }
                listadoCanciones.removeAll(cancionesEliminadas);
            }
            FacesMessage msg = new FacesMessage("Eliminados con exito");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public List<Cancion> getListadoCanciones() {
        return listadoCanciones;
    }

    public void setListadoCanciones(List<Cancion> listadoCanciones) {
        this.listadoCanciones = listadoCanciones;
    }

    public CancionDB getCancionDB() {
        return cancionDB;
    }

    public void setCancionDB(CancionDB cancionDB) {
        this.cancionDB = cancionDB;
    }

    public List<String> getNombreDiscos() {
        return nombreDiscos;
    }

    public void setNombreDiscos(List<String> nombreDiscos) {
        this.nombreDiscos = nombreDiscos;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public ArrayList<Cancion> getCancionesEliminadas() {
        return cancionesEliminadas;
    }

    public void setCancionesEliminadas(ArrayList<Cancion> cancionesEliminadas) {
        this.cancionesEliminadas = cancionesEliminadas;
    }

    public int getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }

}
