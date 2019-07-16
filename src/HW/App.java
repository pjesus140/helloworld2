package HW;

import com.qa.persistence.repository.AccountMapRepository;

public class App {

	public static void main(String[] args) {

//		System.out.println("Hello world to the standard out");

		// TODO Auto-generated method stub

		AccountMapRepository amr = new AccountMapRepository();
		System.out.println(amr.createAccount( 123, "jim", "bam"));
		System.out.println(amr.createAccount( 321, "james", "topson"));
		System.out.println(amr.createAccount( 563, "sam", "biggs"));
		
		amr.getAllAccounts();
		
		amr.updateAccount(1, 987, "ana", "smith");
		
		amr.getAllAccounts();
		
//		amr.deleteAccount(1);
		amr.getAllAccounts();
		String strx = (amr.toJson());

		amr.toObj(strx);
		
		
	}

}
