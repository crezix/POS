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
public class LoginDetailsJpaController implements Serializable {

    public LoginDetailsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LoginDetails loginDetails) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(loginDetails);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLoginDetails(loginDetails.getUsername()) != null) {
                throw new PreexistingEntityException("LoginDetails " + loginDetails + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LoginDetails loginDetails) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            loginDetails = em.merge(loginDetails);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = loginDetails.getUsername();
                if (findLoginDetails(id) == null) {
                    throw new NonexistentEntityException("The loginDetails with id " + id + " no longer exists.");
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
            LoginDetails loginDetails;
            try {
                loginDetails = em.getReference(LoginDetails.class, id);
                loginDetails.getUsername();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The loginDetails with id " + id + " no longer exists.", enfe);
            }
            em.remove(loginDetails);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LoginDetails> findLoginDetailsEntities() {
        return findLoginDetailsEntities(true, -1, -1);
    }

    public List<LoginDetails> findLoginDetailsEntities(int maxResults, int firstResult) {
        return findLoginDetailsEntities(false, maxResults, firstResult);
    }

    private List<LoginDetails> findLoginDetailsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LoginDetails.class));
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

    public LoginDetails findLoginDetails(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LoginDetails.class, id);
        } finally {
            em.close();
        }
    }

    public int getLoginDetailsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LoginDetails> rt = cq.from(LoginDetails.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    
}
