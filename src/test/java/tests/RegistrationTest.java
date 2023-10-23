package tests;

import pages.BaseTest;
import pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void testDemoQAFull(){
        registrationPage.openPage()
                .setFirstName("Имя")
                .setLastName("Фамилия")
                .setEmail("test@gmail.com")
                .setGender("Male")
                .setUserNumber("8999555667")
                .setDateOfBirth("01","April","1904")
                .setSubject("English")
                .setHobbies("Sports")
                .setPicture("XPath.jpeg")
                .setAddress("Адрес")
                .setState("NCR")
                .setCity("Gurgaon")
                .submit();

        registrationPage.checkResult("Student Name","Имя Фамилия")
                .checkResult("Student Email","test@gmail.com")
                .checkResult("Gender","Male")
                .checkResult("Mobile","8999555667")
                .checkResult("Date of Birth","01 April,1904")
                .checkResult("Subjects","English")
                .checkResult("Hobbies","Sports")
                .checkResult("Picture","XPath.jpeg")
                .checkResult("Address","Адрес")
                .checkResult("State and City","NCR Gurgaon");
    }
    @Test
    void testDemoQAShort(){
        registrationPage.openPage()
                .setFirstName("Имя")
                .setLastName("Фамилия")
                .setGender("Male")
                .setUserNumber("8999555667")
                .submit();

        registrationPage.checkResult("Student Name","Имя Фамилия")
                .checkResult("Gender","Male")
                .checkResult("Mobile","8999555667");
    }
}