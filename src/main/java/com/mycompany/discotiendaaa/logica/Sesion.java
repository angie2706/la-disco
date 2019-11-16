/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discotiendaaa.logica;

import com.mycompany.discotiendaaa.pojo.Admin;

/**
 *
 * @author familia manrique
 */
public class Sesion {
    public boolean validarSesion(String usuario, String contrasena) {
        if ("juanita123".equals(usuario) && "Holiwi".equals(contrasena)) {
            return true;
        }
        return false;
    }
}
