package com.main.sqlcrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "teachers")
public class Teachers {

    @Id
    @Column(insertable = true, updatable = true, unique = true, nullable = false)
    @Size(min = 9, max = 11)
    private String nic;

    @NotBlank
    @Size(min = 3, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 50)
    private String address;

    @NotNull
    private Long telephoneNumber;

    @NotBlank
    private String status;

    @NotBlank
    private String gender;//active,past,unenrolled

   
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_class", joinColumns = @JoinColumn(name = "teacher_nic", referencedColumnName = "nic"), inverseJoinColumns = @JoinColumn(name = "class_id", referencedColumnName = "id"))
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private SClass currentClass;

    public Teachers() {
    }

    
    public Teachers(@Size(min = 9, max = 11) String nic, @NotBlank @Size(min = 3, max = 50) String firstName,
            @NotBlank @Size(min = 3, max = 50) String lastName, @NotBlank @Size(min = 3, max = 50) String address,
            @NotNull Long telephoneNumber, @NotBlank String status, @NotBlank String gender,
            @NotNull SClass currentClass) {
        this.nic = nic;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.status = status;
        this.gender = gender;
        this.currentClass = currentClass;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SClass getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(SClass currentClass) {
        this.currentClass = currentClass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Teachers [address=" + address + ", currentClass=" + currentClass + ", firstName=" + firstName
                + ", gender=" + gender + ", lastName=" + lastName + ", nic=" + nic + ", status=" + status
                + ", telephoneNumber=" + telephoneNumber + "]";
    }

    


    

}