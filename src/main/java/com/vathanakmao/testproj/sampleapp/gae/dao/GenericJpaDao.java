package com.vathanakmao.testproj.sampleapp.gae.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GenericJpaDao<T, ID extends Serializable> implements GenericDao<T, ID> {
    private final Class<T>      persistentClass;
    private final EntityManager em = EMF.get().createEntityManager();

    public GenericJpaDao() {
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void save(T entity) {
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(entity);
            tx.commit();
        }
        catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public T findById(ID id) {
        T result = null;
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();
            result = em.find(persistentClass, id);
            tx.commit();
        }
        catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
        }

        return result;
    }

    @Override
    public void update(T entity) {
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();
            em.merge(entity);
            tx.commit();
        }
        catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public void delete(T entity) {
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();
            em.remove(entity);
            tx.commit();
        }
        catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

}
