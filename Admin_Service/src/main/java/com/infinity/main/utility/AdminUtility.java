package com.infinity.main.utility;

import java.util.Random;

public class AdminUtility {
	
	public static String setUsername(String firstname)
	{
		Random random=new Random(1000);
		return firstname+random.nextInt(9999);
	}

	public static String setPassword(String firstname)
	{
		Random random=new Random(1000);
		return firstname+"@"+random.nextInt(9999);
	}
}
