package com.qa.persistence.repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.List;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
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
			System.out.println("id: " + n.toString() + "\n: " + ((Account) accountMap.get(n)).getAccNum()
					+ "\nFirst name: " + ((Account) accountMap.get(n)).getfName() + "\nLast name: "
					+ ((Account) accountMap.get(n)).getlName());
		}
		return "";
	}

	private long x = 0;

	public String createAccount(int accNum, String fName, String lName) {
		Account a = new Account(accNum, fName, lName);
		a.setId((int) x);
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
		for (Long q : accountMap.keySet()) {
			if (id != q) {
				accountMapTemp.put(q, accountMap.get(q));

			} else
				accountMapTemp.put(q, a);
		}

		accountMap = accountMapTemp;
		return null;
	}

	public String toJson() {
		ObjectMapper mapper = new ObjectMapper();
		
		try {



            // Java objects to JSON string - compact-print
            String jsonString = mapper.writeValueAsString(accountMap);

            System.out.println(jsonString);

          return jsonString;

    

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

	}
	
	public int sameNames(String fName) {
		
		int count =0;
		
		for (Long y : accountMap.keySet()) {
			if (accountMap.get(y).getfName().equals(fName)) {
				count++;
			}
		}
		System.out.println("Fist name: "+fName+"\nAppears:"+count+"x");
		return count;
		
	}
	
	
//	public void toObj(String jsonString) {
//		ObjectMapper mapper = new ObjectMapper();
//		
//		try {
//
//
//
//            // Java objects to JSON string - compact-print
//			Account staff2 = mapper.readValue(jsonString, Account.class);
//
//            System.out.println(staff2);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//	}

}
