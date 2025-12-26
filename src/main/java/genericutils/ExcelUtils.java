package genericutils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	/**
	 * This method is used to read single data from excel file
	 * @author Vijayalaxmi
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int rowNo, int celNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(rowNo).getCell(celNo).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to read multiple data from excel and stored in arrayList 
	 * @author Vijayalaxmi
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public ArrayList<String> readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		int celCount = sh.getRow(0).getLastCellNum();
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=0;i<=rowCount; i++)
		{
			for(int j=0; j<celCount; j++)
			{
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				
				list.add(value);
			}
			
		}
		return list;
	}
	
	/**
	 * 
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}
	
	/**
	 * 
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getCellCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int celCount = sh.getRow(0).getLastCellNum();
		return celCount;
	}
	
	public void writeDataIntoExcel(String sheetName, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(0);
		Cell cel= row.createCell(0);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IPathConstants.excelPath);
		wb.write(fos);
		wb.close();
	}
	
	
	
	public Object[][] readMultipleSetOfData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum()+1;
		int celCount = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowCount][celCount];
		
		for(int i=0; i<rowCount; i++)		//row
		{
			for(int j=0; j<celCount; j++)
			{
				 obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
	}
}









