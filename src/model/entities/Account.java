package model.entities;

import model.excepitions.DomainExcepition;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdraw) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdraw;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > this.withdrawLimit) {
            throw new DomainExcepition("Seu limite para saque é apenas de R$" + this.getWithdrawLimit() + " informe um valor menor");
        }
        if (amount > this.balance) {
            throw new DomainExcepition("Saldo de R$ " + this.getBalance() + " Você não tem saldo suficiente");
        }
        this.balance -= amount;
    }
}
