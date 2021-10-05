package challenges;

import org.testng.annotations.Test;

import enumData.AccountData;
import enumData.Country;
import enumData.Merchant;



public class UsingEnum{
	
	
	@Test()
	public void ValidateSuggestions() {
		String country = Country.values()[(int)(Math.random()*Country.values().length)].name();
	
		String merchant = Merchant.values()[(int)(Math.random()*Merchant.values().length)].name();
		String account = AccountData.getRandomAccount(merchant);
		
		
		System.out.println("Merchant: "+merchant);
		System.out.println("AccountNumber: "+account);
		System.out.println("Country Value: "+country.replace("_", " "));
		
	}

}
