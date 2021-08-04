package com.apuntesdejava.sales.webadmin.repositories;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diego Silva <diego.silva at apuntesdejava.com>
 */
@ApplicationScoped
public class JpaProvider {

    @Produces
    @PersistenceContext(unitName = "salesPU")
    private EntityManager em;
}
