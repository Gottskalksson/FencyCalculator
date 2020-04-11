package uk.co.breschbrothers.daos;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public abstract class BaseDao<T> {

    private Class<T> clazz;

    public BaseDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @PersistenceContext
    EntityManager entityManager;

    public void save(T t) {
        entityManager.persist(t);
    }

    public T findById(long id) {
        return entityManager.find(clazz, id);
    }

    public void update (T t) {
        entityManager.merge(t);
    }

    public void delete (T t) {
        entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
    }

}
