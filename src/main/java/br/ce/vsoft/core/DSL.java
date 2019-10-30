package br.ce.vsoft.core;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DSL {

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
    public void clickButtonWeb(WebElement element) {
        element.click();
    }
    public void clickButton(WebElement element) {
        try {
            clickButtonWeb(element);
        } catch (Exception e) {
            waitElementDSL(3000);
            clickButtonWeb(element);
        }
    }
    public void waitElementDSL(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void readFile(WebElement element, String directory) throws IOException {
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(directory);
            br = new BufferedReader(fr);

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                element.sendKeys(line);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }

    }
    public void readFileTags(WebElement element, String directory) throws IOException {
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(directory);
            br = new BufferedReader(fr);

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                element.sendKeys(line);
                waitElementDSL(3000);
                element.sendKeys(Keys.ENTER);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }
    }
}
