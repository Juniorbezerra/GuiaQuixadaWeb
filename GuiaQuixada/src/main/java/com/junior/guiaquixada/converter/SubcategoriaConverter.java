/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.converter;

import com.junior.guiaquixada.dao.SubcategoriaDao;
import com.junior.guiaquixada.model.Subcategoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Junior Bezerra
 */
@FacesConverter(forClass = Subcategoria.class)
public class SubcategoriaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        Subcategoria retorno = new Subcategoria();

        if (StringUtils.isNotBlank(value)) {
            Long id = new Long(value);
            retorno = SubcategoriaDao.getInstance().getEntidadePorId(Subcategoria.class, id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value != null) {
            Subcategoria subcategoria = (Subcategoria) value;
            return subcategoria.getId() == null ? null : subcategoria.getId().toString();
        }

        return null;
    }
}
