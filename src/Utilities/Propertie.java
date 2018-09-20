package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertie {

	Properties proper;
	String FileName;
	FileInputStream input;
	String File2="";
	
	public Propertie(String FileName) throws FileNotFoundException 
	{	
		this.FileName=FileName;
		proper=new  Properties();
		input=new FileInputStream(FileName);
		
	}
	
	public String getPropData(String keyValue) throws IOException
	{
		proper.load(input);
		return proper.getProperty(keyValue);
		
	}
	
	public void setKeyalue(String Key,String value) throws IOException
	{
		FileOutputStream output=new FileOutputStream(FileName);
		proper.setProperty(Key, value);
		proper.store(output, "FileCreated");
	}
	
	public void removeKeyalue(String Key) throws IOException
	{	proper.load(input);
		FileOutputStream output=new FileOutputStream(FileName);
		proper.remove(Key);
		proper.store(output, "KeyRemoved");
	}
	
	
	
}
