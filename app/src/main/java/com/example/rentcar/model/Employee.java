package com.example.rentcar.model;

public class Employee {
    private int id;
    private String fullName;
    private String identityCard;
    private String telephone;
    private String address;
    private String username;
    private String password;

    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
