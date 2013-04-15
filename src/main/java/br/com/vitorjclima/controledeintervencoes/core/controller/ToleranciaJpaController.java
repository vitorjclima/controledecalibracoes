/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.core.controller;

import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.NonexistentEntityException;
import br.com.vitorjclima.controledeintervencoes.db.Tolerancia;
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
public class ToleranciaJpaController implements Serializable {

    public ToleranciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
      public ToleranciaJpaController() {
        this.createEntityManagerFactory();
    }

    private void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("ControleDeIntervencoesUP");
    }

    public void create(Tolerancia tolerancia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tolerancia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tolerancia tolerancia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tolerancia = em.merge(tolerancia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tolerancia.getToleranciaId();
                if (findTolerancia(id) == null) {
                    throw new NonexistentEntityException("The tolerancia with id " + id + " no longer exists.");
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
            Tolerancia tolerancia;
            try {
                tolerancia = em.getReference(Tolerancia.class, id);
                tolerancia.getToleranciaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tolerancia with id " + id + " no longer exists.", enfe);
            }
            em.remove(tolerancia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tolerancia> findToleranciaEntities() {
        return findToleranciaEntities(true, -1, -1);
    }

    public List<Tolerancia> findToleranciaEntities(int maxResults, int firstResult) {
        return findToleranciaEntities(false, maxResults, firstResult);
    }

    private List<Tolerancia> findToleranciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tolerancia.class));
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

    public Tolerancia findTolerancia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tolerancia.class, id);
        } finally {
            em.close();
        }
    }

    public int getToleranciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tolerancia> rt = cq.from(Tolerancia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
