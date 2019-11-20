/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.controlador;

import com.mycompany.discotiendaaa.modelo.DiscoDB;
import com.mycompany.discotiendaaa.pojo.Disco;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author familia manrique
 */
@Named(value = "crudDisco")
@SessionScoped
public class CrudDisco implements Serializable {

    private String nombre;
    private String caratula;
    private String artista;
    private int id_disco;
    private List<Disco> listadoDiscos;
    private List<String> nombreArtistas;
    DiscoDB discoDB;
    Disco disco;
    private ArrayList<Disco> discosEliminados;
    private UploadedFile imagen;

    /**
     * Creates a new instance of CrudDisco
     */
    public CrudDisco() {
        discoDB = new DiscoDB();
        listadoDiscos = new ArrayList();
        discosEliminados = new ArrayList();
    }

    @PostConstruct
    public void init() {
        llenarListadoDiscos();
        listadoDiscos.addAll(discoDB.consultaDiscos());
    }

    private void llenarListadoDiscos() {
        nombreArtistas = new ArrayList();
        nombreArtistas.addAll(discoDB.consultarNombreArtistas());        
    }

    public void llenarListaDiscos() {
        //String ruta="C:/Users/angie/Documents/NetBeansProjects/la-disco/src/main/webapp/resources/imagenes/";
        String ruta = "D:/Users/familia manrique/Documents/NetBeansProjects/DiscotiendaAA/src/main/webapp/resources/imagenes/";
        String rutaimg;
        try {
            InputStream input = imagen.getInputstream();
            rutaimg = ruta + imagen.getFileName();
            OutputStream out = new FileOutputStream(new File(rutaimg));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = input.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            //caratula = rutaimg.substring(67);
            caratula = rutaimg.substring(83);//66 en el PC de Cristian, 67 en el pcsito
            discoDB.agregarDisco(nombre, caratula, artista);
            listadoDiscos.addAll(discoDB.consultaDiscos());
        } catch (Exception e) {
            Logger.getLogger(CrudDisco.class.getName()).log(Level.SEVERE,
                    "error método llenarListaDiscos() :" + CrudDisco.class.getName() + " " + e, e);
        }

    }

    public void onRowEdit(RowEditEvent event) {
        try {
            id_disco = ((Disco) event.getObject()).getId_disco();
            nombre = ((Disco) event.getObject()).getNombre();      
            artista = ((Disco) event.getObject()).getNombre_artista();
            discoDB.modificarDisco(id_disco, nombre, artista);
            FacesMessage msg = new FacesMessage("Editado con exito", ((Disco) event.getObject()).getNombre());
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
            FacesMessage msg = new FacesMessage("Edición Cancelada: ", ((Disco) event.getObject()).getNombre());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            Logger.getLogger(CrudCancion.class.getName()).log(Level.SEVERE,
                    "error onRowCancel:" + CrudCancion.class.getName() + " " + e, e);
        }

    }

    public void eliminar() {
        try {
            for (Disco c : listadoDiscos) {
                if (c.isSeleccion()) {
                    discosEliminados.add(c);
                }
            }
            if (!discosEliminados.isEmpty()) {
                for (Disco s : discosEliminados) {
                    discoDB.eliminarDisco(s.getId_disco());
                }
                listadoDiscos.removeAll(discosEliminados);
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

    public UploadedFile getCaratula() {
        return imagen;
    }

    public void setCaratula(UploadedFile imagen) {
        this.imagen = imagen;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getId_disco() {
        return id_disco;
    }

    public void setId_disco(int id_disco) {
        this.id_disco = id_disco;
    }

    public List<Disco> getListadoDiscos() {
        return listadoDiscos;
    }

    public void setListadoDiscos(List<Disco> listadoDiscos) {
        this.listadoDiscos = listadoDiscos;
    }

    public List<String> getNombreArtistas() {
        return nombreArtistas;
    }

    public void setNombreArtistas(List<String> nombreArtistas) {
        this.nombreArtistas = nombreArtistas;
    }

    public DiscoDB getDiscoDB() {
        return discoDB;
    }

    public void setDiscoDB(DiscoDB discoDB) {
        this.discoDB = discoDB;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public ArrayList<Disco> getDiscosEliminados() {
        return discosEliminados;
    }

    public void setDiscosEliminados(ArrayList<Disco> discosEliminados) {
        this.discosEliminados = discosEliminados;
    }

    public void setCaratula(String caratula) {
        this.caratula = caratula;
    }

    public UploadedFile getImagen() {
        return imagen;
    }

    public void setImagen(UploadedFile imagen) {
        this.imagen = imagen;
    }

}
