public class Person {
    private String firstName;
    private String lastName;
    Person(String firstN, String lastN){
        firstName = firstN;
        lastName = lastN;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}