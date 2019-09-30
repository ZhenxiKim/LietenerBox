package com.example.lietenerbox.model.dto.request;

public class PersonSignupRequestDto {
    private String PersonId;
    private String PersonPassword;
    private String PersonName;
    private String email;

    public String getPersonId() {
        return PersonId;
    }

    public void setPersonId(String PersonId) {
        this.PersonId = PersonId;
    }

    public String getPersonPassword() {
        return PersonPassword;
    }

    public void setPersonPassword(String PersonPassword) {
        this.PersonPassword = PersonPassword;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String PersonName) {
        this.PersonName = PersonName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
