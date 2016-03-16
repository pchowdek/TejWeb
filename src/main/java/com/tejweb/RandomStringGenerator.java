package com.tejweb;//Abhijeet Goswami 08/Feb/2016

import org.apache.commons.lang.RandomStringUtils;

public class RandomStringGenerator {//Abhijeet Goswami 08/Feb/2016
	
	public  String generator(){//Abhijeet Goswami 08/Feb/2016
	
	String randomString = RandomStringUtils.random(32, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray());
    
	return randomString;
	}
	
}
