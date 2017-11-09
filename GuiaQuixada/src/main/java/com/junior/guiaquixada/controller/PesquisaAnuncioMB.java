/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.controller;

import com.junior.guiaquixada.dao.AnuncioDao;
import com.junior.guiaquixada.dao.SubcategoriaDao;
import com.junior.guiaquixada.dao.filter.AnuncioFilter;
import com.junior.guiaquixada.model.Anuncio;
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
public class PesquisaAnuncioMB implements Serializable{
    
    private List<Anuncio> anuncios;
    
    private AnuncioFilter anuncioFilter;

    public PesquisaAnuncioMB() {
        anuncioFilter = new AnuncioFilter();
    }
    
    public void listaAnuncio(){
        anuncios = AnuncioDao.getInstance().filtrados(anuncioFilter);
        
    }
    
    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public AnuncioFilter getAnuncioFilter() {
        return anuncioFilter;
    }
    
    public int getTamanhoLista(){
        return AnuncioDao.getInstance().getListaEntidade(Anuncio.class).size();
    }
    
    
}
