package GTL_API.models.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "BookReturn", schema = "dbo", catalog = "dmai0917_1067677")
public class BookReturnEntity {
    private int id;
    private Date returnedDate;
    private Date estimatedReturnDate;
    private double payment;
    private boolean status;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "returned_date", nullable = true)
    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    @Basic
    @Column(name = "estimated_return_date", nullable = false)
    public Date getEstimatedReturnDate() {
        return estimatedReturnDate;
    }

    public void setEstimatedReturnDate(Date estimatedReturnDate) {
        this.estimatedReturnDate = estimatedReturnDate;
    }

    @Basic
    @Column(name = "payment", nullable = false, precision = 0)
    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookReturnEntity that = (BookReturnEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.payment, payment) != 0) return false;
        if (status != that.status) return false;
        if (returnedDate != null ? !returnedDate.equals(that.returnedDate) : that.returnedDate != null) return false;
        if (estimatedReturnDate != null ? !estimatedReturnDate.equals(that.estimatedReturnDate) : that.estimatedReturnDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (returnedDate != null ? returnedDate.hashCode() : 0);
        result = 31 * result + (estimatedReturnDate != null ? estimatedReturnDate.hashCode() : 0);
        temp = Double.doubleToLongBits(payment);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (status ? 1 : 0);
        return result;
    }
}
