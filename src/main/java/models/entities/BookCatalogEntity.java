package models.entities;

import javax.persistence.*;

@Entity
@Table(name = "BookCatalog", schema = "dbo", catalog = "dmai0917_1067677")
public class BookCatalogEntity {
    private int id;
    private String isbn;
    private int bookConditionId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "isbn", nullable = false, length = 13)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "book_condition_id", nullable = false)
    public int getBookConditionId() {
        return bookConditionId;
    }

    public void setBookConditionId(int bookConditionId) {
        this.bookConditionId = bookConditionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookCatalogEntity that = (BookCatalogEntity) o;

        if (id != that.id) return false;
        if (bookConditionId != that.bookConditionId) return false;
        if (isbn != null ? !isbn.equals(that.isbn) : that.isbn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + bookConditionId;
        return result;
    }
}
