package com.OrangeHRM_AddCutomer.AddCustomer;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.TestBase;

public class AddCustomerTest extends TestBase {

	TestBase testBase;
	Login login;
	Account account;
	CustomerPage customerPage;
	AddCustomer addCustomer;

	@BeforeMethod
	public void intialisation() {
		structureInitialisation();

		// initializing landing page
		login = new Login();
	}

	@Test
	public void addCustomer() {

		// Input login credentials
		login.userNameInput(properties.getProperty("username"));
		login.passwordInput(properties.getProperty("password"));

		// click login button
		login.clickLoginBtn();

		// Verify successful login
		String getSuccessfulLoginText = account.accountPage();
		Assert.assertEquals(getSuccessfulLoginText, "Dashboard", "No element is present"); // exptected message to be added

		// Hover mouse to tab: Time
		account.hoverToTabTime();

		// verify customer page is present
		String customerPageText = customerPage.customerPageHeader();
		Assert.assertEquals(customerPageText, "Customers", "No element is present"); // exptected message to be added

		// Click add button
		customerPage.clickAddBtn();

		// Add new customer
		addCustomer.inputName(properties.getProperty("username"));
		addCustomer.inputDescription(properties.getProperty("description"));

		// Click Save
		addCustomer.clickSave();
	}

	@AfterMethod
	public void closeBrowser() {
		// tearDown();
	}

}
