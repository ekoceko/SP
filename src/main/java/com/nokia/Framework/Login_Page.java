package com.nokia.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.nokia.Framework.Driver.*;

public class Login_Page implements Page_Interface {

    public static void goTo() {
        Driver.Instance.get(SPURL);
        Driver.Instance.manage().window().maximize() ;

    }
    public static LoginHelper loginWithUsername(String username){

        return new LoginHelper(username);
    }

    public static class LoginHelper {
        private static String username;
        private static String password;
        public LoginHelper(String username) {
            LoginHelper.username = username;
        }
        public LoginHelper withPassword(String password){
            LoginHelper.password =password;
            return this;
        }
        public void login(){
            WebElement username_w =  Driver.fwait(By.id("j_username"));
            WebElement password_w =  Driver.fwait(By.id("j_password"));
            WebElement login = Driver.fwait(By.id("submitButton"));
            username_w.sendKeys(username);
            password_w.sendKeys(password);
            login.click();

            String name = Driver.fwait(By.id("logo")).getText();

            Assert.assertEquals(name,"Service Portal","Failed to Login");
        }

    }
}
