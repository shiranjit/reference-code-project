/**
 The MIT License (MIT)

Copyright (c) 2015 Shirish Ranjit

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

 */

package com.teeznar.poi.test;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;

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

//	    Workbook wb = WorkbookFactory.create(inp);
	    Sheet sheet=null; //wb.getSheetAt(0);
	    
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
