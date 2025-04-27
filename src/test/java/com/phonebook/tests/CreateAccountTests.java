package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    SoftAssert softAssert = new SoftAssert();

    @Test(enabled = false) //пока отключаем этот тест, так как мы уже зарешались и чтоб тест не падал
    public void newUserRegistrationPositiveTest() {
        //int i = (int)((System.currentTimeMillis()/1000)%3600);
        //фиксирует текущее время
        ///1000)%3600) - сокращаем время
        app.getUser().clickOnLoginLink();
        //fillRegisterLoginForm(new User().setEmail("qwe"+i+"@asd.com").setPassword("ABSabs123!"));
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        //"qwe@asd.com" указать как "qwe"+i+"@asd.com"
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();
        softAssert.assertTrue(app.getUser().isAlertDisplayed());
        softAssert.assertTrue(app.getUser().isErrorMessagePresent());
        softAssert.assertAll();
    }


}
