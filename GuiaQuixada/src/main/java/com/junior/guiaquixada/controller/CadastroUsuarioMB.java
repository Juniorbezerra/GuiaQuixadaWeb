package com.junior.guiaquixada.controller;

import com.junior.guiaquixada.dao.UsuarioDao;
import com.junior.guiaquixada.model.Usuario;
import com.junior.guiaquixada.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroUsuarioMB implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Usuario usuario;
    
    private List<Usuario> usuarios;
    
    public CadastroUsuarioMB() {
        this.limpar();
    }
    
    public void salvar() {
        UsuarioDao.getInstance().salvarOuAtualizar(usuario);
        limpar();
        FacesUtil.addInfoMessage("Usuário salvo com sucesso");
        
    }
    
    private void limpar() {
        usuario = new Usuario();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
