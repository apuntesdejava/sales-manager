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

import com.apuntesdejava.sales.model.Product;
import com.apuntesdejava.sales.model.ProductMovement;
import com.apuntesdejava.sales.model.ProductMovement_;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author diego
 */
@ApplicationScoped
public class ProductMovementRepository extends AbstractRepository<Long, ProductMovement> {

    @Inject
    private EntityManager em;

    public ProductMovementRepository() {
        super(ProductMovement.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<ProductMovement> listByProduct(Product p) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductMovement> cq = cb.createQuery(ProductMovement.class);
        Root<ProductMovement> model = cq.from(ProductMovement.class);
        cq.select(model).distinct(true)
                .where(cb.equal(model.get(ProductMovement_.product), p))
                .orderBy(cb.asc(model.get(ProductMovement_.date)));
        return em.createQuery(cq).getResultList();
    }

}
