/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evgabotbuyer;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;





public class EVGABotBuyer {

    
    /*
    public static void playMusic(String filepath)
    {
        InputStream music;
        try
        {
            music = new FileInputStream(new File(filepath));
            AudioStream audios =  new AudioStream(music);
            AudioPlayer.player.start(audios);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    */
    
    
    public static void main(String[] args) throws InterruptedException {
        
        
        
        String operatingSystem = System.getProperty("os.name").toLowerCase();
        
        //Gets the proper driver from root directory which would allow us to do this test
        if(operatingSystem.contains("mac")) System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
        else System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
        
        //Allows for driver to work on Google Chrome and opens Google Chrome up
        WebDriver driver = new ChromeDriver();
        
        /*
        Creating a WebDriverWait which will allow for wait functions. Variable will determine
        the duration of the wait before failing the test
        */
        long waitTime = 10000000;
        WebDriverWait wait = new WebDriverWait(driver, waitTime); 
        
        //The website that is being tested
        String url = "https://secure.evga.com/US/login.asp";
        
        //optional loginfo. should do it manually
        String username = "username here";
        String password = "password here";
        
        driver.get(url);
        
        //put in login
        driver.findElement(By.id("evga_login")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"EVGAContent\"]/div/div/div/div[1]/form/div/div[1]/table/tbody/tr[2]/td[2]/input")).sendKeys(password);
        
        //time to do captcha
        //TimeUnit.SECONDS.sleep(80);
        
        //go to the 3080 page. it's 2060 right now. MAKE SURE TO CHANGE THIS
        String cardPage = "https://www.evga.com/products/productlist.aspx?type=0&family=GeForce+16+Series+Family&chipset=GTX+1650+Super";
        driver.get(cardPage);
        
        /*
        //click on desired GPU
        try
        {
            //driver.findElement(By.xpath("//input[@title='Add 08G-P4-3175-KR to cart']")).click();
            //LFrame_prdList_rlvProdList_ctrl0_btnAddCart_0
            wait.until(ExpectedConditions.elementToBeClickable(By.id("LFrame_prdList_rlvProdList_ctrl0_btnAddCart_0")));
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div/div/div[3]/div[4]/div/div[5]/div[2]/div[2]/div[3]/div[2]/input")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        //driver.findElement(By.xpath("/html/body/form/div[3]/div/div/div[3]/div[4]/div/div[5]/div[2]/div[2]/div[3]/div[2]/input")).click();
        driver.findElement(By.id("LFrame_prdList_rlvProdList_ctrl0_btnAddCart_0")).click();
        
        */
        
        
        while(true)
        {
            try
            {
               TimeUnit.SECONDS.sleep(5);
               //"//*[contains(text(), 'My Button')]"
               driver.findElement(By.cssSelector("[title*='to cart']")).click();
               //driver.findElement(By.xpath("//*[contains(text(), 'to cart')]")).click();
               break;
            }
            catch(Exception e)
            {
                driver.get(cardPage);
            }
            
        }
        
        
        
        
        TimeUnit.SECONDS.sleep(3);
        System.out.println("click on gpu");
        //click on "go to checkout"
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div/div/div[3]/div[3]/div[2]/input[3]")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/form/div[3]/div/div/div[3]/div[3]/div[2]/input[3]")).click();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("go to checkout");
        //click on "yes"
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div/div[4]/div[1]/div[2]/p[2]/label[1]/input")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div/div[4]/div[1]/div[2]/p[2]/label[1]/input")).click();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("click on yes");
        
        //click on "continue"
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div/div[4]/div[1]/div[3]/div[3]/input[2]")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div/div[4]/div[1]/div[3]/div[3]/input[2]")).click();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("click on continue");
        
        //UNHIGHLIGHT THIS
        //driver.get("https://secure.evga.com/Cart/Checkout_Payment.aspx");
        
        JavascriptExecutor js = ((JavascriptExecutor) driver);
js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
Thread.sleep(5000);
        
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='button' and @value='Continue' and @onclick='ChoiceAddress()']")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("//input[@type='button' and @value='Continue' and @onclick='ChoiceAddress()']")).click();
        TimeUnit.SECONDS.sleep(3);
        
        
        


        //check the accept box
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div/div[4]/div[1]/div[5]/p[1]/input")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div/div[4]/div[1]/div[5]/p[1]/input")).click();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("accept box");
        
        //click "continue"
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div/div[4]/div[1]/div[5]/div[2]/p/input[2]")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div/div[4]/div[1]/div[5]/div[2]/p/input[2]")).click();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("yo");


System.exit(0);
        //click paypal option
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div[3]/div/div[1]/div[5]/div[1]/div[6]/div[1]/div[2]/div/div/div[2]/input[2]")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div/div[1]/div[5]/div[1]/div[6]/div[1]/div[2]/div/div/div[2]/input[2]")).click();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("yo");
        //click "continue"
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div[3]/div/div[1]/div[5]/div[1]/div[6]/div[2]/div[1]/input")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div/div[1]/div[5]/div[1]/div[6]/div[2]/div[1]/input")).click();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("yo");
        //click "continue" again
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div[3]/div/div[1]/div[5]/div[4]/div/div[2]/input[2]")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div/div[1]/div[5]/div[4]/div/div[2]/input[2]")).click();
        TimeUnit.SECONDS.sleep(3);

        
        
        
        //enter email
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section[2]/div/div/form/div[3]/div[1]/div[2]/div[1]/input")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/form/div[3]/div[1]/div[2]/div[1]/input")).sendKeys("email here");
        TimeUnit.SECONDS.sleep(3);
        
        //click next
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section[2]/div/div/form/div[3]/div[2]/button")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/form/div[3]/div[2]/button")).click();
        TimeUnit.SECONDS.sleep(3);
        
        
        //click pw
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section[2]/div/div/form/div[4]/div[1]/div/div/div[1]/input")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/form/div[4]/div[1]/div/div/div[1]/input")).sendKeys("password here");
        
        TimeUnit.SECONDS.sleep(3);
        //click "log in"
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/section[2]/div/div/form/div[4]/div[4]/button")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/form/div[4]/div[4]/button")).click();
        
        
        TimeUnit.SECONDS.sleep(3);
        //click "continue"
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/main/div[8]/div/button")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div[8]/div/button")).click();
        
        TimeUnit.SECONDS.sleep(3);
        //check agree box
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div/div[3]/table/tbody/tr/td/div/div[5]/p[1]/input")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div/div[3]/table/tbody/tr/td/div/div[5]/p[1]/input")).click();
        
        
        
        
        
        //DANGER ALERT, DO NOT UNHIGHLIGHT BELOW UNLESS YOU ARE SURE
        
        /*
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div/div[3]/table/tbody/tr/td/div/div[5]/p[2]/input")));
        }
        catch(Exception e)
        {
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/form/div[3]/div[3]/div[1]/div/div[3]/table/tbody/tr/td/div/div[5]/p[2]/input")).click();
        */
        
        
        
        
    }
    
}
