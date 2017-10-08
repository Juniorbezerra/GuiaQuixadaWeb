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
public class UsuarioDao extends GenericDao<Usuario> implements Serializable {

    public UsuarioDao() {

    }

    private static UsuarioDao instance;

    public static UsuarioDao getInstance() {
        if (instance == null) {
            instance = new UsuarioDao();
        }
        return instance;
    }

    public List<Usuario> filtrados(UsuarioFilter usuarioFilte) {
        EntityManager em = JPAUtil.createEntityManager();
        try {
            Session session = em.unwrap(Session.class);
            Criteria criteria = session.createCriteria(Usuario.class);

            if (StringUtils.isNotBlank(usuarioFilte.getNome())) {
                criteria.add(Restrictions.ilike("nome", usuarioFilte.getNome(), MatchMode.ANYWHERE));
            }
            return criteria.addOrder(Order.asc("nome")).list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public boolean buscarEmail(String email) {
        EntityManager em = JPAUtil.createEntityManager();

        try {

            Usuario usuario = null;
            try {
                usuario = em.createQuery("from Usuario where lower(email) = :email", Usuario.class)
                        .setParameter("email", email.toLowerCase()).getSingleResult();
            } catch (NoResultException e) {
                e.printStackTrace();
            }

            if (usuario == null) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            em.close();
        }
        return true;
    }
}
