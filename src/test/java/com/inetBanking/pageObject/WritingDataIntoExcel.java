package com.inetBanking.pageObject;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {

		FileOutputStream file = new FileOutputStream("C://QA DOCS//Datadrivenwriting.xls");
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet("DATA1");
		HSSFSheet sheet1=workbook.createSheet("DATA2");
		
		for (int i = 0; i < 5; i++) {
			
			HSSFRow row = sheet.createRow(i);
			HSSFRow row1 = sheet1.createRow(i);
			
			for (int j = 0; j < 3; j++) {
				
				row.createCell(j).setCellValue("purvi");
				row1.createCell(j).setCellValue("ABACAA");
			}
			
			
		}
		
		workbook.write(file);
		
		file.close();
		
		System.out.println("Written data entered successfuly");
	}

}
