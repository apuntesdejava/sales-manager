package com.apuntesdejava.sales.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Diego Silva <diego.silva at apuntesdejava.com>
 */
@Getter
@Setter
@Entity
public class Storehouse implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "storehouse_id")
    private long id;

    @Column(length = 50)
    private String name;

    private double latitude;

    private double longitude;

    private String address;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Storehouse other = (Storehouse) obj;
        return this.id == other.id;
    }

}
