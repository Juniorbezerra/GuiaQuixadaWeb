/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.controller;

import com.junior.guiaquixada.dao.CategoriaDao;
import com.junior.guiaquixada.dao.filter.CategoriaFilter;
import com.junior.guiaquixada.model.Categoria;
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
public class PesquisarCategoriaBean implements Serializable{

    private List<Categoria> categorias;

    private CategoriaFilter categoriaFilter;

    public PesquisarCategoriaBean() {
        categoriaFilter = new CategoriaFilter();
    }

    public void listarCategoria() {
        categorias = CategoriaDao.getInstance().filtrados(categoriaFilter);
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public CategoriaFilter getCategoriaFilter() {
        return categoriaFilter;
    }
   
}
