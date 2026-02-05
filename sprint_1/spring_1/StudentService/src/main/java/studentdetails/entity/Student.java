package studentdetails.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private Long id;   // MANUAL ID

    private String name;
    private String email;
    private String department;
    private String phone;
    private String placementStatus;

    // No-arg constructor (REQUIRED)
    public Student() {
    }

    // All-arg constructor
    public Student(Long id, String name, String email, String department, String phone, String placementStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.phone = phone;
        this.placementStatus = placementStatus;
    }

    // GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlacementStatus() {
        return placementStatus;
    }

    public void setPlacementStatus(String placementStatus) {
        this.placementStatus = placementStatus;
    }
}