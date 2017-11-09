/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.dao;

import com.junior.guiaquixada.dao.filter.AnuncioFilter;
import com.junior.guiaquixada.model.Anuncio;
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
public class AnuncioDao extends GenericDao<Anuncio> implements Serializable{
    
    public AnuncioDao() {
        
    }
    
    private static AnuncioDao instance;
    
    public static AnuncioDao getInstance() {
        if (instance == null) {
            instance = new AnuncioDao();
        }
        return instance;
    }
    
    public List<Anuncio> filtrados(AnuncioFilter anuncioFilter) {
        EntityManager em = JPAUtil.createEntityManager();
        try {
            Session session = em.unwrap(Session.class);
            Criteria criteria = session.createCriteria(Anuncio.class);

            if (StringUtils.isNotBlank(anuncioFilter.getDescricao())) {
                criteria.add(Restrictions.ilike("descricao", anuncioFilter.getDescricao(), MatchMode.ANYWHERE));
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
