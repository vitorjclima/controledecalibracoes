/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.core.controller;

import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.NonexistentEntityException;
import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.PreexistingEntityException;
import br.com.vitorjclima.controledeintervencoes.db.EquipamentoAnexo;
import br.com.vitorjclima.controledeintervencoes.db.EquipamentoAnexoPK;
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
public class EquipamentoAnexoJpaController implements Serializable {

    public EquipamentoAnexoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EquipamentoAnexo equipamentoAnexo) throws PreexistingEntityException, Exception {
        if (equipamentoAnexo.getEquipamentoAnexoPK() == null) {
            equipamentoAnexo.setEquipamentoAnexoPK(new EquipamentoAnexoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(equipamentoAnexo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEquipamentoAnexo(equipamentoAnexo.getEquipamentoAnexoPK()) != null) {
                throw new PreexistingEntityException("EquipamentoAnexo " + equipamentoAnexo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EquipamentoAnexo equipamentoAnexo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            equipamentoAnexo = em.merge(equipamentoAnexo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                EquipamentoAnexoPK id = equipamentoAnexo.getEquipamentoAnexoPK();
                if (findEquipamentoAnexo(id) == null) {
                    throw new NonexistentEntityException("The equipamentoAnexo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(EquipamentoAnexoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EquipamentoAnexo equipamentoAnexo;
            try {
                equipamentoAnexo = em.getReference(EquipamentoAnexo.class, id);
                equipamentoAnexo.getEquipamentoAnexoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The equipamentoAnexo with id " + id + " no longer exists.", enfe);
            }
            em.remove(equipamentoAnexo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EquipamentoAnexo> findEquipamentoAnexoEntities() {
        return findEquipamentoAnexoEntities(true, -1, -1);
    }

    public List<EquipamentoAnexo> findEquipamentoAnexoEntities(int maxResults, int firstResult) {
        return findEquipamentoAnexoEntities(false, maxResults, firstResult);
    }

    private List<EquipamentoAnexo> findEquipamentoAnexoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EquipamentoAnexo.class));
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

    public EquipamentoAnexo findEquipamentoAnexo(EquipamentoAnexoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EquipamentoAnexo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEquipamentoAnexoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EquipamentoAnexo> rt = cq.from(EquipamentoAnexo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
