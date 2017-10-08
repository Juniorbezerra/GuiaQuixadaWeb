package com.junior.guiaquixada.converter;

import com.junior.guiaquixada.dao.UsuarioDao;
import com.junior.guiaquixada.model.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.commons.lang3.StringUtils;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Usuario retorno = new Usuario();

        if (StringUtils.isNotBlank(value)) {
            Long id = new Long(value);
            retorno = UsuarioDao.getInstance().getEntidadePorId(Usuario.class, id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Usuario usuario = (Usuario) value;
            return usuario.getId() == null ? null : usuario.getId().toString();
        }

        return null;
    }

}
