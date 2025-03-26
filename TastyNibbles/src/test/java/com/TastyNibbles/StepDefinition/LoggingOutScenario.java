package com.TastyNibbles.StepDefinition;

import java.io.File;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.TastyNibbles.Browser.Browser;
import com.TastyNibbles.Pages.Page2;
import com.TastyNibbles.Pages.Page3;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoggingOutScenario {
	@When("User enters the login Credentials")
	public void user_enters_the_login_credentials(DataTable dataTable)throws Exception {
		Browser.init("Login credentials");
		List<List<String>> credentials = credentials("C:\\Users\\pjaga\\eclipse-workspace\\TastyNibbles\\src\\test\\resources\\TestData.xlsx");
		dataTable = DataTable.create(credentials);
		System.out.println(dataTable.cell(0, 0));
		System.out.println(dataTable.cell(0, 1));
		Page2.enterEmail(dataTable.cell(0, 0));
		Page2.enterPassword(dataTable.cell(0, 1));
}public static List<List<String>> credentials(String excelFilePath) throws Exception {
		List<List<String>> credentials = new ArrayList<>();
		FileInputStream file = new FileInputStream(new File(excelFilePath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			List<String> rowData = new ArrayList<>();
			if(row!=null) {
				for(int j=0;j<row.getLastCellNum();j++) {
					Cell cell=row.getCell(j);
					if(cell!=null) {
						rowData.add(cell.getStringCellValue());
					}else {
						rowData.add("");
					}
				}
			}
		credentials.add(rowData);
		}
	workbook.close();
	return credentials;

	}     
	@And("User selects Logout option")
	public void user_selects_logout_option() {
		Page3.logOut();

	}
	@Then("User Verify that the session ends and the user is redirected to the homepage.")
	public void user_verify_that_the_session_ends_and_the_user_is_redirected_to_the_homepage() {
		Page3.verifyUserRedirectedToHomePage();

		
	}




}
