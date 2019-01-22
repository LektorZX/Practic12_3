package spring.dao;

import spring.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseDao<P extends Serializable, E extends BaseEntity<P>> {

    P save(E entity);

    Optional<E> find(P id);

    void delete(E entity);

    void update(E entity);

    List<E> findAll();
}
