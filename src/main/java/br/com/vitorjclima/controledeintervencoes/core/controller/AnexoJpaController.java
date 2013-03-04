/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.core.controller;

import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.NonexistentEntityException;
import br.com.vitorjclima.controledeintervencoes.db.Anexo;
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
public class AnexoJpaController implements Serializable {

    public AnexoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Anexo anexo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(anexo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Anexo anexo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            anexo = em.merge(anexo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = anexo.getAnexoId();
                if (findAnexo(id) == null) {
                    throw new NonexistentEntityException("The anexo with id " + id + " no longer exists.");
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
            Anexo anexo;
            try {
                anexo = em.getReference(Anexo.class, id);
                anexo.getAnexoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The anexo with id " + id + " no longer exists.", enfe);
            }
            em.remove(anexo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Anexo> findAnexoEntities() {
        return findAnexoEntities(true, -1, -1);
    }

    public List<Anexo> findAnexoEntities(int maxResults, int firstResult) {
        return findAnexoEntities(false, maxResults, firstResult);
    }

    private List<Anexo> findAnexoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Anexo.class));
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

    public Anexo findAnexo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Anexo.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnexoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Anexo> rt = cq.from(Anexo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
