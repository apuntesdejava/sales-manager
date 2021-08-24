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
package com.apuntesdejava.sales.services;

import com.apuntesdejava.sales.repositories.AbstractRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Diego Silva <diego.silva at apuntesdejava.com>
 * @param <K> Key class
 * @param <E> Entity class
 */
public abstract class AbstractService<K, E> {

    protected abstract AbstractRepository<K, E> getRepository();

    public List<E> listAll() {
        return getRepository().listAll();
    }

    public E create(E model) {
        return getRepository().persist(model);
    }

    public boolean deleteById(K key) {
        return getRepository().deleteById(key);
    }

    public Optional<E> findById(K key) {
        return getRepository().findById(key);
    }

    public Optional<E> update(K key, E model) {
        return getRepository().update(key, model);
    }

}
