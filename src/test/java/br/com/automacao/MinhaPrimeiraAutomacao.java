package br.com.automacao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class MinhaPrimeiraAutomacao {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.google.com.br");
	
	driver.manage().window().maximize();
	driver.findElement(By.name("q")).sendKeys("Flash code");
	driver.findElement(By.name("BtnK"));
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
