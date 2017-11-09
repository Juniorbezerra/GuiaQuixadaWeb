/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.controller;

import com.junior.guiaquixada.dao.CategoriaDao;
import com.junior.guiaquixada.dao.SubcategoriaDao;
import com.junior.guiaquixada.model.Categoria;
import com.junior.guiaquixada.model.Subcategoria;
import com.junior.guiaquixada.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Junior Bezerra
 */
@ManagedBean
@ViewScoped
public class CadastroSubcategoriaMB implements Serializable{
    
    private List<Categoria> categorias;
    private Subcategoria subcategoria;
    byte[] foto;

    public CadastroSubcategoriaMB() {
        limpar();
        carregarCategoria();
    }
    
    private void carregarCategoria(){
        categorias = CategoriaDao.getInstance().getListaEntidadeOrdenado(Categoria.class);
    }
    
    private void limpar(){
        subcategoria = new Subcategoria();
        foto = null;
    }
    
    public void salvar() {

        try {
            if (subcategoria.getImagem() == null) {
                FacesUtil.addInfoAviso("selecione a imagem");
            }else{
            
                SubcategoriaDao.getInstance().salvarOuAtualizar(subcategoria);
            limpar();
            FacesUtil.addInfoMessage("Subcategoria salva com sucesso");
            }
        } catch (Exception e) {
            FacesUtil.addErrorMessage("Erro ao salvar Subcategoria");
            e.printStackTrace();
        }

    }
    
    public void upload(FileUploadEvent evento) {
        try {
            
            foto = evento.getFile().getContents();
            subcategoria.setImagem(foto);
            
        } catch (Exception erro) {
            FacesUtil.addErrorMessage("Ocorreu um erro ao tentar realizar o upload de arquivo");
            erro.printStackTrace();
        }
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }
   
}
