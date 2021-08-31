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

import com.apuntesdejava.sales.model.MeasurementUnit;
import com.apuntesdejava.sales.model.MeasurementUnit_;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author diego
 */
@ApplicationScoped
public class MeasurementUnitRepository extends AbstractRepository<String, MeasurementUnit> {

    @Inject
    private EntityManager em;

    public MeasurementUnitRepository() {
        super(MeasurementUnit.class, MeasurementUnit_.name.getName());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
