/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.core.controller;

import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.NonexistentEntityException;
import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.PreexistingEntityException;
import br.com.vitorjclima.controledeintervencoes.db.IntervencaoTipo;
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
public class IntervencaoTipoJpaController implements Serializable {

    public IntervencaoTipoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public IntervencaoTipoJpaController() {
        this.createEntityManagerFactory();
    }

    private void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("ControleDeIntervencoesUP");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IntervencaoTipo intervencaoTipo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(intervencaoTipo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findIntervencaoTipo(intervencaoTipo.getIntervencaoTipoId()) != null) {
                throw new PreexistingEntityException("IntervencaoTipo " + intervencaoTipo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IntervencaoTipo intervencaoTipo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            intervencaoTipo = em.merge(intervencaoTipo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = intervencaoTipo.getIntervencaoTipoId();
                if (findIntervencaoTipo(id) == null) {
                    throw new NonexistentEntityException("The intervencaoTipo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IntervencaoTipo intervencaoTipo;
            try {
                intervencaoTipo = em.getReference(IntervencaoTipo.class, id);
                intervencaoTipo.getIntervencaoTipoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The intervencaoTipo with id " + id + " no longer exists.", enfe);
            }
            em.remove(intervencaoTipo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IntervencaoTipo> findIntervencaoTipoEntities() {
        return findIntervencaoTipoEntities(true, -1, -1);
    }

    public List<IntervencaoTipo> findIntervencaoTipoEntities(int maxResults, int firstResult) {
        return findIntervencaoTipoEntities(false, maxResults, firstResult);
    }

    private List<IntervencaoTipo> findIntervencaoTipoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IntervencaoTipo.class));
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

    public IntervencaoTipo findIntervencaoTipo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IntervencaoTipo.class, id);
        } finally {
            em.close();
        }
    }

    public int getIntervencaoTipoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IntervencaoTipo> rt = cq.from(IntervencaoTipo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
