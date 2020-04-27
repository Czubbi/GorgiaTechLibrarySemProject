package GTL_API.Models.Entities;

import javax.persistence.*;

@Entity
@Table(name = "LibraryEmployeeType", schema = "dbo", catalog = "dmai0917_1067677")
public class LibraryEmployeeTypeEntity {
    private Integer id;
    private String type;
    private Double hourlyWage;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "hourly_wage", nullable = false, precision = 0)
    public Double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryEmployeeTypeEntity that = (LibraryEmployeeTypeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (hourlyWage != null ? !hourlyWage.equals(that.hourlyWage) : that.hourlyWage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (hourlyWage != null ? hourlyWage.hashCode() : 0);
        return result;
    }
}
