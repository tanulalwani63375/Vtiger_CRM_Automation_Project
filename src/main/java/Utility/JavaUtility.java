package Utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class JavaUtility {
	public static  long getRandomNumber() {
		Random r= new Random();
			return r.nextLong();
		//	return r.nextInt();
		//	return r.doubles();
		//	return r.nextBoolean();		
	}
	
//another way
	public  int generateRandomNumber() {
		 Random random = new Random();
		    return random.nextInt(10000);
	}
	
	// Returns tomorrow's date in yyyy-MM-dd format
    public String getTomorrowDate() {

        LocalDate tomorrow = LocalDate.now().plusDays(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return tomorrow.format(formatter);
    }
}
