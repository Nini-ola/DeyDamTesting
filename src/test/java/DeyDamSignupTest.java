import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/** 1. Open the Chrome browser
 * 2. Input the URL
 * 3. Maximise the window
 * 4. Click on the sign in button
 * 5. Input your username in the username field
 * 6. Input your email address
 * 7. Input your password
 * 8. Confirm the password
 * 9. Click on the create account button
 * 10. Logout from the account
 * 11. Quit the browser
 */

/** 1. Verify the user input the right url and is on the right webpage
 * 2. Verify that when the user clicks on the signup button, the user is directed to the signup page
 * 3. Verify that user cannot sign up with username less than 4 characters
 * 4. Verify that user cannot sign up with invalid email address
 * 5. Verify that user cannot sign up with password less than 8 characters
 * 6. Verify that user cannot sign up with any field blank
 * 7. Verify that user cannot sign up with all fields blank
 * 8. Verify that user cannot sign up with wrong confirm password
 * 9. Verify that user is successfully signed up when valid details are used
 * 10. Verify that when the user logs out, he/she is directed back to login page
 **/

public class DeyDamSignupTest {

    //import the Selenium Webdriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open your Chrome browser
        driver = new ChromeDriver();
        Thread.sleep(5000);
        //2. Input your DeyDam url page (https://www.deydam.com)
        driver.get("https://www.deydam.com");
        //Test1. Verify the user input the right url and is on the right webpage
        if (driver.getCurrentUrl().contains("https://www.deydam.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong webpage");
        Thread.sleep(5000);
        //3. Maximise the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
        //4. Click on Create new account button to open the sign up page
        //Test2. Verify that when the user clicks on the signup button, the user is directed to the signup page
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div[4]/a")).click();
        String expectedUrl = "https://www.deydam.com/signup?ref=null";
        String actualUrl = driver.getCurrentUrl();
        if (driver.getCurrentUrl().contains("https://www.deydam.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong webpage");
        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void negativeUsername() throws InterruptedException {
        //5. Input your username in the username field
        //Test3. Verify that user cannot sign up with username less than 4 characters
        driver.findElement(By.id("username")).sendKeys("eni");
        Thread.sleep(5000);
        //6. Input email address in the email address field
        driver.findElement(By.id("email")).sendKeys("dattesta@mailinator.com");
        Thread.sleep(5000);
        //7. Input password in password field
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admindatesta");
        //8. Input password in the confirm password field
        driver.findElement(By.id("confirmPassword")).sendKeys("admindatesta");
        Thread.sleep(5000);
        //9. Click the create account button
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).clear();
    }

    @Test(priority = 1)
    public void negativeEmail() throws InterruptedException {
        //5. Input your username in the username field
        driver.findElement(By.id("username")).sendKeys("Eniola");
        Thread.sleep(5000);
        driver.findElement(By.id("email")).clear();
        //6. Input email address in the email address field
        //Test4. Verify that user cannot sign up with invalid email address
        driver.findElement(By.id("email")).sendKeys("dattesta.mailinator.com");
        Thread.sleep(5000);
        //7. Input password in password field
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admindatesta");
        //8. Input password in the confirm password field
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("admindatesta");
        Thread.sleep(5000);
        //9. Click the create account button
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).clear();
    }

    @Test(priority = 2)
    public void negativePassword() throws InterruptedException {
        //5. Input your username in the username field
        driver.findElement(By.id("username")).sendKeys("Eniiola");
        Thread.sleep(5000);
        //6. Input email address in the email address field
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("dattestar@mailinator.com");
        Thread.sleep(5000);
        //7. Input password in password field
        //Test5. Verify that user cannot sign up with password less than 8 characters
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admin");
        //8. Input password in the confirm password field
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("admindatesta");
        Thread.sleep(5000);
        //9. Click the create account button
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).clear();
    }

    @Test(priority = 3)
    public void negativeEmpty() throws InterruptedException {
        //5. Input your username in the username field
        driver.findElement(By.id("username")).sendKeys("Eniolla");
        Thread.sleep(5000);
        //6. Input email address in the email address field
        //Test6. Verify that user cannot sign up with any field blank
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("");
        Thread.sleep(5000);
        //7. Input password in password field
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admin");
        //8. Input password in the confirm password field
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("admindatesta");
        Thread.sleep(5000);
        //9. Click the create account button
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).clear();
    }

    @Test(priority = 4)
    public void negativeEmpties() throws InterruptedException {
        //.Test7. Verify that user cannot sign up with all fields blank
        //5. Input your username in the username field
        driver.findElement(By.id("username")).sendKeys("");
        Thread.sleep(5000);
        //6. Input email address in the email address field
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("");
        Thread.sleep(5000);
        //7. Input password in password field
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("");
        //8. Input password in the confirm password field
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("");
        Thread.sleep(5000);
        //9. Click the create account button
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).clear();
    }

    @Test(priority = 5)
    public void negativeConfirm() throws InterruptedException {
        //.Test8. Verify that user cannot sign up with wrong confirm password
        //5. Input your username in the username field
        driver.findElement(By.id("username")).sendKeys("Niniola");
        Thread.sleep(5000);
        //6. Input email address in the email address field
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("niniolatesttt@mailinator.com");
        Thread.sleep(5000);
        //7. Input password in password field
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("ninitest1");
        //8. Input password in the confirm password field
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("ninitest");
        Thread.sleep(5000);
        //9. Click the create account button
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).clear();
    }

    @Test(priority = 6)
    public void positiveSignup() throws InterruptedException {
        //Test8. Verify that user is successfully signed up when valid details are used
        //5. Input your username in the username field
        driver.findElement(By.id("username")).sendKeys("EniolaTest");
        Thread.sleep(5000);
        //6. Input email address in the email address field
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("eniolatest@mailinator.com");
        Thread.sleep(5000);
        //7. Input password in password field
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admineniola");
        //8. Input password in the confirm password field
        driver.findElement(By.id("confirmPassword")).clear();
        driver.findElement(By.id("confirmPassword")).sendKeys("admineniola");
        Thread.sleep(5000);
        //9. Click the create account button
        driver.findElement(By.xpath("/html/body/div/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("username")).clear();
    }

    @AfterTest
    public void closeBrowser() {
        //9. Quit the browser
        driver.quit();
    }
}
