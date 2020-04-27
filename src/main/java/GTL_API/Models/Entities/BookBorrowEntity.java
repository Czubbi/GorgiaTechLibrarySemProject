package GTL_API.Models.Entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "BookBorrow", schema = "dbo", catalog = "dmai0917_1067677")
public class BookBorrowEntity {
    private int id;
    private int bookCatalogId;
    private String ssn;
    private Date borrowDate;
    private int bookReturnId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "book_catalog_id", nullable = false)
    public int getBookCatalogId() {
        return bookCatalogId;
    }

    public void setBookCatalogId(int bookCatalogId) {
        this.bookCatalogId = bookCatalogId;
    }

    @Basic
    @Column(name = "ssn", nullable = false, length = 11)
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Basic
    @Column(name = "borrow_date", nullable = false)
    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    @Basic
    @Column(name = "book_return_id", nullable = false)
    public int getBookReturnId() {
        return bookReturnId;
    }

    public void setBookReturnId(int bookReturnId) {
        this.bookReturnId = bookReturnId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookBorrowEntity that = (BookBorrowEntity) o;

        if (id != that.id) return false;
        if (bookCatalogId != that.bookCatalogId) return false;
        if (bookReturnId != that.bookReturnId) return false;
        if (ssn != null ? !ssn.equals(that.ssn) : that.ssn != null) return false;
        return borrowDate != null ? borrowDate.equals(that.borrowDate) : that.borrowDate == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bookCatalogId;
        result = 31 * result + (ssn != null ? ssn.hashCode() : 0);
        result = 31 * result + (borrowDate != null ? borrowDate.hashCode() : 0);
        result = 31 * result + bookReturnId;
        return result;
    }
}
