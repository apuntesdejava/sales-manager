/*
 * Copyright 2021 Diego Silva <diego.silva at apuntesdejava.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.apuntesdejava.sales.webadmin.repositories;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

/**
 *
 * @author Diego Silva <diego.silva at apuntesdejava.com>
 * @param <K> Key class
 * @param <E> Entity class
 */
public abstract class AbstractRepository<K, E> {

    protected abstract EntityManager getEntityManager();

    private final Class<E> clazz;

    private List<String> orderBy;

    protected AbstractRepository(Class<E> clazz) {
        this.clazz = clazz;
    }

    protected AbstractRepository(Class<E> clazz, String... fields) {
        this(clazz);
        if (fields != null && fields.length > 0) {
            orderBy = Arrays.asList(fields);
        }
    }

    public Optional<E> findById(K id) {
        return Optional.ofNullable(
                getEntityManager().find(clazz, id)
        );
    }

    @Transactional
    public E persist(E model) {
        getEntityManager().persist(model);
        return model;
    }

    @Transactional
    public boolean deleteById(K id) {
        Optional<E> model = findById(id);
        if (model.isPresent()) {
            getEntityManager().remove(model.get());
        }
        return false;
    }

    public List<E> listAll() {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(clazz);
        Root<E> model = cq.from(clazz);
        cq.select(model);
        if (orderBy != null && !orderBy.isEmpty()) {
            cq.orderBy(orderBy
                    .stream()
                    .map(field -> cb.asc(model.get(field)))
                    .collect(Collectors.toList())
            );
        }
        return em.createQuery(cq).getResultList();
    }
}
