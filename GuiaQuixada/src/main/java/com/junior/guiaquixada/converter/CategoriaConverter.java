/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.converter;

import com.junior.guiaquixada.dao.CategoriaDao;
import com.junior.guiaquixada.model.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Junior Bezerra
 */
@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Categoria retorno = new Categoria();

        if (StringUtils.isNotBlank(value)) {
            Long id = new Long(value);
            retorno = CategoriaDao.getInstance().getEntidadePorId(Categoria.class, id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
         if (value != null) {
            Categoria categoria = (Categoria) value;
            return categoria.getId() == null ? null : categoria.getId().toString();
        }

        return null;
    }
    
}
