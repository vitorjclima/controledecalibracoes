/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.core.controller;

import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.NonexistentEntityException;
import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.PreexistingEntityException;
import br.com.vitorjclima.controledeintervencoes.db.SistemaMedicao;
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
public class SistemaMedicaoJpaController implements Serializable {

    public SistemaMedicaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public SistemaMedicaoJpaController() {
        this.createEntityManagerFactory();
    }
    
     private void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("ControleDeIntervencoesUP");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SistemaMedicao sistemaMedicao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sistemaMedicao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSistemaMedicao(sistemaMedicao.getSistemaMedicaoId()) != null) {
                throw new PreexistingEntityException("SistemaMedicao " + sistemaMedicao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SistemaMedicao sistemaMedicao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sistemaMedicao = em.merge(sistemaMedicao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = sistemaMedicao.getSistemaMedicaoId();
                if (findSistemaMedicao(id) == null) {
                    throw new NonexistentEntityException("The sistemaMedicao with id " + id + " no longer exists.");
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
            SistemaMedicao sistemaMedicao;
            try {
                sistemaMedicao = em.getReference(SistemaMedicao.class, id);
                sistemaMedicao.getSistemaMedicaoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sistemaMedicao with id " + id + " no longer exists.", enfe);
            }
            em.remove(sistemaMedicao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SistemaMedicao> findSistemaMedicaoEntities() {
        return findSistemaMedicaoEntities(true, -1, -1);
    }

    public List<SistemaMedicao> findSistemaMedicaoEntities(int maxResults, int firstResult) {
        return findSistemaMedicaoEntities(false, maxResults, firstResult);
    }

    private List<SistemaMedicao> findSistemaMedicaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SistemaMedicao.class));
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

    public SistemaMedicao findSistemaMedicao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SistemaMedicao.class, id);
        } finally {
            em.close();
        }
    }

    public int getSistemaMedicaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SistemaMedicao> rt = cq.from(SistemaMedicao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
