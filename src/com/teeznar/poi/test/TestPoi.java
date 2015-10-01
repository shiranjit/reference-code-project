/**
 * Teeznar Corp
 * All rights reserved
 *
 * 2013
 */
package com.teeznar.poi.test;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 *
 */
public class TestPoi {

    /**
     * 
     */
    public TestPoi() {
	// TODO Auto-generated constructor stub
    }
    
    public void test(){
	InputStream inp;
        try {
	    inp = new FileInputStream("sample-file.xlsx");
        
	    //InputStream inp = new FileInputStream("workbook.xlsx");

	    Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet = wb.getSheetAt(0);
	    
	    for(Row arow : sheet ){
	    	
	    	for(Cell acell: arow){
	    		System.out.print(" cell: "+ acell);
	    	}
	    	System.out.println("\n");
	    }
	    
	    
	    Row row = sheet.getRow(2);
	    Cell cell = row.getCell(3);
	    
	    System.out.println(cell.toString());
	    
        }
        catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
        }    
    }

}
