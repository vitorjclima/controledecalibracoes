/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.core.controller;

import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.NonexistentEntityException;
import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.PreexistingEntityException;
import br.com.vitorjclima.controledeintervencoes.db.EmpresaAnexo;
import br.com.vitorjclima.controledeintervencoes.db.EmpresaAnexoPK;
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
public class EmpresaAnexoJpaController implements Serializable {

    public EmpresaAnexoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EmpresaAnexo empresaAnexo) throws PreexistingEntityException, Exception {
        if (empresaAnexo.getEmpresaAnexoPK() == null) {
            empresaAnexo.setEmpresaAnexoPK(new EmpresaAnexoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(empresaAnexo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpresaAnexo(empresaAnexo.getEmpresaAnexoPK()) != null) {
                throw new PreexistingEntityException("EmpresaAnexo " + empresaAnexo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EmpresaAnexo empresaAnexo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            empresaAnexo = em.merge(empresaAnexo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                EmpresaAnexoPK id = empresaAnexo.getEmpresaAnexoPK();
                if (findEmpresaAnexo(id) == null) {
                    throw new NonexistentEntityException("The empresaAnexo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(EmpresaAnexoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmpresaAnexo empresaAnexo;
            try {
                empresaAnexo = em.getReference(EmpresaAnexo.class, id);
                empresaAnexo.getEmpresaAnexoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresaAnexo with id " + id + " no longer exists.", enfe);
            }
            em.remove(empresaAnexo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EmpresaAnexo> findEmpresaAnexoEntities() {
        return findEmpresaAnexoEntities(true, -1, -1);
    }

    public List<EmpresaAnexo> findEmpresaAnexoEntities(int maxResults, int firstResult) {
        return findEmpresaAnexoEntities(false, maxResults, firstResult);
    }

    private List<EmpresaAnexo> findEmpresaAnexoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EmpresaAnexo.class));
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

    public EmpresaAnexo findEmpresaAnexo(EmpresaAnexoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmpresaAnexo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresaAnexoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EmpresaAnexo> rt = cq.from(EmpresaAnexo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
