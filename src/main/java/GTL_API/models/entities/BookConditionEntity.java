package GTL_API.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "BookCondition", schema = "dbo", catalog = "dmai0917_1067677")
public class BookConditionEntity {
    private int id;
    private String bookCondition;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "book_condition", nullable = false, length = 20)
    public String getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(String bookCondition) {
        this.bookCondition = bookCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookConditionEntity that = (BookConditionEntity) o;

        if (id != that.id) return false;
        if (bookCondition != null ? !bookCondition.equals(that.bookCondition) : that.bookCondition != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bookCondition != null ? bookCondition.hashCode() : 0);
        return result;
    }
}
