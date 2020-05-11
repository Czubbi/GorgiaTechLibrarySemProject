package GTL_API.Models.CreationModels;


import javax.validation.constraints.NotNull;

public class BookBorrowCreation {
    @NotNull
    private Integer bookCatalogId;

    private String ssn;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Integer getBookCatalogId() {
        return bookCatalogId;
    }

    public void setBookCatalogId(Integer bookCatalogId) {
        this.bookCatalogId = bookCatalogId;
    }

}
