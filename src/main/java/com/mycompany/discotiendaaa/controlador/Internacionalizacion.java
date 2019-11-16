/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.controlador;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author familia manrique
 */
@Named(value = "inter")
@SessionScoped
public class Internacionalizacion implements Serializable{

    private String idioma;

    private static final Map<String, Object> listaIdiomas;
  
       public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    public Map<String, Object> getListaIdiomas() {
        return listaIdiomas;
    }
  
        static {
        listaIdiomas = new LinkedHashMap<>();        
        Locale espanol = new Locale("ES");
        listaIdiomas.put("Español", espanol);
        listaIdiomas.put("English", Locale.ENGLISH);      
    }    
        
    public void cambioIdioma(ValueChangeEvent e) {
        String newLanguage = e.getNewValue().toString();        
        for (Map.Entry<String, Object> entrySet : listaIdiomas.entrySet()) {
            if(entrySet.getValue().toString().equals(newLanguage)) {
                FacesContext.getCurrentInstance().getViewRoot()
                        .setLocale((Locale)entrySet.getValue());
            }
            
        }
    }
    
}
