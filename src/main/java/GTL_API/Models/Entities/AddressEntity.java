package GTL_API.Models.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Address", schema = "dbo", catalog = "dmai0917_1067677")
public class AddressEntity {
    private int id;
    private String street;
    private String addressNumber;
    private String postcodeId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "street", nullable = false, length = 50)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "address_number", nullable = false, length = 10)
    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    @Basic
    @Column(name = "postcode_id", nullable = false, length = 5)
    public String getPostcodeId() {
        return postcodeId;
    }

    public void setPostcodeId(String postcodeId) {
        this.postcodeId = postcodeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (id != that.id) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (addressNumber != null ? !addressNumber.equals(that.addressNumber) : that.addressNumber != null)
            return false;
        if (postcodeId != null ? !postcodeId.equals(that.postcodeId) : that.postcodeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (addressNumber != null ? addressNumber.hashCode() : 0);
        result = 31 * result + (postcodeId != null ? postcodeId.hashCode() : 0);
        return result;
    }
}
