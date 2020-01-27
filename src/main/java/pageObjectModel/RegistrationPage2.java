package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage2 {
	
	WebDriver driver;
	
	
	By RegLink=By.linkText("REGISTER");
	By FirstName = By.name("firstName");
	By LastName = By.name("lastName");
	By Phone = By.name("phone");
	By email = By.name("userName");
	By address1 = By.name("address1");
	By address2 = By.name("address2");
	By City = By.name("city");
	By state = By.name("state");
	By postalcode = By.name("postalCode");
	By country = By.name("country");
	By username = By.name("email");
	By password = By.name("password");
	By confirmpassword = By.name("confirmPassword");
	By register = By.name("register");
	
	
	RegistrationPage2(WebDriver d)
	{
		driver=d;
	}
	
	
	public void clickregLink() {
		
		driver.findElement(RegLink).click();
	}
	
	public void setFirstName(String fname) {
		
		driver.findElement(FirstName).sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		
		driver.findElement(LastName).sendKeys(lname);
		
	}
	
	public void setPhone(String ph) {
		
		driver.findElement(Phone).sendKeys(ph);
	}
	
	public void setemail(String mail) {
		
		driver.findElement(email).sendKeys(mail);
		
	}
	
	public void setAddress1(String addr1) {
		
		driver.findElement(address1).sendKeys(addr1);
	}
	
	public void setAddress2(String addr2) {
		
		driver.findElement(address2).sendKeys(addr2);
	}
	
	
	public void setCity(String city1) {
		
		driver.findElement(City).sendKeys(city1);
		
	}

	
	public void setState(String stat) {
		
		driver.findElement(state).sendKeys(stat);
		
	}
	
	public void setpostalCode(String postcode) {
		
		driver.findElement(postalcode).sendKeys(postcode);
	}
	
	public void setCountry(String cntry) {
		
		driver.findElement(country).sendKeys(cntry);
	}
	 
	
	public void setUsername(String uname) {
		
		driver.findElement(email).sendKeys(uname);
		
	}
	
	public void setPassword(String pswd) {
		
		driver.findElement(password).sendKeys(pswd);
	}
	
	public void setConfirmpswd(String confpswd) {
		
		driver.findElement(confirmpassword).sendKeys(confpswd);
	}
	
	
	public void clickregister() {
		
		driver.findElement(register).click();
	}
	
	
}
