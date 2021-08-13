/*
 * Copyright 2021 diego.
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
package com.apuntesdejava.sales.webadmin.services;

import com.apuntesdejava.sales.model.Category;
import com.apuntesdejava.sales.model.Product;
import com.apuntesdejava.sales.webadmin.repositories.AbstractRepository;
import com.apuntesdejava.sales.webadmin.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author diego
 */
@Stateless
public class ProductService extends AbstractService<Long, Product> {

    @Inject
    private ProductRepository repository;

    @Override
    protected AbstractRepository<Long, Product> getRepository() {
        return repository;
    }

    public List<Product> listByCategory(Category category) {
        return repository.listByCategory(Optional.ofNullable(category));
    }
}
