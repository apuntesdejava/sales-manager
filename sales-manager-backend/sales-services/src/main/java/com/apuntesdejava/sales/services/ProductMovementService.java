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
package com.apuntesdejava.sales.services;

import com.apuntesdejava.sales.model.Product;
import com.apuntesdejava.sales.model.ProductMovement;
import com.apuntesdejava.sales.model.Stock;
import com.apuntesdejava.sales.model.Storehouse;
import com.apuntesdejava.sales.model.type.ProductTypeMovement;
import com.apuntesdejava.sales.repositories.ProductMovementRepository;
import com.apuntesdejava.sales.repositories.StockRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author diego
 */
@Stateless
public class ProductMovementService extends AbstractService<Long, ProductMovement> {

    @Inject
    private StockRepository stockRepository;

    @Inject
    private ProductMovementRepository repository;

    @Override
    protected ProductMovementRepository getRepository() {
        return repository;
    }

    public ProductMovement create(Product product, double count, ProductTypeMovement type, double unitPrice, Storehouse storeHouse,String comment) {
        ProductMovement movement = repository.persist(new ProductMovement(product, count, type, unitPrice, storeHouse, comment));
        Optional<Stock> stockOpt = stockRepository.findByProductPrice(product, unitPrice, storeHouse);
        if (stockOpt.isPresent()) {
            Stock stock = stockOpt.get();
            stock.setCount(stock.getCount() + (count * (type == ProductTypeMovement.INCOMING ? 1 : -1)));
            stock.setLastUpdate(LocalDateTime.now());
            stock.setPrice(unitPrice);
            stockRepository.update(stock.getId(), stock);
        } else {
            stockRepository.persist(new Stock(product, storeHouse, count, unitPrice));
        }
        return movement;
    }

}
