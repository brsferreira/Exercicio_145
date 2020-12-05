package model.entities;

import model.exceptions.DomainException;

public final class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {// inicializa propriedades
		this(1005, "Bruno", 1000.0, 500.00);
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
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

//	public void setBalance(Double balance) {
//		this.balance = balance;
//	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

//	public void setWithdrawLimit(Double withdrawLimit) {
//		this.withdrawLimit = withdrawLimit;
//	}

	public void deposit(Double amount) {
		balance += amount;

	}

	public void withdraw(Double amount) throws DomainException {
		if (balance == 0)
			throw new DomainException(
					"Saldo insuficiente! Saldo atual: R$" + String.format("%.2f", getBalance()));
		else if (amount > withdrawLimit)
			throw new DomainException(
					"Limite de saque excedido! Saldo atual: R$" + String.format("%.2f", getBalance()));
		else
			balance -= amount;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", holder=" + holder + ", balance=" + balance + ", withdrawLimit="
				+ withdrawLimit + "]";
	}

}
