package com.junior.guiaquixada.controller;

import com.junior.guiaquixada.dao.CategoriaDao;
import com.junior.guiaquixada.model.Categoria;
import com.junior.guiaquixada.util.FacesUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;

@ManagedBean
@ViewScoped
public class CadastroCategoriaMB implements Serializable {
    
    private Categoria categoria;
    byte[] foto;
   
    public CadastroCategoriaMB() {
        
        this.limpar();
        
    }

    public void limpar() {
        categoria = new Categoria();
        foto = null;
    }

    public void salvar() {

        try {
            if (categoria.getImagem() == null) {
                FacesUtil.addInfoAviso("selecione a imagem");
            }else{
            
            CategoriaDao.getInstance().salvarOuAtualizar(categoria);
            limpar();
            FacesUtil.addInfoMessage("Categoria salva com sucesso");
            }
        } catch (Exception e) {
            FacesUtil.addErrorMessage("Erro ao salvar categoria!!");
            e.printStackTrace();
        }

    }

    public void upload(FileUploadEvent evento) {
        try {
            
            foto = evento.getFile().getContents();
            categoria.setImagem(foto);
            
        } catch (Exception erro) {
            FacesUtil.addErrorMessage("Ocorreu um erro ao tentar realizar o upload de arquivo");
            erro.printStackTrace();
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
   
}
