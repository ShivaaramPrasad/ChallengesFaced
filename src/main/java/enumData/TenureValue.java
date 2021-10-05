package enumData;

import java.util.Random;

public class TenureValue {
	
	public static int getRandomAccount(String tenure) {		
		switch(tenure) {
			case "Days" : return (int)(new Random().nextInt(10000));
			case "Months" : return (int)(new Random().nextInt(400));		
			case "Years" : return (int)(new Random().nextInt(25));
			default: return (int)(new Random().nextInt(10000));
		}
		
	}

}
