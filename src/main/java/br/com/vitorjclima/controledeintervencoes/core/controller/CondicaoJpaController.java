/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.core.controller;

import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.NonexistentEntityException;
import br.com.vitorjclima.controledeintervencoes.db.Condicao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author vitor
 */
public class CondicaoJpaController implements Serializable {

    
    public CondicaoJpaController() {
        this.createEntityManagerFactory();
    }

    private void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("ControleDeIntervencoesUP");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Condicao condicao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(condicao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Condicao condicao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            condicao = em.merge(condicao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = condicao.getCondicaoId();
                if (findCondicao(id) == null) {
                    throw new NonexistentEntityException("The condicao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Condicao condicao;
            try {
                condicao = em.getReference(Condicao.class, id);
                condicao.getCondicaoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The condicao with id " + id + " no longer exists.", enfe);
            }
            em.remove(condicao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Condicao> findCondicaoEntities() {
        return findCondicaoEntities(true, -1, -1);
    }

    public List<Condicao> findCondicaoEntities(int maxResults, int firstResult) {
        return findCondicaoEntities(false, maxResults, firstResult);
    }

    private List<Condicao> findCondicaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Condicao.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Condicao findCondicao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Condicao.class, id);
        } finally {
            em.close();
        }
    }

    public int getCondicaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Condicao> rt = cq.from(Condicao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
