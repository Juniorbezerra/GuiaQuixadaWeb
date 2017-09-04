package com.junior.guiaquixada.controller;

import com.junior.guiaquixada.dao.usuarioDao;
import com.junior.guiaquixada.model.Situacao;
import com.junior.guiaquixada.model.Usuario;
import com.junior.guiaquixada.service.Usuarios;
import com.junior.guiaquixada.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroUsuarioBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Usuario usuario;
    
    private List<Usuario> usuarios;
    
    public CadastroUsuarioBean() {
        this.limpar();
    }
    
    public void salvar() {
        usuarioDao.getInstance().salvarOuAtualizar(usuario);
        limpar();
        FacesUtil.addInfoMessage("Usuário salvo com sucesso");
        
    }
    
    private void limpar() {
        usuario = new Usuario();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public Situacao[] getSituacao() {
        return Situacao.values();
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
}
