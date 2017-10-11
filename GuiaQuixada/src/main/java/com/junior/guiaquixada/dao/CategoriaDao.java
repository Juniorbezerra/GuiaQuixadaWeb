/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.dao;

import com.junior.guiaquixada.model.Categoria;
import java.io.Serializable;

/**
 *
 * @author Junior Bezerra
 */
public class CategoriaDao extends GenericDao<Categoria> implements Serializable {

    public CategoriaDao() {
        
    }
    
    private static CategoriaDao instance;
    
    public static CategoriaDao getInstance() {
        if (instance == null) {
            instance = new CategoriaDao();
        }
        return instance;
    }
    
    
}
