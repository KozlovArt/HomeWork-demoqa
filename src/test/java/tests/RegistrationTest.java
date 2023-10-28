package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.RegistrationPage;

import java.util.List;
import java.util.stream.Stream;


public class RegistrationTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @CsvSource({"Vasia, Petrov, Male, 1234567890",
                "Petr, Ivanov, Male, 9876543210"})
    @ParameterizedTest(name = "Registration for {0} {1} {2} {3}")
    @Tag("One")
    void testDemoQAShort1(String name, String surname, String gender, String number){

       registrationPage.openPage()
                .setFirstName(name)
                .setLastName(surname)
                .setGender(gender)
                .setUserNumber(number)
                .submit();

        registrationPage.checkResult("Student Name",name + " " + surname)
                .checkResult("Gender",gender)
                .checkResult("Mobile",number);
    }
    @CsvFileSource(resources = "/Data.csv")
    @ParameterizedTest(name = "Registration for {0} {1} {2} {3}")
    @Tag("Two")
    void testDemoQAShort2(String name, String surname, String gender, String number){

        registrationPage.openPage()
                .setFirstName(name)
                .setLastName(surname)
                .setGender(gender)
                .setUserNumber(number)
                .submit();

        registrationPage.checkResult("Student Name",name + " " + surname)
                .checkResult("Gender",gender)
                .checkResult("Mobile",number);
    }
    static Stream<Arguments> testDemoQAShort3() {
        return Stream.of(
                Arguments.of(List.of("Vasia", "Petrov", "Male", "1234567890")),
                Arguments.of(List.of("Petr", "Ivanov", "Male", "9876543210"))
        );
    }
    @MethodSource("testDemoQAShort3")
    @ParameterizedTest(name = "Registration for {0}")
    @Tag("Three")
    void testDemoQAShort3(List<String> data){

        registrationPage.openPage()
                .setFirstName(data.get(0))
                .setLastName(data.get(1))
                .setGender(data.get(2))
                .setUserNumber(data.get(3))
                .submit();

        registrationPage.checkResult("Student Name",data.get(0) + " " + data.get(1))
                .checkResult("Gender",data.get(2))
                .checkResult("Mobile",data.get(3));
    }
}
