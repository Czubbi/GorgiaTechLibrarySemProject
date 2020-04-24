package GTL_API.Models.Entities;

import javax.persistence.*;

@Entity
@Table(name = "CoverType", schema = "dbo", catalog = "dmai0917_1067677")
public class CoverTypeEntity {
    private int id;
    private String coverType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cover_type", nullable = false, length = 30)
    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoverTypeEntity that = (CoverTypeEntity) o;

        if (id != that.id) return false;
        if (coverType != null ? !coverType.equals(that.coverType) : that.coverType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (coverType != null ? coverType.hashCode() : 0);
        return result;
    }
}