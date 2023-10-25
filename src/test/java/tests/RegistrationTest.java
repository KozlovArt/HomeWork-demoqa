package tests;

import pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import utils.TestData;

public class RegistrationTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void testDemoQAFull(){
        TestData td = new TestData();
        registrationPage.openPage()
                .setFirstName(td.firstName)
                .setLastName(td.lastName)
                .setEmail(td.email)
                .setGender(td.gender)
                .setUserNumber(td.userNumber)
                .setDateOfBirth(td.day,td.month,td.year)
                .setSubject(td.subject)
                .setHobbies(td.hobby)
                .setPicture(td.picture)
                .setAddress(td.address)
                .setState(td.state)
                .setCity(td.city)
                .submit();

        registrationPage.checkResult("Student Name",td.firstName + " " + td.lastName)
                .checkResult("Student Email",td.email)
                .checkResult("Gender",td.gender)
                .checkResult("Mobile",td.userNumber)
                .checkResult("Date of Birth",td.day + " " + td.month + "," + td.year)
                .checkResult("Subjects",td.subject)
                .checkResult("Hobbies",td.hobby)
                .checkResult("Picture","XPath.jpeg")
                .checkResult("Address",td.address)
                .checkResult("State and City",td.state + " " + td.city);
    }
    @Test
    void testDemoQAShort(){
        TestData td = new TestData();
       registrationPage.openPage()
                .setFirstName(td.firstName)
                .setLastName(td.lastName)
                .setGender(td.gender)
                .setUserNumber(td.userNumber)
                .submit();

        registrationPage.checkResult("Student Name",td.firstName + " " + td.lastName)
                .checkResult("Gender",td.gender)
                .checkResult("Mobile",td.userNumber);
    }
}
