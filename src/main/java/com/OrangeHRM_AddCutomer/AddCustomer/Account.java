package com.OrangeHRM_AddCutomer.AddCustomer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.TestBase;

public class Account extends TestBase {

	public Account() {
		PageFactory.initElements(wd, this);
	}

	Actions actions;

	// Account Dasboard
	@FindBy(css = ".head h1")
	WebElement accountDasboard;

	// Move to element Time
	@FindBy(id = "menu_time_viewTimeModule")
	WebElement moveToElementTime;

	public String accountPage() {
		return accountDasboard.getText();
	}

	public CustomerPage hoverToTabTime() {
		actions = new Actions(wd);
		actions.moveToElement(moveToElementTime).perform();
		return new CustomerPage();

	}

}
