/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.controller;

import com.junior.guiaquixada.dao.AnuncioDao;
import com.junior.guiaquixada.dao.SubcategoriaDao;
import com.junior.guiaquixada.model.Anuncio;
import com.junior.guiaquixada.model.Subcategoria;
import com.junior.guiaquixada.util.FacesUtil;
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
public class CadastroAnuncioMB implements Serializable{
    
    private Anuncio anuncio;
    private List<Subcategoria> subcategorias;

    public CadastroAnuncioMB() {
       
        limpar();
        CarregarListaDeAnuncio();
        
    }
    
    public void CarregarListaDeAnuncio(){
        
        subcategorias = SubcategoriaDao.getInstance().getListaEntidadeOrdenado(Subcategoria.class);
        
    }
    
    public void salvar(){
        try {
            AnuncioDao.getInstance().salvarOuAtualizar(anuncio);
            limpar();
            FacesUtil.addInfoMessage("Anúncio salvo com sucesso");
        } catch (Exception e) {
            FacesUtil.addErrorMessage("Erro ao salvar Anúncio");
            e.printStackTrace();
        }
    }
    
    public void limpar(){
        anuncio = new Anuncio();
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    } 

    public List<Subcategoria> getSubcategorias() {
        return subcategorias;
    }
    
}
