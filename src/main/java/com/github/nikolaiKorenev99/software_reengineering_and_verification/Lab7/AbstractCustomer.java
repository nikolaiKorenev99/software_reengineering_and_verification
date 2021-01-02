package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab7;

public abstract class AbstractCustomer {
    private String name;
    private String surname;
    private String email;


    public AbstractCustomer(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public AbstractCustomer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getFullName() {
        return name + " " + surname + " ";
    }

}
