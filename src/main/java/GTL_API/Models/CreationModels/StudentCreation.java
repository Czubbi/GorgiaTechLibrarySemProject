package GTL_API.Models.CreationModels;

public class StudentCreation {

    private String coverType;
    private int studentTypeId;
    private int deadlinesMissed;
    private double gpa;

    public int getStudentTypeId() {
        return studentTypeId;
    }

    public void setStudentTypeId(int studentTypeId) {
        this.studentTypeId = studentTypeId;
    }

    public int getDeadlinesMissed() {
        return deadlinesMissed;
    }

    public void setDeadlinesMissed(int deadlinesMissed) {
        this.deadlinesMissed = deadlinesMissed;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }



}
