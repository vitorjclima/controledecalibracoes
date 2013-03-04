/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.core.controller;

import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.NonexistentEntityException;
import br.com.vitorjclima.controledeintervencoes.db.LaudoIntervencao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author vitor
 */
public class LaudoIntervencaoJpaController implements Serializable {

    public LaudoIntervencaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LaudoIntervencao laudoIntervencao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(laudoIntervencao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LaudoIntervencao laudoIntervencao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            laudoIntervencao = em.merge(laudoIntervencao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = laudoIntervencao.getLaudoIntervencaoId();
                if (findLaudoIntervencao(id) == null) {
                    throw new NonexistentEntityException("The laudoIntervencao with id " + id + " no longer exists.");
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
            LaudoIntervencao laudoIntervencao;
            try {
                laudoIntervencao = em.getReference(LaudoIntervencao.class, id);
                laudoIntervencao.getLaudoIntervencaoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The laudoIntervencao with id " + id + " no longer exists.", enfe);
            }
            em.remove(laudoIntervencao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LaudoIntervencao> findLaudoIntervencaoEntities() {
        return findLaudoIntervencaoEntities(true, -1, -1);
    }

    public List<LaudoIntervencao> findLaudoIntervencaoEntities(int maxResults, int firstResult) {
        return findLaudoIntervencaoEntities(false, maxResults, firstResult);
    }

    private List<LaudoIntervencao> findLaudoIntervencaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LaudoIntervencao.class));
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

    public LaudoIntervencao findLaudoIntervencao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LaudoIntervencao.class, id);
        } finally {
            em.close();
        }
    }

    public int getLaudoIntervencaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LaudoIntervencao> rt = cq.from(LaudoIntervencao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
