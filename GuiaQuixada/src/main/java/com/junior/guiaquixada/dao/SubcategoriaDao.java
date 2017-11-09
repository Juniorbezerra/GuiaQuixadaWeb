/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.dao;

import com.junior.guiaquixada.dao.filter.SubcategoriaFilter;
import com.junior.guiaquixada.model.Categoria;
import com.junior.guiaquixada.model.Subcategoria;
import com.junior.guiaquixada.util.JPAUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Junior Bezerra
 */
public class SubcategoriaDao extends GenericDao<Subcategoria> implements Serializable {

    public SubcategoriaDao() {
    }

    private static SubcategoriaDao instance;

    public static SubcategoriaDao getInstance() {
        if (instance == null) {
            instance = new SubcategoriaDao();
        }
        return instance;
    }

    public List<Subcategoria> filtrados(SubcategoriaFilter SubcategoriaFilter) {
        EntityManager em = JPAUtil.createEntityManager();
        try {
            Session session = em.unwrap(Session.class);
            Criteria criteria = session.createCriteria(Subcategoria.class);

            if (StringUtils.isNotBlank(SubcategoriaFilter.getDescricao())) {
                criteria.add(Restrictions.ilike("descricao", SubcategoriaFilter.getDescricao(), MatchMode.ANYWHERE));
            }
            return criteria.addOrder(Order.asc("descricao")).list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public List<Subcategoria> ListarPorId(Categoria id) {
        EntityManager em = JPAUtil.createEntityManager();
        Session session = em.unwrap(Session.class);
        try {
            Query query = session.createQuery("from Subcategoria s where s.categoria = :categoria");
            query.setParameter("categoria", id);
            return query.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
