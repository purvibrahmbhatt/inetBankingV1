package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	
	
	@FindBy(how = How.LINK_TEXT, using = "REGISTER")
	WebElement Reglink;
	
	@FindBy(how = How.NAME, using = "firstName") //syntax1
	WebElement FirstName;
	
	/*
	 * @FindBy(name = "firstName") WebElement firstName; //syntax2
	 */
	
	@FindBy(how = How.NAME, using ="lastName")
	WebElement Lastname;
	
	/*
	 * @FindBy(name = "lirstName") WebElement lastName; //second method
	 */
	
	@FindBy(how = How.NAME, using ="phone")
	WebElement phone;
	
	@FindBy(how = How.NAME, using ="userName")
	WebElement email;
	
	@FindBy(how = How.NAME, using ="address1")
	WebElement Address1;
	
	@FindBy(how = How.NAME, using ="address2")
	WebElement Address2;
	
	@FindBy(how = How.NAME, using ="city")
	WebElement City;
	
	@FindBy(how = How.NAME, using ="state")
	WebElement State;
	
	@FindBy(how = How.NAME, using ="postalCode")
	WebElement PostalCode;
	
	@FindBy(how = How.NAME, using ="country")
	WebElement Country;
	
	@FindBy(how = How.NAME, using ="userName")
	WebElement UserName;
	
	@FindBy(how = How.NAME, using ="password")
	WebElement Password;
	
	@FindBy(how = How.NAME, using ="confirmPassword")
	WebElement ConfirmPassword;
	
	@FindBy(how = How.NAME, using ="register")
	WebElement RegisterBtn;
	
	RegistrationPage(WebDriver d){
		driver = d;
		PageFactory.initElements(d, this);  //additional method
	}
	
	public void clickRegLink() {
		Reglink.click();
		
	}
	
	public void setFirstName(String fname) {
		
		FirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		
		Lastname.sendKeys(lname);
	}
	
	public void setPhone(String ph) {
	
		Lastname.sendKeys(ph);
	}
	
	public void setEmail(String mail) {
		
		UserName.sendKeys(mail);
	}
	
	public void setAddress1(String addrs1) {
		Address1.sendKeys(addrs1);
	}
	
	public void setAddress2(String addrs2) {
		Address2.sendKeys(addrs2);
		
	}
	
	public void setCity(String citi) {
		City.sendKeys(citi);
	}
	
	public void setState (String stat) {
		State.sendKeys(stat);
	}
	
	public void setPostalCode(String pstcode) {
		PostalCode.sendKeys(pstcode);
	}
	
	public void setCountry(String cntry) {
		Country.sendKeys(cntry);
	}
	
	public void setUsername(String uname) {
		UserName.sendKeys(uname);
	}
	
	public void setPassword(String pswd) {
		
		Password.sendKeys(pswd);
	}
	
	public void setConfirmpassword(String confpswd) {
		
		ConfirmPassword.sendKeys(confpswd);
	}
	
	public void clickRegister() {
		RegisterBtn.click();
	}
	
	
	

}
