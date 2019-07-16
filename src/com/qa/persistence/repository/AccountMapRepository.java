package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;

public class AccountMapRepository implements AccountRepository {

	Map<Long, Account> accountMap = new HashMap<Long, Account>();

	// You must provide concrete implementation for each of these methods
	// do not change the method signature
	// THINK - if the parameter is a String, or the return type is a String
	// How can I convert to a String from an Object?
	// What utility methods do I have available?

	// You must complete this section using TDD
	// You can use the suggested tests or build your own.

	public String getAllAccounts() {

		for (Long n : accountMap.keySet()) {
			System.out.println("id: " + n.toString() +"\nAccount Number: "+ ((Account) accountMap.get(n)).getAccNum()
					+ "\nFirst name: "+((Account) accountMap.get(n)).getfName() +"\nLast name: "+ ((Account) accountMap.get(n)).getlName());
		}
		return "";
	}

	private long x = 0;

	public String createAccount(int accNum, String fName, String lName) {
		Account a = new Account(accNum, fName, lName);
		accountMap.put(x, a);
		x++;
		return a.getfName() + " " + a.getlName() + " Account created";
	}

	public String deleteAccount(long id) {
		
		accountMap.remove(id);
		
		return null;
	}

	public String updateAccount(long id, int accNum, String fName, String lName) {
			Account a = new Account(accNum, fName, lName);
		Map<Long, Account> accountMapTemp = new HashMap<Long, Account>();
		for(Long q : accountMap.keySet()) {
			if(id != q) {
				accountMapTemp.put(q, accountMap.get(q));
				
				
			}
			else accountMapTemp.put(q, a);
		}
		

		accountMap = accountMapTemp;
		return null;
	}



	

}
