package br.ce.vsoft.web;

import br.ce.vsoft.core.DSL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class CreationArticle {

        public void criarArtigo() throws InterruptedException, IOException {
            System.setProperty("webdriver.chrome.driver", "/home/israelrodrigues/Documentos/Mesa/appium/chromedriver");

            DSL dsl = new DSL();

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://atendimento.vsoft.com.br/Account/Login");


            WebElement username = driver.findElement(By.name("UserName"));
            WebElement password = driver.findElement(By.name("Password"));

            username.sendKeys("israelaraujo");
            password.sendKeys("Vsoft@123");

            Thread.sleep(2500);

            driver.findElement(By.id("btnSubmit")).click();

            Thread.sleep(5000);

            driver.findElement(By.xpath("(//span[@class='icon'])[11]")).click();

            Thread.sleep(2500);

            driver.findElement(By.xpath("(//li[@data-name='Artigos']/a)[1]")).click();

            Thread.sleep(2500);

            driver.findElement(By.xpath("(//button[@title='Novo artigo'])[1]")).click();

            Thread.sleep(2500);

            WebElement title = driver.findElement(By.name("Title"));
            dsl.readFile(title, "/home/israelrodrigues/Documentos/Mesa/appium/Conteudo/titulo.txt" );

            Thread.sleep(2500);


            driver.findElement(By.id("mceu_28-open")).click();

            String getLink = driver.findElement(By.xpath("(//span[@class='permalink'])[1]")).getText();

            driver.findElement(By.xpath("(//div[@role='menuitem'])[7]")).click();

            Thread.sleep(2500);

            WebElement bodyArtigo = driver.findElement(By.xpath("//textarea[@class='mce-textbox mce-multiline mce-abs-layout-item mce-first mce-last']"));
            dsl.readFile(bodyArtigo, "/home/israelrodrigues/Documentos/Mesa/appium/Conteudo/conteudoArtigo.txt");
            driver.findElement(By.xpath("//div[@class='mce-widget mce-btn mce-primary mce-abs-layout-item mce-first mce-btn-has-text']/button")).click();

            WebElement resumo = driver.findElement(By.name("Summary"));
            dsl.readFile(resumo, "/home/israelrodrigues/Documentos/Mesa/appium/Conteudo/resumo.txt");

            WebElement tags = driver.findElement(By.id("s2id_autogen22"));
            dsl.readFileTags(tags,"/home/israelrodrigues/Documentos/Mesa/appium/Conteudo/tags.txt" );

            driver.findElement(By.xpath("//button[@class='btn-mv btn-mv-default btn-save-draft']")).click();

            driver.quit();

        }



}
