/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.controller;

import com.junior.guiaquixada.dao.SubcategoriaDao;
import com.junior.guiaquixada.dao.filter.SubcategoriaFilter;
import com.junior.guiaquixada.model.Subcategoria;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Junior Bezerra
 */
@ManagedBean
@ViewScoped
public class PesquisarSubcategoriaBean implements Serializable{
    
    private List<Subcategoria> subcategorias;
    
    private SubcategoriaFilter subcategoriaFilter;

    public PesquisarSubcategoriaBean() {
        subcategoriaFilter = new SubcategoriaFilter();
    }
    
    public void listarSubcategoria(){
      subcategorias = SubcategoriaDao.getInstance().filtrados(subcategoriaFilter);
    }

    public List<Subcategoria> getSubcategorias() {
        return subcategorias;
    }

    public SubcategoriaFilter getSubcategoriaFilter() {
        return subcategoriaFilter;
    }
    
    
    
    
    
}
