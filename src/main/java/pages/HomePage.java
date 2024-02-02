package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(linkText = "Weborder")
	private WebElement webOrderLink;

	@FindBy(linkText = "Webautomation")
	private WebElement webAutomationLink;

	@FindBy(linkText = "Target Market")
	private WebElement targetMarketLink;

	@FindBy(linkText = "Booking")
	private WebElement bookingLink;

	@FindBy(linkText = "Handling Certifications")
	private WebElement handlingCertificationsLink;

	@FindBy(linkText = "File Uploading")
	private WebElement fileUploadingLink;

	@FindBy(className = "theme-switcher")
	private WebElement themeSwitcher;

	@FindBy(tagName = "h1")
	private WebElement header;

	@FindBy(tagName = "p")
	private WebElement paragraph;

	public void clickWebOrderLink() {
		webOrderLink.click();
	}

	public void clickWebAutomationLink() {
		webAutomationLink.click();
	}

	public void clickTargetMarketLink() {
		targetMarketLink.click();
	}

	public void clickBookingLink() {
		bookingLink.click();
	}

	public void clickHandlingCertificationsLink() {
		handlingCertificationsLink.click();
	}

	public void clickFileUploadingLink() {
		fileUploadingLink.click();
	}

	public void clickThemeSwitcher() {
		themeSwitcher.click();
	}

	public String getHeader() {
		return header.getText();
	}

	public String getParagraph() {
		return paragraph.getText();
	}

}
