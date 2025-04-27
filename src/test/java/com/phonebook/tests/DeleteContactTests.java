package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {
    //precondition
    //login
    @BeforeMethod
    public void precondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        //add contact
        //click on Add Link
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillContactForm(new Contact().setName(ContactData.NAME).setLastName(ContactData.LAST_NAME).setPhone(ContactData.PHONE).setEmail(ContactData.EMAIL).setAddress(ContactData.ADDRESS).setDisctiption(ContactData.DESCRIPTION));
        //click on Save button
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void deleteContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().deleteContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        //verify contact is deleted(by size)
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

}
