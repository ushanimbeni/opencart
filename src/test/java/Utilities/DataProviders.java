package Utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		//String path=".\\testdata\\Opencart_LoginData.xlsx";//taking xl file from testData
		Path path = Paths.get("testdata", "Opencart_LoginData.xlsx");

		ExcelUtility xlutil=new ExcelUtility(path.toString());//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);

		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}
