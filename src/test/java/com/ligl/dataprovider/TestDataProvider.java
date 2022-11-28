package com.ligl.dataprovider;

import java.lang.reflect.Method;

import com.ligl.base.pages.Constants;
import org.testng.annotations.DataProvider;

import com.ligl.util.DataUtil;
import com.ligl.util.Xls_Reader;

public class TestDataProvider {

	
	
	@DataProvider
	public static Object[][] getData(Method m){
		String testDataSheet= Constants.TEST_DATA_SHEET;
		System.out.println("Getting data for "+ m.getName());
		Object[][] data= new DataUtil().getData(m.getName(), new Xls_Reader(System.getProperty("user.dir")+"//"+ testDataSheet +".xlsx"));
		System.out.println("Got data for "+ m.getName());
		return data;
	}
	

	
	
}
