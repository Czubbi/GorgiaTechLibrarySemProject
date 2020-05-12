package GTL_API.Models.CreationModels;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class BookReturnCreation {
    private Double payment;
    private Boolean status;
    private Date estimatedReturnDate;
    @NotNull(message = "ID of a book catalog must be set")
    private Integer catalogId;

    public Integer getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public Date getEstimatedReturnDate() {
        return estimatedReturnDate;
    }

    public void setEstimatedReturnDate(Date estimatedReturnDate) {
        this.estimatedReturnDate = estimatedReturnDate;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
