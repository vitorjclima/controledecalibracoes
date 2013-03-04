/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.core.controller;

import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.NonexistentEntityException;
import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.PreexistingEntityException;
import br.com.vitorjclima.controledeintervencoes.db.IntervencaoAnexo;
import br.com.vitorjclima.controledeintervencoes.db.IntervencaoAnexoPK;
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
public class IntervencaoAnexoJpaController implements Serializable {

    public IntervencaoAnexoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IntervencaoAnexo intervencaoAnexo) throws PreexistingEntityException, Exception {
        if (intervencaoAnexo.getIntervencaoAnexoPK() == null) {
            intervencaoAnexo.setIntervencaoAnexoPK(new IntervencaoAnexoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(intervencaoAnexo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findIntervencaoAnexo(intervencaoAnexo.getIntervencaoAnexoPK()) != null) {
                throw new PreexistingEntityException("IntervencaoAnexo " + intervencaoAnexo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IntervencaoAnexo intervencaoAnexo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            intervencaoAnexo = em.merge(intervencaoAnexo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                IntervencaoAnexoPK id = intervencaoAnexo.getIntervencaoAnexoPK();
                if (findIntervencaoAnexo(id) == null) {
                    throw new NonexistentEntityException("The intervencaoAnexo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(IntervencaoAnexoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IntervencaoAnexo intervencaoAnexo;
            try {
                intervencaoAnexo = em.getReference(IntervencaoAnexo.class, id);
                intervencaoAnexo.getIntervencaoAnexoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The intervencaoAnexo with id " + id + " no longer exists.", enfe);
            }
            em.remove(intervencaoAnexo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IntervencaoAnexo> findIntervencaoAnexoEntities() {
        return findIntervencaoAnexoEntities(true, -1, -1);
    }

    public List<IntervencaoAnexo> findIntervencaoAnexoEntities(int maxResults, int firstResult) {
        return findIntervencaoAnexoEntities(false, maxResults, firstResult);
    }

    private List<IntervencaoAnexo> findIntervencaoAnexoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IntervencaoAnexo.class));
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

    public IntervencaoAnexo findIntervencaoAnexo(IntervencaoAnexoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IntervencaoAnexo.class, id);
        } finally {
            em.close();
        }
    }

    public int getIntervencaoAnexoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IntervencaoAnexo> rt = cq.from(IntervencaoAnexo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
