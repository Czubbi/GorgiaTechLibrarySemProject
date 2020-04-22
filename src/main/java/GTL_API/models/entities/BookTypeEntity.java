package GTL_API.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "BookType", schema = "dbo", catalog = "dmai0917_1067677")
public class BookTypeEntity {
    private int id;
    private String bookType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "book_type", nullable = false, length = 30)
    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookTypeEntity that = (BookTypeEntity) o;

        if (id != that.id) return false;
        if (bookType != null ? !bookType.equals(that.bookType) : that.bookType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bookType != null ? bookType.hashCode() : 0);
        return result;
    }
}
