package br;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QAstore {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get("https://qastoredesafio.lojaintegrada.com.br/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//*[@id=\"cabecalho\"]/div[2]/div[1]/div[2]/div[1]/div[2]/ul/li[2]/a")).click();
	driver.findElement(By.id("id_email")).sendKeys("eduardoluiz.gold@hotmail.com");
	driver.findElement(By.id("id_senha")).sendKeys("12345Brasil@2023");
	driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[2]/div[2]/div[1]/div/form/fieldset/div[2]/div/button")).click();
	driver.findElement(By.xpath("//*[@id=\"cabecalho\"]/div[2]/div[2]/ul/li[2]/a/strong")).click();
	driver.findElement(By.xpath("//*[@id=\"listagemProdutos\"]/ul/li[1]/ul/li[3]/div/a")).click();
	driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[1]/div/div[1]/div[2]/div/div[2]/div[3]/a")).click();
	driver.findElement(By.name("quantidade")).sendKeys("300");
	driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[1]/div/div[2]/table/tbody/tr[1]/td[4]/form/div/button")).click();
	driver.findElement(By.id("usarCupom")).sendKeys("30REAIS");
	driver.findElement(By.id("btn-cupom")).click();
	driver.findElement(By.xpath("//*[@id=\"corpo\"]/div/div[1]/div/form/div/div[1]/button")).click();
	driver.findElement(By.xpath("//*[@id=\"pagamentoCartao\"]/span[2]/ul")).click();
	Thread.sleep(5000);
	driver.findElement(By.id("cartao_cartao_numero")).sendKeys("5110 9190 3056 9070");
	driver.findElement(By.id("cartao_cartao_data_expiracao")).sendKeys("1124");
	driver.findElement(By.id("cartao_cartao_nome")).sendKeys("Eduardo Luiz Silva");
	driver.findElement(By.id("cartao_cartao_cvv")).sendKeys("239");
	driver.findElement(By.id("cartao_dono_cartao_cpf")).sendKeys("367.622.030-78");
	driver.findElement(By.id("cartao_dono_cartao_data_nascimento")).sendKeys("19/12/1995");
	driver.findElement(By.id("cartao_dono_cartao_telefone")).sendKeys("(11) 55664-5454");
	driver.findElement(By.xpath("//*[@id=\"envio12015-retirar_pessoalmente\"]/label/span[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("cartao_cartao_parcelas"));
	driver.findElement(By.xpath("//*[@id=\"cartao_cartao_parcelas\"]/option[2]")).click();
	driver.findElement(By.id("finalizarCompra")).click();
	
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException { 
	Thread.sleep(5000);
	String texto =driver.findElement(By.cssSelector("#modalAlerta > div.modal-body")).getText();
	System.out.println(texto);
	assertEquals(texto, "Por favor, revise seus dados de pagamento e tente novamente. A compra não foi finalizada devido a algum problema na autorização. Se o erro persistir, tente uma forma de pagamento diferente ou verifique se pode ter ocorrido algum problema com a operadora, no caso de compra com cartão.");
	
	}

}
