package GTL_API.Models.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "LibraryEmployee", schema = "dbo", catalog = "dmai0917_1067677")
public class LibraryEmployeeEntity {
    private int employeeId;
    private int libraryEmployeeTypeId;
    private double weeklyHours;
    private Date hireDate;

    @Id
    @Column(name = "employee_id", nullable = false)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "library_employee_type_id", nullable = false)
    public int getLibraryEmployeeTypeId() {
        return libraryEmployeeTypeId;
    }

    public void setLibraryEmployeeTypeId(int libraryEmployeeTypeId) {
        this.libraryEmployeeTypeId = libraryEmployeeTypeId;
    }

    @Basic
    @Column(name = "weekly_hours", nullable = false, precision = 0)
    public double getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(double weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    @Basic
    @Column(name = "hire_date", nullable = false)
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryEmployeeEntity that = (LibraryEmployeeEntity) o;

        if (employeeId != that.employeeId) return false;
        if (libraryEmployeeTypeId != that.libraryEmployeeTypeId) return false;
        if (Double.compare(that.weeklyHours, weeklyHours) != 0) return false;
        if (hireDate != null ? !hireDate.equals(that.hireDate) : that.hireDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = employeeId;
        result = 31 * result + libraryEmployeeTypeId;
        temp = Double.doubleToLongBits(weeklyHours);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        return result;
    }
}
