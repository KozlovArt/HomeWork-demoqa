package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    Faker faker = new Faker(new Locale("en"));
    public String getRandomFirstName(){
        return faker.name().firstName();
    }
    public String getRandomLastName(){
        return faker.name().lastName();
    }
    public String getRandomEmail(){
        return faker.internet().emailAddress();
    }
    public String getRandomAddress(){
        return faker.address().fullAddress();
    }
    public String getRandomGender(){
        return faker.options().option("Male", "Female", "Other");
    }
    public String getRandomSubject(){
        return faker.options().option("English", "Chemistry", "Commerce");
    }
    public String getRandomHobby(){
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getRandomState(){
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana","Rajasthan");
    }

    public String getRandomCity(String state){
        String[] cities;
        if (state.equals("NCR")){
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        }
        if (state.equals("Uttar Pradesh")){
            return faker.options().option("Agra", "Lucknow", "Merrut");
        }
        if (state.equals("Haryana")){
            return faker.options().option("Karnal", "Panipat");
        }
        if (state.equals("Rajasthan")){
            cities = new String[]{"Jaipur", "Jaiselmer"};
            return faker.options().option("Jaipur", "Jaiselmer");
        }
        return "";
    }
    public String getRandomDayOfBirth(){
        String[] days = {"01", "02", "03","04", "05", "06","07", "08", "09","10", "11", "12",
                "13", "14", "15","16", "17", "18", "19", "20"};
        return faker.options().option(days);
    }
    public String getRandomMonthOfBirth(){
        String[] months = {"January", "February", "March","April", "May", "June",
                "July", "August", "September","October", "November", "December"};
        return faker.options().option(months);
    }
    public String getRandomYearOfBirth(){
        return "" + faker.number().numberBetween(1900,2100);
    }

    public String getRandomPhoneNumber(){
        return faker.phoneNumber().subscriberNumber(10);
    }

}
