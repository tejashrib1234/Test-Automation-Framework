package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String FileName) {

		File file = new File(System.getProperty("user.dir") + "//testData//" + FileName + ".xlsx");
		// XLSX file
		XSSFWorkbook workbook = null;
		XSSFSheet xssfSheet;
		Iterator<Row> rowIterator;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user;
		List<User> userList = null;
		try {
			workbook = new XSSFWorkbook(file);
			xssfSheet = workbook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			userList = new ArrayList<User>();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
				
			}
		} catch (InvalidFormatException | IOException e) {

			e.printStackTrace();

		}
		try {
			workbook.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return userList.iterator();

	}

}
