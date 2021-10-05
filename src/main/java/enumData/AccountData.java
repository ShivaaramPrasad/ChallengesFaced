package enumData;

import java.util.Random;

public class AccountData {
	
	public static String getRandomAccount(String merchant) {		
		switch(merchant) {
			case "Airtel" : return "91"+(int)(new Random().nextDouble()*1000000000);
			case "Jio" : return "97"+(int)(new Random().nextDouble()*10000000);		
			case "Sundirect" : return "90"+(int)(new Random().nextDouble()*100000000);
			case "Vodafone" : return "73"+(long)(new Random().nextDouble()*10000000000L);
			default: return "91"+(int)(new Random().nextDouble()*1000000000);
		}
		
	}
	

}
