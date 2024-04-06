package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    private ChromeDriver driver;
    private SeleniumWrapper seleniumWrapper;

    //@BeforeClass
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

   //@AfterClass
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

     @Test
      public void testCase01() throws InterruptedException{
      System.out.println("Start Test case: testCase01");

      driver.get("https://www.flipkart.com");
      SeleniumWrapper wrapper= new SeleniumWrapper(driver);
     
      wrapper.enterText(By.xpath("//input[@type='text']"), "Washing Machine");

      wrapper.clickElement(By.xpath("//button[@type='submit']"));

      wrapper.clickElement(By.xpath("//div[@class='_5THWM1']//div[text()='Popularity']"));
      Thread.sleep(3000);

      List<WebElement> elementsWithRatingLessThanEqual4 = driver.findElements(By.xpath("//div[@class='_2kHMtA']//div[@class='_3LWZlK']"));
      int count=0;
      for(WebElement ratingElement:elementsWithRatingLessThanEqual4 ){

      Thread.sleep(2000);
      float rating = Float.parseFloat(ratingElement.findElement(By.xpath("//div[@class='_2kHMtA']//div[@class='_3LWZlK']")).getText());

      if(rating<=4.0){
        count++;
  
      }
        
      }
      System.out.println("print count of ratings less than 4 : " + count);
      System.out.println("end Test case: testCase01");
    }
  

  @Test
      public void testCase02() throws InterruptedException{
      System.out.println("Start Test case: testCase02");

      
    // Navigate to the website
    driver.get("https://www.flipkart.com/");

    // Locate the search input and enter "iPhone"
    WebElement searchInput = driver.findElement(By.name("q"));
    searchInput.sendKeys("iPhone");
    searchInput.submit();

    // Find all product tiles on the page
    List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='_4rR01T']//div[@class='_3Ay6Sb']"));

    // Iterate through each product tile and extract information
    for (WebElement productName : productNames) {
        // Get the title of the product
        WebElement titleElement = productName.findElement(By.className("_4rR01T"));
        Thread.sleep(2000);
        String title = titleElement.getText();

        // Get the discount percentage
        WebElement discountElement = productName.findElement(By.className("_3Ay6Sb"));
        Thread.sleep(3000);
        String discountText = discountElement.getText();
        int discount = Integer.parseInt(discountText.replaceAll("[^0-9]", ""));

        // Print the title and discount percentage if discount is more than 17%
        if (discount > 17) {
            System.out.println("Title: " + title);
            System.out.println("Discount: " + discount + "%");

            System.out.println("end Test case: testCase02");
        }
      }
    }


    // @Test
    //   public void testCase03() throws InterruptedException{
    //   System.out.println("Start Test case: testCase03");

      
    // // Navigate to the website
    // driver.get("https://www.flipkart.com/");

    // // Locate the search input and enter "Coffee Mug"
    // WebElement searchInput = driver.findElement(By.xpath("div[@class='_3OO5Xc']/input[@value='Coffee Mug']"));
    // searchInput.sendKeys("Coffee Mug");
    // searchInput.submit();

    // List<WebElement> productNames1 = driver.findElements(By.xpath("//div[@class='_4rR01T']//div[@class='_3Ay6Sb']"));



    


      //}
  }
    



      

    



      
    




