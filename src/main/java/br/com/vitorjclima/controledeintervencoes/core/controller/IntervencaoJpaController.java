/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.core.controller;

import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.NonexistentEntityException;
import br.com.vitorjclima.controledeintervencoes.db.Intervencao;
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
public class IntervencaoJpaController implements Serializable {

    public IntervencaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public IntervencaoJpaController() {
        this.createEntityManagerFactory();
    }

    private void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("ControleDeIntervencoesUP");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Intervencao intervencao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(intervencao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Intervencao intervencao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            intervencao = em.merge(intervencao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = intervencao.getIntervencaoId();
                if (findIntervencao(id) == null) {
                    throw new NonexistentEntityException("The intervencao with id " + id + " no longer exists.");
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
            Intervencao intervencao;
            try {
                intervencao = em.getReference(Intervencao.class, id);
                intervencao.getIntervencaoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The intervencao with id " + id + " no longer exists.", enfe);
            }
            em.remove(intervencao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Intervencao> findIntervencaoEntities() {
        return findIntervencaoEntities(true, -1, -1);
    }

    public List<Intervencao> findIntervencaoEntities(int maxResults, int firstResult) {
        return findIntervencaoEntities(false, maxResults, firstResult);
    }

    private List<Intervencao> findIntervencaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Intervencao.class));
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

    public Intervencao findIntervencao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Intervencao.class, id);
        } finally {
            em.close();
        }
    }

    public int getIntervencaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Intervencao> rt = cq.from(Intervencao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
