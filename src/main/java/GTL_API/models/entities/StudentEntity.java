package GTL_API.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "Student", schema = "dbo", catalog = "dmai0917_1067677")
public class StudentEntity {
    private int studentId;
    private int studentTypeId;
    private int deadlinesMissed;
    private double gpa;

    @Id
    @Column(name = "student_id", nullable = false)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "student_type_id", nullable = false)
    public int getStudentTypeId() {
        return studentTypeId;
    }

    public void setStudentTypeId(int studentTypeId) {
        this.studentTypeId = studentTypeId;
    }

    @Basic
    @Column(name = "deadlines_missed", nullable = false)
    public int getDeadlinesMissed() {
        return deadlinesMissed;
    }

    public void setDeadlinesMissed(int deadlinesMissed) {
        this.deadlinesMissed = deadlinesMissed;
    }

    @Basic
    @Column(name = "gpa", nullable = false, precision = 0)
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (studentId != that.studentId) return false;
        if (studentTypeId != that.studentTypeId) return false;
        if (deadlinesMissed != that.deadlinesMissed) return false;
        if (Double.compare(that.gpa, gpa) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = studentId;
        result = 31 * result + studentTypeId;
        result = 31 * result + deadlinesMissed;
        temp = Double.doubleToLongBits(gpa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
