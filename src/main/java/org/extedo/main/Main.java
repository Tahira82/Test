package org.extedo.main;

import java.util.List;

import org.extedo.helper.StringHelper;

public class Main {

	public static void main(String[] args) {
		try {
			new Main().func(args[0]);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	void func(String str) throws Exception {
		
		StringHelper strHelper = new StringHelper(str);
		strHelper.process();
		List<String> allComents = strHelper.getAllComents();
		List<String> allStrings = strHelper.getAllStrings();
		
		System.out.println(allComents + "\n");
		System.out.println(strHelper.getTotalCommentsCount());
		
		System.out.println("********************************************************************************************************************");
		
		System.out.println(allStrings + "\n");
		System.out.println(strHelper.getTotalStringsCount());
	}
}
