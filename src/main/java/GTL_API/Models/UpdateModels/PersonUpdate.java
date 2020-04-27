package GTL_API.Models.UpdateModels;

public class PersonUpdate {
    private String ssn;
    private String firstName;
    private String middleName;
    private String lastName;
    private Integer homeAddressId;
    private Integer campusAddressId;
    private Integer loanDuration;
    private Integer cardNumberId;
    private Integer personTypeId;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getHomeAddressId() {
        return homeAddressId;
    }

    public void setHomeAddressId(Integer homeAddressId) {
        this.homeAddressId = homeAddressId;
    }

    public Integer getCampusAddressId() {
        return campusAddressId;
    }

    public void setCampusAddressId(Integer campusAddressId) {
        this.campusAddressId = campusAddressId;
    }

    public Integer getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(Integer loanDuration) {
        this.loanDuration = loanDuration;
    }

    public Integer getCardNumberId() {
        return cardNumberId;
    }

    public void setCardNumberId(Integer cardNumberId) {
        this.cardNumberId = cardNumberId;
    }

    public Integer getPersonTypeId() {
        return personTypeId;
    }

    public void setPersonTypeId(Integer personTypeId) {
        this.personTypeId = personTypeId;
    }

}
