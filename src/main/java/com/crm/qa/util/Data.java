package com.crm.qa.util;

import java.util.HashMap;

import com.crm.qa.base.TestBase;

public class Data extends TestBase{
	
	public HashMap<String, String> getLoginCredentials() {
		
		HashMap<String, String> adminCredentials = new HashMap<String, String>();
		adminCredentials.put("admin", "huy92708_test@123");
		
		return adminCredentials;
	}
}
