package com.junior.guiaquixada.dao;

import com.junior.guiaquixada.util.JPAUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;


public class GenericDao<T extends EntidadeBase> implements Serializable {
    
	private static final long serialVersionUID = 1L;

	public void salvarOuAtualizar(T t) {
        EntityManager em = JPAUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remover(Class<T> classe, T t) {
        EntityManager em = JPAUtil.createEntityManager();
        try {
            t = em.find(classe, t.getId());
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public T getEntidadePorId(Class<T> classe, Long id) {
        EntityManager em = JPAUtil.createEntityManager();
        T t = null;
        try {
            return t = (T) em.find(classe, id);
        } finally {
            em.close();
        }
    }

    public List<T> getListaEntidade(Class<T> classe) {
        EntityManager em = JPAUtil.createEntityManager();
        try {
            Session session = em.unwrap(Session.class);
            Criteria criteria = session.createCriteria(classe);

            return criteria.list();
        } finally {
            em.close();
        }
    }
}
