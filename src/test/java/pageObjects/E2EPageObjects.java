package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;

public class E2EPageObjects {

	// WebDriver driver; -- revisar que pasa si se utiliza el findElements

	public E2EPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='firstname']")
	private WebElement txt_UserName;

	@FindBy(how = How.XPATH, using = "//input[@name='lastname']")
	private WebElement txt_surName;
	
	@FindBy(how = How.XPATH, using = "//input[@name='reg_email__']")
	private WebElement txt_MobileNumber;

	public void setUserName(String userName) {
		System.out.println("Entró.... setUserName");
		txt_UserName.sendKeys(userName);
		System.out.println("Finalizó.... setUserName");
	}

	public void checkUserNameInformation(String expectedUserName) {
		System.out.println("Entró.... checkUserNameInformation");
		// String userNameActual =
		// driver.findElement(By.xpath("//input[@name='firstname']")).getAttribute("value");
		System.out.println("Nombre....." + txt_UserName.getAttribute("text"));
		System.out.println("Nombre....." + txt_UserName.getAttribute("value"));
		System.out.println("Nombre....." + txt_UserName.getText());
		Assert.assertEquals(expectedUserName, txt_UserName.getAttribute("value"));
		System.out.println("Finalizó.... checkUserNameInformation");
	}

	public void setSurname(String surname) {
		System.out.println("Entró.... setSurname");
		txt_surName.sendKeys(surname);
		System.out.println("Finalizó.... setSurname");
	}
	
	public void checkUserMobileInformation() {
		System.out.println("Entró.... checkUserMobileInformation");
		//String mobileField = driver.findElement(By.xpath("//input[@name='reg_email__']")).getAttribute("value");
		Assert.assertEquals("", txt_MobileNumber.getAttribute("value"));
		System.out.println("Finalizó.... checkUserMobileInformation");
	}
	
	public void enterDataFromDataTable(DataTable table) throws InterruptedException {
		System.out.println("Entró.... enterDataFromDataTable");
		for (int i = 1; i < table.raw().size(); i++) { // Rows
			for (int j = 0; j < (table.raw().get(i).size() - 1); j++) {// Columns
				txt_UserName.clear();
				txt_UserName.sendKeys(table.raw().get(i).get(j));
				Thread.sleep(2000);
				txt_surName.clear();
				txt_surName.sendKeys(table.raw().get(i).get(++j));
				Thread.sleep(2000);
				txt_MobileNumber.clear();
				txt_MobileNumber.sendKeys(table.raw().get(i).get(++j));
				Thread.sleep(2000);
			}
		}
		System.out.println("Finalizó.... enterDataFromDataTable");
	}
}
