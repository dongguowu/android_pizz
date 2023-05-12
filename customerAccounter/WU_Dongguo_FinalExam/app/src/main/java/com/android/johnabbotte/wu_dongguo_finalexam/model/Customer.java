package com.android.johnabbotte.wu_dongguo_finalexam.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private Account account;
    private Person person;

    public Customer(Account account, Person person) {
        this.account = account;
        this.person = person;
    }

    @Override
    public String toString() {
        return this.person.getlName() + " " + this.person.getfName() + " balance: " + this.account.getBalance();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
