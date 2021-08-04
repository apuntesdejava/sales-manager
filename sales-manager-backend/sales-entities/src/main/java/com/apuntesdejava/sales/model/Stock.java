package com.apuntesdejava.sales.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Diego Silva <diego.silva at apuntesdejava.com>
 */
@Getter
@Setter
@Entity
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "stock_id")
    private long id;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    @JoinColumn(name = "storehouse_id")
    @ManyToOne
    private Storehouse storehouse;

    private double price;

    private double count;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stock other = (Stock) obj;
        return this.id == other.id;
    }

}
