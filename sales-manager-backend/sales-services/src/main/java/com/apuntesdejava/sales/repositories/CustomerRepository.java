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
package com.apuntesdejava.sales.repositories;

import com.apuntesdejava.sales.model.CustomerPerson;
import com.apuntesdejava.sales.model.PersonId;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author diego
 */
@ApplicationScoped
public class CustomerRepository extends AbstractRepository<PersonId, CustomerPerson> {

    @Inject
    private EntityManager em;

    public CustomerRepository() {
        super(CustomerPerson.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
