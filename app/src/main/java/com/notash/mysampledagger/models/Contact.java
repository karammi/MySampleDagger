package com.notash.mysampledagger.models;

public class Contact {
    private String mail;

    public Contact() {
        this.mail = "no Content";
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void deleteMail(){
        this.mail=null;
    }
}
