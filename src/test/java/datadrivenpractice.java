import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadrivenpractice {
//WORKBOOK-SHEET-ROW-CELL-CELLVALUE
	public  static ArrayList<String> getTheData(String testCaseNeeded) throws IOException{
		FileInputStream fileinput = new FileInputStream("C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\demodata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);//this is from the apache poi dependency for data driven from excel
		//now in the workbook, get to the sheet
		ArrayList<String> arrvalue=new ArrayList<String>();
		int sheetNumber =workbook.getNumberOfSheets();
		
		for(int i=0; i<sheetNumber; i++) {
			
		
			//if the sheetname equals testdata(which is the name of the excel), perform some operations
			if(workbook.getSheetName(i).equalsIgnoreCase("testData1")) {
				XSSFSheet sheet=workbook.getSheetAt(i);//get the sheet at the current iteration
				//now go to rows
				Iterator<Row> row =sheet.rowIterator();
				//now in the rows 0th index, move to the row
				Row firstrow =row.next();
				//now move to the first cell
				Iterator<Cell> cell=firstrow.cellIterator();
				int k=0;
				int column =0;
				while(cell.hasNext()) {
					Cell firstcell=cell.next();
					//now store the index of the first cell for further use
					if(firstcell.getStringCellValue().equalsIgnoreCase("TestCases")) {
					 //the first cell value is now store as index column which is 0
					}
					k++;
				}
				
				//now iterate through the row using the index 0
				while(row.hasNext()) {
					Row r=row.next();
					//now in the first row
					//if the cell is at 0, move to the needed testcase
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseNeeded)) {
						Iterator<Cell> testcasecell=r.cellIterator();
						while(testcasecell.hasNext()) {
							//now in the needed testcasecell
							
							arrvalue.add(testcasecell.next().getStringCellValue());
						}
					}
				}
				
			}
		}
		return arrvalue;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//WORKBOOK - SHEET - ROW - CELL -CELLVALUE
		/**
		 * Task is to get the all the values in Login in the excel and put them in 
		 * an array
		 */
		//place file in a fileinputstream method
		
	}

}
