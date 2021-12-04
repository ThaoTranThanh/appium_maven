package test.authentication;

import driver.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import models.components.global.BottomNavComponent;
import models.pages.LoginPage;

public class LoginTest {
    public static void main(String[] args) {
        DriverFactory.startAppiumServer();
        try{
            AndroidDriver<MobileElement> androidDriver = DriverFactory.getAndroidDriver();
            //Login page
            LoginPage loginPage = new LoginPage(androidDriver);
            //Bottom Nav Comp
            BottomNavComponent bottomNavComponent = loginPage.bottomNavComponent();
            bottomNavComponent.clickOnLoginLabel();

            //Fill Login Form
            loginPage
                    .inputUsername("autotest@mailinator.com")
                    .inputPassword("98765432")
                    .clickOnLoginBtn();
            String loginMsg = loginPage.loginDialogComponent().msgTitle();
            String popupContent = loginPage.loginDialogComponent().msgContent();
            System.out.println(loginMsg);
            System.out.println(popupContent);

        }catch(Exception e){
            e.printStackTrace();

        }finally {
            DriverFactory.stopAppiumServer();
        }

    }
}
