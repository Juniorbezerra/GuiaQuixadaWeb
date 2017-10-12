/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.dao;

import com.junior.guiaquixada.dao.filter.CategoriaFilter;
import com.junior.guiaquixada.model.Categoria;
import com.junior.guiaquixada.util.JPAUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
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
public class CategoriaDao extends GenericDao<Categoria> implements Serializable {

    public CategoriaDao() {
        
    }
    
    private static CategoriaDao instance;
    
    public static CategoriaDao getInstance() {
        if (instance == null) {
            instance = new CategoriaDao();
        }
        return instance;
    }
    
    public List<Categoria> filtrados(CategoriaFilter categoriaFilter) {
        EntityManager em = JPAUtil.createEntityManager();
        try {
            Session session = em.unwrap(Session.class);
            Criteria criteria = session.createCriteria(Categoria.class);

            if (StringUtils.isNotBlank(categoriaFilter.getDescricao())) {
                criteria.add(Restrictions.ilike("descricao", categoriaFilter.getDescricao(), MatchMode.ANYWHERE));
            }
            return criteria.addOrder(Order.asc("descricao")).list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }
    
}
