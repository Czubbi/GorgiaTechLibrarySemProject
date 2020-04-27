package GTL_API.Models.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Person", schema = "dbo", catalog = "dmai0917_1067677")
public class PersonEntity {
    private String ssn;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer homeAddressId;
    private Integer campusAddressId;
    private Integer loanDuration;
    private Integer cardNumberId;
    private Integer personTypeId;

    @Id
    @Column(name = "ssn", nullable = false, length = 11)
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 30)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "middle_name", nullable = true, length = 30)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 30)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "home_address_id", nullable = false)
    public Integer getHomeAddressId() {
        return homeAddressId;
    }

    public void setHomeAddressId(Integer homeAddressId) {
        this.homeAddressId = homeAddressId;
    }

    @Basic
    @Column(name = "campus_address_id", nullable = false)
    public Integer getCampusAddressId() {
        return campusAddressId;
    }

    public void setCampusAddressId(Integer campusAddressId) {
        this.campusAddressId = campusAddressId;
    }

    @Basic
    @Column(name = "loan_duration", nullable = false)
    public Integer getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(Integer loanDuration) {
        this.loanDuration = loanDuration;
    }

    @Basic
    @Column(name = "card_number_id", nullable = false)
    public Integer getCardNumberId() {
        return cardNumberId;
    }

    public void setCardNumberId(Integer cardNumberId) {
        this.cardNumberId = cardNumberId;
    }

    @Basic
    @Column(name = "person_type_id", nullable = false)
    public Integer getPersonTypeId() {
        return personTypeId;
    }

    public void setPersonTypeId(Integer personTypeId) {
        this.personTypeId = personTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity that = (PersonEntity) o;

        if (homeAddressId != that.homeAddressId) return false;
        if (campusAddressId != that.campusAddressId) return false;
        if (loanDuration != that.loanDuration) return false;
        if (cardNumberId != that.cardNumberId) return false;
        if (personTypeId != that.personTypeId) return false;
        if (ssn != null ? !ssn.equals(that.ssn) : that.ssn != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ssn != null ? ssn.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + homeAddressId;
        result = 31 * result + campusAddressId;
        result = 31 * result + loanDuration;
        result = 31 * result + cardNumberId;
        result = 31 * result + personTypeId;
        return result;
    }
}
