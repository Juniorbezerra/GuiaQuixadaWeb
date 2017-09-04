package com.junior.guiaquixada.dao;

import com.junior.guiaquixada.model.Usuario;
import com.junior.guiaquixada.dao.filter.UsuarioFilter;
import com.junior.guiaquixada.util.JPAUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Junior Bezerra
 */
public class usuarioDao extends GenericDao<Usuario> implements Serializable {

    public usuarioDao() {

    }

    private static usuarioDao instance;

    public static usuarioDao getInstance() {
        if (instance == null) {
            instance = new usuarioDao();
        }
        return instance;
    }

    public List<Usuario> filtrados(UsuarioFilter usuarioFilte) {
        EntityManager em = JPAUtil.createEntityManager();
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Usuario.class);

        if (StringUtils.isNotBlank(usuarioFilte.getNome())) {
            criteria.add(Restrictions.ilike("nome", usuarioFilte.getNome(), MatchMode.ANYWHERE));
        }
        return criteria.addOrder(Order.asc("nome")).list();
    }

    public Usuario buscarEmail(String email) {
        EntityManager em = JPAUtil.createEntityManager();
        Usuario usuario = null;
        try {
            usuario = em.createQuery("from Usuario where lower(email) = :email", Usuario.class)
                    .setParameter("email", email.toLowerCase()).getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
