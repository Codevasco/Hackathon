package org.academiadecodigo.bootcamp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericDao<T> implements Dao<T> {

    private Class<T> modelType;

    @PersistenceContext
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public GenericDao(Class<T> modelType) {
        this.modelType = modelType;
    }

    @Override
    public List<T> getAll() {

        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public T getById(Integer id) {

        return em.find(modelType, id);
    }

    @Override
    public T saveOrUpdate(T model) {
        return em.merge(model);
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.find(modelType, id));
    }
}
