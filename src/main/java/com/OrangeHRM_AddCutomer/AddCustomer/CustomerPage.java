package com.OrangeHRM_AddCutomer.AddCustomer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.TestBase;

public class CustomerPage extends TestBase {
	public CustomerPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = ".head h1")
	WebElement customerPageHeading;

	@FindBy(id = "btnAdd")
	WebElement addBtn;

	public String customerPageHeader() {
		return customerPageHeading.getText();
	}

	public AddCustomer clickAddBtn() {
		addBtn.click();
		return new AddCustomer();
	}

}
