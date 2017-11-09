/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.model;

import com.junior.guiaquixada.dao.EntidadeBase;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Junior Bezerra
 */

@Entity
public class Anuncio implements Serializable,EntidadeBase{

    private Long id;
    private boolean status;
    private Subcategoria subcategoria;
    private String descricao;
    private String imagemPrincipal;
    private String descricaoAnuncio;
    private String endereco;
    private String bairro;
    private String numero;
    private String latitude;
    private String Longitude;
    private String telefone;
    private String telefone2;
    private String email;
    private String facebook;
    private String instagram;
    
    @Override
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @ManyToOne
    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    @NotEmpty(message = "Informe a descrição do anúncio")
    @Column(length = 40)
    public String getDescricao() {
        return descricao;
    }

    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @NotEmpty(message = "Informe a URL da imagem Principal")
    public String getImagemPrincipal() {
        return imagemPrincipal;
    }

    public void setImagemPrincipal(String imagemPrincipal) {
        this.imagemPrincipal = imagemPrincipal;
    }
    
    @Column(columnDefinition = "text")
    public String getDescricaoAnuncio() {
        return descricaoAnuncio;
    }

    public void setDescricaoAnuncio(String descricaoAnuncio) {
        this.descricaoAnuncio = descricaoAnuncio;
    }

    @NotEmpty(message = "informe o endereço")
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @NotEmpty(message = "Informe o bairro")
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @NotEmpty(message = "Informe o número")
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @NotEmpty(message = "Informe a latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

     @NotEmpty(message = "Informe a longitude")
    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }
    

    @NotEmpty(message = "Informe o número do telefone")
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    @Email(message = "ínforme um email válido")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Anuncio other = (Anuncio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
