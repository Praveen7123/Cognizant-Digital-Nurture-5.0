package com.cognizant.account;

// simple model - Spring turns this into JSON automatically
public class Account {
    private String number;
    private String type;
    private int balance;

    public Account(String number, String type, int balance) {
        this.number = number;
        this.type = type;
        this.balance = balance;
    }

    public String getNumber() { return number; }
    public String getType() { return type; }
    public int getBalance() { return balance; }
}
