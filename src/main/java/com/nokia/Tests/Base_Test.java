package com.nokia.Tests;



import com.nokia.Framework.Driver;
import com.nokia.Framework.Login_Page;
import org.testng.annotations.*;


public class Base_Test {

    @BeforeTest
    public void Init(){
        Driver.Initialize();
    }
    @Test
    public static void Login() {
        Login_Page.goTo();
        Login_Page.loginWithUsername("webadmin").withPassword("5620Sam!").login();
    }
    @AfterTest
    public void Close(){
        Driver.Quit();
    }
}
