/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.dao;

import com.junior.guiaquixada.model.CategoriaHospedagem;
import com.junior.guiaquixada.model.Usuario;
import java.io.Serializable;

/**
 *
 * @author Junior Bezerra
 */
public class CategoriaHospedagemDao extends GenericDao<CategoriaHospedagem> implements Serializable {

    public CategoriaHospedagemDao() {
        
    }
    
    private static CategoriaHospedagemDao instance;
    
    public static CategoriaHospedagemDao getInstance() {
        if (instance == null) {
            instance = new CategoriaHospedagemDao();
        }
        return instance;
    }
    
    
}
