package utils;

public class TestData {
    RandomUtils rU = new RandomUtils();
    public String gender = rU.getRandomGender();
    public String subject = rU.getRandomSubject();
    public String hobby = rU.getRandomHobby();
    public String state = rU.getRandomState();
    public String city = rU.getRandomCity(state);
    public String day = rU.getRandomDayOfBirth();
    public String month = rU.getRandomMonthOfBirth();
    public String year = rU.getRandomYearOfBirth();
    public String userNumber = rU.getRandomPhoneNumber();
    public String firstName = rU.getRandomFirstName();
    public String lastName = rU.getRandomLastName();
    public String email = rU.getRandomEmail();
    public String address = rU.getRandomAddress();
    public String picture = "XPath.jpeg";
}
