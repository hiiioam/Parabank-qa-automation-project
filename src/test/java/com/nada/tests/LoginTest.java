package com.nada.tests;


import com.nada.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

      @Test
      @Tag("smoke")
    public void loginTestwithValidCredentialsShouldRedirectToOverviewAccounts(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.enterUsername("nada");
        loginPage.enterPassword("password");
        loginPage.clickOnLogin();
//        loginPage.login("nada","password");
        Assertions.assertEquals("ParaBank | Accounts Overview", driver.getTitle());

      }


      @ParameterizedTest
      @Tag("regression")
      @CsvSource({
              "nada, wrong", "wrong, password"
      })
    public void loginWithFalseCredentialsShouldShowErrorPage(String username, String password){
          LoginPage loginPage = new LoginPage(driver);
          loginPage.open();
          loginPage.enterUsername(username);
          loginPage.enterPassword(password);
          loginPage.clickOnLogin();
//          loginPage.login(username,password);
          Assertions.assertEquals("The username and password could not be verified.",loginPage.getErrorMessage());
      }
}
