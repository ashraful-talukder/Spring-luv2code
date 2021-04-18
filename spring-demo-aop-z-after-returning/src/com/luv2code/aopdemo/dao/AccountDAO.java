package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	// add a new method: findAccounts()
	public List<Account> findAccounts(){
		
		List<Account> myAccount = new ArrayList<>();
		
		// create sample accounts
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Silver");
		Account temp3 = new Account("Luca", "Platinum");
		Account temp4 = new Account("Sena", "Bronze");
		
		// add them to our accounts list
		myAccount.add(temp1);
		myAccount.add(temp2);
		myAccount.add(temp3);
		myAccount.add(temp4);
		
		return myAccount;
	}
	
	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": Doing my DB work: Adding an account");
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
		return true;
	}
}
