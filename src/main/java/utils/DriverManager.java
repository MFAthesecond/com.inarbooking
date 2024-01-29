package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

	private DriverManager() {
		throw new UnsupportedOperationException("Cannot instantiate utility class");
	}

	public synchronized static WebDriver getDriver() {
		return getDriver(System.getProperty("browser", "chrome"));
	}

	public synchronized static WebDriver getDriver(String browserType) {
		if (DRIVER_THREAD_LOCAL.get() == null) {
			WebDriver driver;
			driver = switch (browserType.toLowerCase()) {
				case "firefox" -> new FirefoxDriver();
				case "edge" -> new EdgeDriver();
				default -> new ChromeDriver();
			};

			driver.manage().window().maximize();
			driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			if (browserType.equalsIgnoreCase("firefox")) {
				driver.navigate().refresh();
				try {
					Thread.sleep(3000);
				}
				catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			DRIVER_THREAD_LOCAL.set(driver);
		}
		return DRIVER_THREAD_LOCAL.get();
	}

	public static void closeDriver() {
		if (DRIVER_THREAD_LOCAL.get() != null) {
			DRIVER_THREAD_LOCAL.get().quit();
			DRIVER_THREAD_LOCAL.remove();
		}
	}

}