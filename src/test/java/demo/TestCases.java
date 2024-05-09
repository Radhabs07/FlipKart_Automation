package demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;




public class TestCases {
    private ChromeDriver driver;
    //private FluentWait<WebDriver> wait;
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
      Thread.sleep(2000);
     
      wrapper.enterText(By.xpath("//input[@type='text']"), "Washing Machine");

      wrapper.clickElement(By.xpath("//button[@type='submit']"));

      wrapper.clickElement(By.xpath("//div[@class='_5THWM1']//div[text()='Popularity']"));
      Thread.sleep(3000);

      List<WebElement> elementsWithRatingLessThanEqual4 = driver.findElements(By.xpath("//div[@class='_2kHMtA']//div[@class='_3LWZlK']"));

      int count=0;

      for(WebElement ratingElement : elementsWithRatingLessThanEqual4 ){

     // Thread.sleep(2000);
      //float rating = Float.parseFloat(ratingElement.findElement(By.xpath("//div[@class='_2kHMtA']//div[@class='_3LWZlK']")).getText());
      float rating = Float.parseFloat(ratingElement.getText());
      
         if(rating < 4.0){
             count++;
      
      }
    }
      System.out.println("print count of ratings less than 4: " + count);
      
      System.out.println("end Test case: testCase01");
      //assertEquals(0, count);
    }
  
  
  @Test
      public void testCase02() throws InterruptedException{
      System.out.println("Start Test case: testCase02");

      // WebDriverManager.chromedriver().setup();
      // ChromeDriver driver = new ChromeDriver();

      
      
    // Navigate to the website
   // driver.get("https://www.flipkart.com/");

    // Locate the search input and enter "iPhone"
   SeleniumWrapper wrapper=new SeleniumWrapper(driver);

   wrapper.enterText(By.xpath("//input[@type='text']"), "Iphone");
   wrapper.clickElement(By.xpath("//button[@type='submit']"));
  
    
    List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='_4rR01T']//div[@class='_3Ay6Sb']"));
    //System.out.println("Number of product tiles found: " + productNames.size());


    // Iterate through each product tile and extract information
    for (WebElement productName : productNames) {
        // // Get the title of the product
        // WebElement titleElement = productName.findElement(By.className("_4rR01T"));
        // //Thread.sleep(2000);
        // String title = titleElement.getText();

        // System.out.println("Product Name: " + title);

        // Get the discount percentage
        WebElement discountElement = productName.findElement(By.xpath("//div[@class='_3pLy-c row']//div[@class='_3Ay6Sb']"));
        //Thread.sleep(3000);

        String title=" ";
        int discount = 0;
        String discountText = discountElement.getText();
         discount = Integer.parseInt(discountText.replaceAll("[^0-9]", ""));

        // Print the title and discount percentage if discount is more than 17%
        if (discount >= 17) {

          WebElement titleElement = productName.findElement(By.xpath("//div[@class='_3pLy-c row']//div[@class='_4rR01T']"));
            System.out.println("Title: " + title);
            System.out.println("Discount: " + discount + "%");

        }
      }

            System.out.println("end Test case: testCase02");
    }
  

                           
        
     //@Test
     public void testCase03() throws InterruptedException{
     System.out.println("Start Test case: testCase03");

     //Navigate to the website
    // driver.get("https://www.flipkart.com/");

     SeleniumWrapper wrapper= new SeleniumWrapper(driver);
    

    // Locate the search input and enter "Coffee Mug"
      wrapper.enterText(By.xpath("//input[@type='text']"),"Coffee Mug");
      WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
     //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchButton);
     //Thread.sleep(2000);
      searchButton.click();

  
      try {
      List<WebElement> starCheckboxes = driver.findElements(By.xpath("//div[@class='_2d0we9']//div"));
      for (int i =0;i<starCheckboxes.size();i++) {
          String starsText =starCheckboxes.get(i).getText();

          if(starsText.contains("4")) {
            starCheckboxes.get(i).click();
              break;
          }
      }
      } catch (NoSuchElementException e) {
      System.out.println("Element not found: " + e.getMessage());
     }

      // Wait for filter to apply
      Thread.sleep(2000);

      // Get the list of products with reviews
      List<WebElement> products = driver.findElements(By.xpath("//span[@class='_2_R_DZ']"));//a[@class='s1Q9rs']
      int count=1;
      for (int i = 0; i < Math.min(5, products.size()); i++) {
          WebElement product = products.get(i);
          String title = product.findElement(By.xpath("(//a[@class='s1Q9rs'])[" + (count + 1) + "]]/a/div")).getText();
          String imageURL = product.findElement(By.xpath(".//div[@class='CXW8mj']/img")).getAttribute("src");
          System.out.println("Title: " + title);
          System.out.println("Image URL: " + imageURL);
      }

      
      System.out.println("End Test case: testCase03");

    // Close the WebDriver
       driver.quit();
}
}



     
    



    

  



      

    



      
    




