import Pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends RegistrationPage {
    @BeforeAll
    static void beforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="1020x800";
    }

    @Test
    void testDemoQAFull(){
        openPage();
        setFirstName("Имя");
        setLastName("Фамилия");
        setEmail("test@gmail.com");
        setGender("Male");
        setUserNumber("8999555667");
        setDateOfBirth("01","April","1904");
        setSubject("English");
        setHobbies("Sports");
        setPicture("XPath.jpeg");
        setAddress("Адрес");
        setState("NCR");
        setCity("Gurgaon");
        submit();

        checkFullResult("Имя Фамилия","test@gmail.com",
                "Male", "8999555667", "01 April,1904",
                "English", "Sports", "XPath.jpeg", "Адрес",
                "NCR Gurgaon");
    }
    @Test
    void testDemoQAShort(){
        openPage();
        setFirstName("Имя");
        setLastName("Фамилия");
        setGender("Male");
        setUserNumber("8999555667");
        submit();

        checkShortResult("Имя Фамилия",
                "Male", "8999555667");
    }
}
