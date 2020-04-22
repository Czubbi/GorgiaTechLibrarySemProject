package GTL_API.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "LibraryEmployeeType", schema = "dbo", catalog = "dmai0917_1067677")
public class LibraryEmployeeTypeEntity {
    private int id;
    private String type;
    private double hourlyWage;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryEmployeeTypeEntity that = (LibraryEmployeeTypeEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.hourlyWage, hourlyWage) != 0) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(hourlyWage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
