/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.service;

import com.junior.guiaquixada.dao.UsuarioDao;
import com.junior.guiaquixada.model.Usuario;
import com.junior.guiaquixada.util.FacesUtil;
import java.io.Serializable;

/**
 *
 * @author Junior Bezerra
 */
public class Usuarios implements Serializable{

    public Usuarios() {
    }
    
    private static Usuarios instance;
    
    public static Usuarios getInstance() {
        if (instance == null) {
            instance = new Usuarios();
        }
        return instance;
    }
    
    
    public void salvar(Usuario usuario){
        
        if(!UsuarioDao.getInstance().buscarEmail(usuario.getEmail())){
            UsuarioDao.getInstance().salvarOuAtualizar(usuario);
            FacesUtil.addInfoMessage("Usuário salvo com sucesso");
        }else{
        
            FacesUtil.addErrorMessage("E-mail já cadastrado");
        }
    }
}
