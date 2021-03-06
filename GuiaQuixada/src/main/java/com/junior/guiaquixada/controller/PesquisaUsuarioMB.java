/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.controller;

import com.junior.guiaquixada.dao.filter.UsuarioFilter;
import com.junior.guiaquixada.dao.UsuarioDao;
import com.junior.guiaquixada.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PesquisaUsuarioMB implements Serializable{
           
        private List<Usuario> usuarios;
        
        private UsuarioFilter usuarioFilter;

        public PesquisaUsuarioMB() {
            usuarioFilter = new UsuarioFilter();
        }
        
	public void listarUsuario(){
            usuarios  = UsuarioDao.getInstance().filtrados(usuarioFilter);
        }

        public List<Usuario> getUsuarios() {
            return usuarios;
        }

        public UsuarioFilter getUsuarioFilter() {
            return usuarioFilter;
        }
        
        
    
    
}
