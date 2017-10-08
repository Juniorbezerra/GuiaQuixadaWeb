/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.model;

import com.junior.guiaquixada.dao.EntidadeBase;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Junior Bezerra
 */
@Entity
public class CategoriaHospedagem implements Serializable,EntidadeBase {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Situacao situacao;
    private String descricao;
    private String url;
    private int versao;

    @Id
    @GeneratedValue
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @NotBlank(message = "Descrição é um campo obrigatório")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    @Version
    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }
    
    @Enumerated(EnumType.STRING)
    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaHospedagem)) {
            return false;
        }
        CategoriaHospedagem other = (CategoriaHospedagem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.junior.guiaquixada.model.CategoriaHospedagem[ id=" + id + " ]";
    }

    

  

    
    
}
