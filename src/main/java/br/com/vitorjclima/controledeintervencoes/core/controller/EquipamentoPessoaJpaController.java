/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vitorjclima.controledeintervencoes.core.controller;

import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.NonexistentEntityException;
import br.com.vitorjclima.controledeintervencoes.core.controller.exceptions.PreexistingEntityException;
import br.com.vitorjclima.controledeintervencoes.db.EquipamentoPessoa;
import br.com.vitorjclima.controledeintervencoes.db.EquipamentoPessoaPK;
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
public class EquipamentoPessoaJpaController implements Serializable {

    public EquipamentoPessoaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EquipamentoPessoa equipamentoPessoa) throws PreexistingEntityException, Exception {
        if (equipamentoPessoa.getEquipamentoPessoaPK() == null) {
            equipamentoPessoa.setEquipamentoPessoaPK(new EquipamentoPessoaPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(equipamentoPessoa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEquipamentoPessoa(equipamentoPessoa.getEquipamentoPessoaPK()) != null) {
                throw new PreexistingEntityException("EquipamentoPessoa " + equipamentoPessoa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EquipamentoPessoa equipamentoPessoa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            equipamentoPessoa = em.merge(equipamentoPessoa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                EquipamentoPessoaPK id = equipamentoPessoa.getEquipamentoPessoaPK();
                if (findEquipamentoPessoa(id) == null) {
                    throw new NonexistentEntityException("The equipamentoPessoa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(EquipamentoPessoaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EquipamentoPessoa equipamentoPessoa;
            try {
                equipamentoPessoa = em.getReference(EquipamentoPessoa.class, id);
                equipamentoPessoa.getEquipamentoPessoaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The equipamentoPessoa with id " + id + " no longer exists.", enfe);
            }
            em.remove(equipamentoPessoa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EquipamentoPessoa> findEquipamentoPessoaEntities() {
        return findEquipamentoPessoaEntities(true, -1, -1);
    }

    public List<EquipamentoPessoa> findEquipamentoPessoaEntities(int maxResults, int firstResult) {
        return findEquipamentoPessoaEntities(false, maxResults, firstResult);
    }

    private List<EquipamentoPessoa> findEquipamentoPessoaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EquipamentoPessoa.class));
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

    public EquipamentoPessoa findEquipamentoPessoa(EquipamentoPessoaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EquipamentoPessoa.class, id);
        } finally {
            em.close();
        }
    }

    public int getEquipamentoPessoaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EquipamentoPessoa> rt = cq.from(EquipamentoPessoa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
