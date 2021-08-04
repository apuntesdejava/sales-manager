package com.apuntesdejava.sales.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Diego Silva <diego.silva at apuntesdejava.com>
 */
@Entity
@Table(name = "measurement_convert")
@Getter
@Setter
public class MeasurementConvert implements Serializable {

    @EmbeddedId
    private MeasurementConvertId id;

    @ManyToOne
    @JoinColumn(
            name = "unit_source",
            referencedColumnName = "measurement_id",
            insertable = false,
            updatable = false
    )
    private MeasurementUnit source;

    @ManyToOne
    @JoinColumn(
            name = "unit_target",
            referencedColumnName = "measurement_id",
            insertable = false,
            updatable = false
    )
    private MeasurementUnit target;

    @Column(name = "convert_value")
    private double convert;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final MeasurementConvert other = (MeasurementConvert) obj;
        return Objects.equals(this.id, other.id);
    }

}
