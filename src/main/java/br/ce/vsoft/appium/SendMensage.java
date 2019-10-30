package br.ce.vsoft.appium;

import com.github.javafaker.Faker;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SendMensage {


        public void enviarMensagem() throws InterruptedException, MalformedURLException {

            String[] superPraticoList = {"SuperPratico - PB", "SuperPratico - GO", "SuperPratico - CE", "SuperPratico - AL", "SuperPratico - RN", "SuperPratico - PE" };

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("deviceName", "J2-Prime");
            desiredCapabilities.setCapability("automationName", "uiautomator2");
            desiredCapabilities.setCapability("appPackage", "com.whatsapp");
            desiredCapabilities.setCapability("appActivity", "com.whatsapp.HomeActivity");
            desiredCapabilities.setCapability("noReset", true);
            desiredCapabilities.setCapability("fullReset", false);


            AndroidDriver<MobileElement> driverM = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
            driverM.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            for (int i = 0; i < superPraticoList.length; i++ ){
                driverM.findElement(By.id("com.whatsapp:id/menuitem_search")).click();
                driverM.findElementById("com.whatsapp:id/search_src_text").sendKeys("SuperPratico");
                driverM.navigate().back();
                Thread.sleep(4000);
                driverM.findElement(By.xpath("//android.widget.TextView[@text='"+superPraticoList[i]+"']")).click();
                driverM.findElement(By.id("com.whatsapp:id/entry")).sendKeys("getLink");
                driverM.findElement(By.id("com.whatsapp:id/send")).click();
                driverM.findElement(By.id("com.whatsapp:id/back")).click();
            }
            driverM.quit();

    }

}
