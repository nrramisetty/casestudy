package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {


	 static XSSFSheet sheet;
	static XSSFWorkbook workbook;
	static XSSFCell cell;
	static XSSFRow row;
	static String filename;

	public ExcelReader(String filename) throws FileNotFoundException	

	{

		this.filename=filename;
		
		
	}

	public static  String getCellData(int rowNum,int cellNum,String sheetnmame) throws IOException
	{	
		workbook=new XSSFWorkbook(new FileInputStream(new File(filename)));
		sheet=workbook.getSheet(sheetnmame);
		cell=sheet.getRow(rowNum).getCell(cellNum);
		if(cell.getCellType()==cell.CELL_TYPE_STRING)
		{
			return cell.getStringCellValue();
		}
		else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
		{
			return String.valueOf(cell.getNumericCellValue());
		}

		return null;
	}

	public static String getCellData(String sheetnmame,String value) throws IOException
	{	
		workbook=new XSSFWorkbook(new FileInputStream(new File(filename)));
		sheet=workbook.getSheet(sheetnmame);
		String data=null;
		
		for(int i=0;i<sheet.getRow(0).getLastCellNum();i++)
		{
			cell=sheet.getRow(0).getCell(i);
		if(cell.getCellType()==cell.CELL_TYPE_STRING)
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
		{
			data= String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==cell.CELL_TYPE_BOOLEAN)
		{
			data= String.valueOf(cell.getBooleanCellValue());
		}
		
		if(data.equalsIgnoreCase(value))
				{
			return sheet.getRow(1).getCell(i).getStringCellValue();
			
				}
		}
				
				

		return null;
	}
	
	public static void writeCellData(int rowNum,int cellNum,String sheetnmame,String value) throws IOException
	{	
		workbook=new XSSFWorkbook(new FileInputStream(new File(filename)));
	
		if(workbook.getSheet(sheetnmame)!=null)
		{
		sheet=workbook.getSheet(sheetnmame);
		}
		else{
			sheet=workbook.createSheet(sheetnmame);
		}
		
		 cell=sheet.createRow(rowNum).createCell(cellNum);
		 cell.setCellValue(value);
		 workbook.write(new FileOutputStream(new File(filename)));
		
		}
				
				

	public static void writeCellData(String sheetnmame,String value) throws IOException
	{	
		workbook=new XSSFWorkbook(new FileInputStream(new File(filename)));
		sheet=workbook.getSheet(sheetnmame);
		String data=null;
		
		if(workbook.getSheet(sheetnmame)!=null)
		{
		sheet=workbook.getSheet(sheetnmame);
		}
		else{
			sheet=workbook.createSheet(sheetnmame);
		}
		
		 row=sheet.createRow(sheet.getLastRowNum());
		
		cell=sheet.createRow(sheet.getLastRowNum()+1).createCell(row.getLastCellNum()+1);
		 cell.setCellValue(value);
		 workbook.write(new FileOutputStream(new File(filename)));
		
	}

	
	

}
