/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.exceptions.NonexistentEntityException;
import db.exceptions.PreexistingEntityException;
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
 * @author iresh
 */
public class BalancingJpaController implements Serializable {

    public BalancingJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Balancing balancing) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(balancing);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBalancing(balancing.getId()) != null) {
                throw new PreexistingEntityException("Balancing " + balancing + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Balancing balancing) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            balancing = em.merge(balancing);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = balancing.getId();
                if (findBalancing(id) == null) {
                    throw new NonexistentEntityException("The balancing with id " + id + " no longer exists.");
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
            Balancing balancing;
            try {
                balancing = em.getReference(Balancing.class, id);
                balancing.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The balancing with id " + id + " no longer exists.", enfe);
            }
            em.remove(balancing);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Balancing> findBalancingEntities() {
        return findBalancingEntities(true, -1, -1);
    }

    public List<Balancing> findBalancingEntities(int maxResults, int firstResult) {
        return findBalancingEntities(false, maxResults, firstResult);
    }

    private List<Balancing> findBalancingEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Balancing.class));
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

    public Balancing findBalancing(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Balancing.class, id);
        } finally {
            em.close();
        }
    }

    public int getBalancingCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Balancing> rt = cq.from(Balancing.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
