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
package com.apuntesdejava.sales.webadmin.services;

import com.apuntesdejava.sales.model.Category;
import com.apuntesdejava.sales.webadmin.repositories.AbstractRepository;
import com.apuntesdejava.sales.webadmin.repositories.CategoryRepository;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Diego Silva <diego.silva at apuntesdejava.com>
 */
@Stateless
public class CategoryService extends AbstractService<Long, Category> {

    @Inject
    private CategoryRepository categoryRepository;

    @Override
    protected AbstractRepository<Long, Category> getRepository() {
        return categoryRepository;
    }

}
