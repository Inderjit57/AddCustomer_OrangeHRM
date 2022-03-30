package com.OrangeHRM_AddCutomer.AddCustomer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import BasePackage.TestBase;

public class Login extends TestBase {

	Login() {
		PageFactory.initElements(wd, this);
	}

	// Username input
	@FindBy(css = "input[id='txtUsername']")
	WebElement userNameInput;

	// Password input
	@FindBy(css = "input[id='txtPassword']")
	WebElement passwordInput;

	// Login Button
	@FindBy(css = "input[id='btnLogin']")
	WebElement loginBtn;

	public void userNameInput(String username) {
		userNameInput.sendKeys(username);
	}

	public void passwordInput(String password) {
		passwordInput.sendKeys(password);
	}

	// When Login is clicked, this method while invoke the constructor of an Account
	// class
	public Account clickLoginBtn() {
		loginBtn.click();
		return new Account();
	}
}
