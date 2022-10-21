package testdatautils;
import java.util.Properties;

/**
 * The Reason of this class is to get the test data inside the properties file
 * Of courses can be used directly in the page
 * But this to handle the "No Data" exception , if we are going to build a framework
 * Also there are many ways of the DDT such as reading from JSON files or Excel files and both could be used  *
 */

public class GettingPropertyData {
    private Properties properties;
    private static GettingPropertyData gettingPropertyData;

    private GettingPropertyData() {
        properties = PropertyConfiguration.loadPropertyFile("src/main/java/testdatautils/TestData.properties");
    }

    public static GettingPropertyData getInstance () {
        if(gettingPropertyData ==null) {
            gettingPropertyData =new GettingPropertyData();
        }
        return gettingPropertyData;
    }

    public String baseURL() {
        String property= properties.getProperty("BaseURL");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't  find the Base URL ") ;
    }

    public String newEmail() {
        String property= properties.getProperty("NewEmail");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find the New Email Entry ") ;
    }

    public String firstName() {
        String property= properties.getProperty("FirstName");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find the FirstName ") ;
    }

    public String lastName() {
        String property= properties.getProperty("LastName");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find the LastName ") ;
    }

    public String existedEmail() {
        String property= properties.getProperty("ExistedEmail");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find the Email ") ;
    }


    public String password() {
        String property= properties.getProperty("Password");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find any passwords ") ;
    }


    public String birthdateDay() {
        String property= properties.getProperty("BirthdateDay");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find any days entries ") ;
    }



    public String birthdateMonth() {
        String property= properties.getProperty("BirthdateMonth");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find any months entries ") ;
    }


    public String birthdateYear() {
        String property= properties.getProperty("BirthdateYear");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find any years entries ") ;
    }


    public String address() {
        String property= properties.getProperty("Address");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find any addresses ") ;
    }

    public String city() {
        String property= properties.getProperty("City");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find any cities ") ;
    }

    public String state() {
        String property= properties.getProperty("State");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find any States ") ;
    }

    public String zipCode() {
        String property= properties.getProperty("ZipCode");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find any ZIP Codes ") ;
    }

    public String country() {
        String property= properties.getProperty("Country");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find any Countries ") ;
    }

    public String mobilePhone() {
        String property= properties.getProperty("MobilePhone");
        if ( property != null ) return property;
        throw new RuntimeException("Couldn't find any Mobile Phones  ") ;
    }

}
