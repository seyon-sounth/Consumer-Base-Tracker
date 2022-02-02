// -----------------------------------------------------
// Assignment #1
// Part 1
// Written by: Seyon Sounthararajah (40005646)
// -----------------------------------------------------

/**
 * Consumer Class
 * @author seyonsounthararajah
 * @version 1.0
 */

package Part1;

public class Consumer {

    /**
     * Member Variables
     */
    private String name;
    private int streetNumber;
    private String streetName;
    private String city;
    private String postalCode;
    private int age;
    private String gender;

    // Counter for number of Consumer Objects
    private static int numberOfConsumers = 0;

    private MaritalStatus maritalStatus;
    private Education education;

    public enum MaritalStatus{
        SINGLE, MARRIED, WIDOWED, DIVORCED
    }

    public enum Education{
        ELEMENTARY,HIGHSCHOOL,CEGEP, UNIVERSITY
    }


    /**
     * default constructor
     */
    public Consumer() {
        this.name = null;
        this.streetNumber = 0;
        this.streetName = null;
        this.city = null;
        this.postalCode = null;
        this.age = 0;
        this.gender = null;

        maritalStatus = null;
        education = null;

        numberOfConsumers++;
    }


    /**
     * parametrized constructor
     * @param name is a String value
     * @param streetNumber is an int value
     * @param streetName is a String value
     * @param city is a String value
     * @param postalCode is a String value
     * @param age is an int value
     * @param gender is a String value
     * @param maritalStatus is an Enum value of type Marital Status
     * @param education is an Enum value of type of Education
     */
    public Consumer(String name, int streetNumber, String streetName, String city, String postalCode, int age, String gender, MaritalStatus maritalStatus, Education education) {
        this.name = name;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.age = age;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.education = education;

        numberOfConsumers++;

    }

    /**
     * copy constructor
     * @param other is a Consumer Object
     */
    public Consumer(Consumer other) {
        this.name = other.name;
        this.streetNumber = other.streetNumber;
        this.streetName = other.streetName;
        this.city = other.city;
        this.postalCode = other.postalCode;
        this.age = other.age;
        this.gender = other.gender;
        this.maritalStatus = other.maritalStatus;
        this.education = other.education;

        numberOfConsumers++;

    }



    /**
     * Getter
     * @return name a String value
     */
    public String getName() {
        return name;
    }

    /**
     * Getter
     * @return streetNumber an int value
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * Getter
     * @return streetName a String value
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Getter
     * @return city a String value
     */
    public String getCity() {
        return city;
    }

    /**
     * Getter
     * @return postalCode a String value
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Getter
     * @return age an int value
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter
     * @return gender a String value
     */
    public String getGender() {
        return gender;
    }


    /**
     * Getter
     * @return maritalStatus an enum value of type MaritalStatus
     */
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Getter
     * @return education an enum value of type Education
     */
    public Education getEducation() {
        return education;
    }

    /**
     * Setter
     * @param name is a String value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter
     * @param streetNumber is an int value
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * Setter
     * @param streetName is an String value
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Setter
     * @param city is a String value
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Setter
     * @param postalCode is a String value
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Settter
     * @param age is an int value
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Setter
     * @param gender is a String value
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Setter
     * @param maritalStatus is an enum value of type MaritalStatus
     */
    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * Setter
     * @param education is an enum value of type of Education
     */
    public void setEducation(Education education) {
        this.education = education;
    }

    /**
     * override toString() method from Object Class to display a clear description and information of the object
     * @return a String value
     */
    public String toString(){
        return "Consumer is named " + getName() + ", their address is " + getStreetNumber() + " " + getStreetName() + ", " + getCity() + ", " +  getPostalCode() +
                ". Consumer's age is " + getAge() + ", and gender is " + getGender() +
                ". Their current marital status is " + getMaritalStatus() + " and their education is " + getEducation()  + ".";

    }


    /**
     * This method must return total number of Consumer objects created prior to invocation of this method.
     * 0 if no Consumer has been created by the time the method is called
     * @return numberOfConsumers an int value
     */
    public static int getNumberOfConsumers(){
        return numberOfConsumers;
    }


    /**
     * equals method
     * @param o is an object of class type Object
     * @return boolean that represents the similarity between two Consumer objects
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consumer)) return false;

        Consumer consumer = (Consumer) o;

        if (age != consumer.age) return false;
        if (name != null ? !name.equals(consumer.name) : consumer.name != null) return false;
        if (gender != null ? !gender.equals(consumer.gender) : consumer.gender != null) return false;
        return education == consumer.education;
    }

}
