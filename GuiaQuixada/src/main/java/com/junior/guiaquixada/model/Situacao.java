/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.model;

/**
 *
 * @author Junior Bezerra
 */
public enum Situacao {
    ATIVO("Ativo"),
    INATIVO("Inativo");
    
    private String situacao;
    
    private Situacao(String situacao) {
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }

    
    
    
}
