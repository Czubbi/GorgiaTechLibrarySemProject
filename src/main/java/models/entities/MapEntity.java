package models.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Map", schema = "dbo", catalog = "dmai0917_1067677")
public class MapEntity {
    private String barcode;
    private Date addedDate;

    @Id
    @Column(name = "barcode", nullable = false, length = 12)
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Basic
    @Column(name = "added_date", nullable = false)
    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapEntity mapEntity = (MapEntity) o;

        if (barcode != null ? !barcode.equals(mapEntity.barcode) : mapEntity.barcode != null) return false;
        if (addedDate != null ? !addedDate.equals(mapEntity.addedDate) : mapEntity.addedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = barcode != null ? barcode.hashCode() : 0;
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        return result;
    }
}
