package com.abc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.abc.Account;
import com.abc.AccountType;
import com.abc.Bank;
import com.abc.Customer;

/**
 * @author Prachi
 *
 */
public class BankTest {
	private static final double DOUBLE_DELTA = 1e-15;

	@Test
	public void customerSummary() {
		Bank bank = new Bank();
		Customer john = new Customer("John");
		john.openAccount(new Account(AccountType.CHECKING));
		bank.addCustomer(john);
		assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
	}

	@Test
	public void checkingAccount() {
		Bank bank = new Bank();
		Account checkingAccount = new Account(AccountType.CHECKING);
		Customer bill = new Customer("Bill").openAccount(checkingAccount);
		bank.addCustomer(bill);
		checkingAccount.deposit(100.0);
		assertEquals(0.1, bank.totalInterestPaid(), DOUBLE_DELTA);
	}

	@Test
	public void savings_account() {
		Bank bank = new Bank();
		Account checkingAccount = new Account(AccountType.SAVINGS);
		bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));
		checkingAccount.deposit(1500.0);
		assertEquals(1.0, bank.totalInterestPaid(), DOUBLE_DELTA);
	}

	@Test
	public void maxi_savings_account() {
		Bank bank = new Bank();
		Account checkingAccount = new Account(AccountType.MAXI_SAVINGS);
		bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));
		checkingAccount.deposit(3000.0);
		assertEquals(150.0, bank.totalInterestPaid(), DOUBLE_DELTA);
	}
}
