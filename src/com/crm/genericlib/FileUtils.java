package com.crm.genericlib;
/*
 * @author pallabi
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtils 
{
String excelpath="G:\\eclipse\\Selenium\\Program5.xlsx";
String propertyfilepath="G:\\eclipse\\Selenium\\commondata.properties";
/*
 * @Return string
 * @Throws Throwable
 *it return object of the properties file & load all the keys
 */
public Properties getPropertiesFileObj() throws Throwable
{
	FileInputStream fis=new FileInputStream(propertyfilepath);
	Properties pObj=new Properties();
	pObj.load(fis);
	return pObj;
}
	/*
	 * @param sheetname,rownum,colnum
	 * @return string
	 * @Throws Throwable
	 * @param colnum
	 * @param data
	 * @param Throwable
	 * its used to read data from excelfile based on user argument
	 */
	public String getExcelData(String sheetname, int rownum, int colnum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
	    FileInputStream fis=new FileInputStream(excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row row= sh.getRow(rownum);
		String data=row.getCell(colnum).getStringCellValue();
		return data;
}
/*
 * @param sheetname
 * @param rowname
 * @param colnum
 * @param data
 * @param Throwable
 * its used to write data back to excel based on user argument
 */
	public void setExcelData(String sheetname, int colnum, int rownum, String data)throws Throwable
	{
		FileInputStream fis=new FileInputStream(excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row row= sh.getRow(rownum);
		Cell cel=row.createCell(colnum);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(excelpath);
		wb.write(fos);
		wb.close();	
}
}
