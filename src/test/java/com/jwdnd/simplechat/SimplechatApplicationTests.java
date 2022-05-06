package com.jwdnd.simplechat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.thymeleaf.context.IWebContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SimplechatApplicationTests {

	@LocalServerPort
	private Integer port;

	private static WebDriver webDriver;

	@BeforeAll
	public static void init() {
		WebDriverManager.chromedriver().setup();
		webDriver = new ChromeDriver();
	}

	@AfterAll
	public static void destroy() {
		webDriver.quit();
	}

	@Test
	void registerUser() throws InterruptedException {
		webDriver.get("http://localhost:"+port+"/signup");
		Thread.sleep(1000);
		SignupPage signupPage = new SignupPage(webDriver);
		signupPage.registerUser("Muhammad","Sobhy","mohsobhy","123");
		Thread.sleep(1000);
		webDriver.get("http://localhost:"+port+"/login");
		Thread.sleep(1000);
		LoginPage loginPage = new LoginPage(webDriver);
		loginPage.loginUser("mohsobhy","123");
		webDriver.get("http://localhost:"+port+"/signup");

	}

}
