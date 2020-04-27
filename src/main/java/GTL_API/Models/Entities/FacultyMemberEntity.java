package GTL_API.Models.Entities;

import javax.persistence.*;

@Entity
@Table(name = "FacultyMember", schema = "dbo", catalog = "dmai0917_1067677")
public class FacultyMemberEntity {
    private int facultyMemberId;
    private int facultyMemberTypeId;

    @Id
    @Column(name = "faculty_member_id", nullable = false)
    public int getFacultyMemberId() {
        return facultyMemberId;
    }

    public void setFacultyMemberId(int facultyMemberId) {
        this.facultyMemberId = facultyMemberId;
    }

    @Basic
    @Column(name = "faculty_member_type_id", nullable = false)
    public int getFacultyMemberTypeId() {
        return facultyMemberTypeId;
    }

    public void setFacultyMemberTypeId(int facultyMemberTypeId) {
        this.facultyMemberTypeId = facultyMemberTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacultyMemberEntity that = (FacultyMemberEntity) o;

        if (facultyMemberId != that.facultyMemberId) return false;
        return facultyMemberTypeId == that.facultyMemberTypeId;
    }

    @Override
    public int hashCode() {
        int result = facultyMemberId;
        result = 31 * result + facultyMemberTypeId;
        return result;
    }
}
