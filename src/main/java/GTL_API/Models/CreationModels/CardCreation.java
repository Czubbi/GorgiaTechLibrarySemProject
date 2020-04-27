package GTL_API.Models.CreationModels;

import java.sql.Date;

public class CardCreation {
    private Integer number;
    private Date expirationDate;
    private String picture;
    private Integer libraryEmployeeId;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getLibraryEmployeeId() {
        return libraryEmployeeId;
    }

    public void setLibraryEmployeeId(Integer libraryEmployeeId) {
        this.libraryEmployeeId = libraryEmployeeId;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
