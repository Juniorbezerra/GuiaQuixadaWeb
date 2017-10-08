package com.junior.guiaquixada.controller;

import com.junior.guiaquixada.dao.CategoriaHospedagemDao;
import com.junior.guiaquixada.model.CategoriaHospedagem;
import com.junior.guiaquixada.util.FacesUtil;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroCategoriaHospedagemBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private CategoriaHospedagem categoriaHospedagem;

    public CadastroCategoriaHospedagemBean() {
        this.limpar();
    }

    public void limpar() {
        categoriaHospedagem = new CategoriaHospedagem();
    }

    public void salvar() {

        try {

            if (categoriaHospedagem.getUrl() == null) {
                FacesUtil.addErrorMessage("O campo imagem é obrigatório");
            }

            CategoriaHospedagemDao.getInstance().salvarOuAtualizar(categoriaHospedagem);

            Path origem = Paths.get(categoriaHospedagem.getUrl());

            Path destino = Paths.get("C:/Uploads/" + categoriaHospedagem.getId() + ".svg");

            Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);

            limpar();
            FacesUtil.addInfoMessage("Categoria salva com sucesso");

        } catch (IOException ex) {

            ex.printStackTrace();
            FacesUtil.addErrorMessage("Erro ao salvar categoria");

        }

    }

    public CategoriaHospedagem getCategoriaHospedagem() {
        return categoriaHospedagem;
    }

}
