import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadriven {
	/**
	 * To access excel sheet, 
	 * Create an object of the XSSFWORKBOOK from the apache poi dependency
	 * Locate the sheet
	 * locate the rows
	 * locate the cells in the rows
	 * @param args
	 * @return 
	 * @throws IOException 
	 */
	
	public ArrayList<String> getData(String testCaseName) throws IOException {
	FileInputStream fileinput = new FileInputStream("C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\demodata.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		//WORKBOOK - SHEET- ROW -CELL - CELL VALUE
		
		//row is a collection of cell
		ArrayList<String> arr = new ArrayList<String>();
		
		for(int i=0; i<workbook.getNumberOfSheets();i++) {
			
			
			if(workbook.getSheetName(i).equalsIgnoreCase("testData1")) {
				XSSFSheet sheet=workbook.getSheetAt(i);
				//now in the sheet, go to the rows by iterating
				Iterator<Row> row =sheet.rowIterator();
				//now on the 0th index, move to the first row
				Row firstrow = row.next();
				//move to cell in the row
				Iterator<Cell> cell =firstrow.cellIterator();
			
				int k=0;
				int column=0;
			while(cell.hasNext()) {
				Cell value = cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("TestCases")) {
					
					column=k;
				}
				k++; //checks if cell is at 0 index, column is 0, k is 0, column increases
			
			}
			System.out.println(column);
			
			//once column is identified, now scan the entire testcase column to get to the
			//Create user cell in the excel sheet
			while(row.hasNext()) {
				
				/**
				 * the idea is to go to the first cell in the row and
				 * loop through it till you get the cell value you need
				 */
				//iterate through the rows
				Row r=row.next(); 
				//now in the first row
				//get only the row values at 0 index which is column
				Cell firstcell =r.getCell(column);
				//now in the TestCase column from the excel sheet
				//if the first cellvalue equals Create User
				if(firstcell.getStringCellValue().equalsIgnoreCase(testCaseName)){
					//once the cell value in the row is Create User
					//get the data of the row
					//iterate over the cell in the row --- row is a collection of cell
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext()) {
						//while there is a value in the row cells, print the value
						//System.out.println(cv.next().getStringCellValue());
						//store the values of the cell in an array list
						Cell c= cv.next();
						
						//the arraylist is of type string so a method 
						//NumberToTextConverter.toText has to be used
						if(c.getCellType()==CellType.STRING) {
							arr.add(c.getStringCellValue());
						}
						else {
							arr.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
					
						
					}
								}
				
			}
			}
			
		
		}
		return arr;
	}
	public static void main (String[] args) throws IOException {
		//fileinputstream argument is to be passed in the XSSFWorkbook
	
		
	}

}
