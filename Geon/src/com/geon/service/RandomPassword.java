package com.geon.service;

import java.util.Random;

public class RandomPassword
{
	static String allowedCharacters = "1234567890";
	public String getPassword() {
		  
		  
		  StringBuilder promoString = new StringBuilder();
		  
		  Random rnd = new Random();
		  
		  while (promoString.length() < 7) 
		  {
		   int randomDigit = (int) (rnd.nextFloat() * allowedCharacters.length());
		   promoString.append(allowedCharacters.charAt(randomDigit));
		  }
		  String saltStr = promoString.toString();
		  return saltStr;
	}
}
