package com.android.johnabbotte.wu_dongguo_finalexam.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;

public class Account implements Serializable {
    private int id;
    private String accountNo;
    private Date opendDate;
    private BigDecimal balance;

    public Account(int id, String accountNo, Date opendDate, BigDecimal balance) {
        this.id = id;
        this.accountNo = accountNo;
        this.opendDate = opendDate;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return  "id= " + id +
                ", accountNo='" + accountNo + '\'' +
                ", opendDate=" + opendDate +
                ", balance=" + balance + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }


    public Date getOpendDate() {
        return opendDate;
    }

    public void setOpendDate(Date opendDate) {
        this.opendDate = opendDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
