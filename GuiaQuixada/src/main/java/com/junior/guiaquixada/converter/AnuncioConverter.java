/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.converter;

import com.junior.guiaquixada.dao.AnuncioDao;
import com.junior.guiaquixada.model.Anuncio;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Junior Bezerra
 */
@FacesConverter(forClass = Anuncio.class)
public class AnuncioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
         Anuncio retorno = new Anuncio();

        if (StringUtils.isNotBlank(value)) {
            Long id = new Long(value);
            retorno = AnuncioDao.getInstance().getEntidadePorId(Anuncio.class, id);
        }
        return retorno;}

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value != null) {
            Anuncio anuncio = (Anuncio) value;
            return anuncio.getId() == null ? null : anuncio.getId().toString();
        }

        return null;
    }
}
   
