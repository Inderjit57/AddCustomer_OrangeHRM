package com.OrangeHRM_AddCutomer.AddCustomer;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.TestBase;

public class AddCustomer extends TestBase {

	public AddCustomer() {
		PageFactory.initElements(wd, this);
	}

	Properties properties;

	// Write Name in the box
	@FindBy(css = "#addCustomer_customerName")
	WebElement nameBox;

	// Write Description
	@FindBy(css = "#addCustomer_description")
	WebElement descriptionBox;

	// Click save btn
	@FindBy(id = "btnSave")
	WebElement saveBtn;

	public void inputName(String name) {
		nameBox.sendKeys(name);
	}

	public void inputDescription(String description) {
		descriptionBox.sendKeys(description);
	}

	public CustomerPage clickSave() {
		saveBtn.click();
		return new CustomerPage();
	}
}
