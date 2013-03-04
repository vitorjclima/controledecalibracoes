/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.core.controller;

import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.NonexistentEntityException;
import br.com.vitorjclima.controledeintervencoes.db.Frequencia;
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
public class FrequenciaJpaController implements Serializable {

    public FrequenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Frequencia frequencia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(frequencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Frequencia frequencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            frequencia = em.merge(frequencia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = frequencia.getFrequenciaId();
                if (findFrequencia(id) == null) {
                    throw new NonexistentEntityException("The frequencia with id " + id + " no longer exists.");
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
            Frequencia frequencia;
            try {
                frequencia = em.getReference(Frequencia.class, id);
                frequencia.getFrequenciaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The frequencia with id " + id + " no longer exists.", enfe);
            }
            em.remove(frequencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Frequencia> findFrequenciaEntities() {
        return findFrequenciaEntities(true, -1, -1);
    }

    public List<Frequencia> findFrequenciaEntities(int maxResults, int firstResult) {
        return findFrequenciaEntities(false, maxResults, firstResult);
    }

    private List<Frequencia> findFrequenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Frequencia.class));
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

    public Frequencia findFrequencia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Frequencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getFrequenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Frequencia> rt = cq.from(Frequencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
