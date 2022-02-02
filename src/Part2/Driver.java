// -----------------------------------------------------
// Assignment #1
// Part 2
// Written by: Seyon Sounthararajah (40005646)
// -----------------------------------------------------

/**
 * Driver Class for program that helps companies keep track of their consumer base.
 * @author seyonsounthararajah
 * @version 1.0
 */


package Part2;
import Part1.Consumer;

//Import Scanner class
import java.util.Scanner;

public class Driver {

    private static int counterOption1Terminator = 0; // max 3 for 12
    private static int maximumNumberOfConsumersConverted;
    private static Consumer[] consumerDatabase;

    public static void main(String[] args) {

        System.out.println("Welcome to our Program. We help keep track of your consumer base of your company");
        Scanner scanner = new Scanner(System.in);

        //Prompt the user for maximum number of consumers the company can handle.
        System.out.println("What is the maximum number of consumers that your company can handle?");
        String maximumNumberOfConsumers = scanner.nextLine();
        maximumNumberOfConsumersConverted = Integer.parseInt(maximumNumberOfConsumers);

        //Create an empty array, called consumerDatabase that will keep track of created Consumer objects.
        consumerDatabase = new Consumer[maximumNumberOfConsumersConverted];

//        scanner.close();

        displayMainMenu();




    }

    /**
     * A static void method that displays the main menu of the program
     */
    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        String userInputMainMenu;
        int userInputMainMenuConverted; //Variable that stores user input

        do {
            //Display a main menu (figure 1) with the following choices and keep prompting the user until they enter a number between 1 and 5 inclusive:
            System.out.println("What do you want to do?");
            System.out.println("1. Enter a new Consumer (password required)");
            System.out.println("2. Change information of a Consumer (password required)");
            System.out.println("3. Display all Consumers similar to a given consumer");
            System.out.println("4. Display all Consumers with given age and location");
            System.out.println("5. Quit");
            System.out.println("Please enter your choice>");


            //Variable that stores user input
            userInputMainMenu = scanner.nextLine();
            userInputMainMenuConverted = Integer.parseInt(userInputMainMenu);

            //Check if user input is valid. Provide error message to indicate invalid input
            if (userInputMainMenuConverted < 1 || userInputMainMenuConverted > 5) {
                System.out.println("Invalid Input. Please Try again");
            }

        } while (userInputMainMenuConverted < 1 || userInputMainMenuConverted > 5); // Infinte loops until valid input (No Limit)


        //Outside the loop
        switch (userInputMainMenuConverted) {
            case 1:
                option1();
                break;
            case 2:
                option2();
                break;
            case 3:
                option3();
                break;
            case 4:
                option4();
                break;
            case 5:
                option5();
                break;
        }

    }


    /**
     * Static method that check if password input by user is correct
     * @return booean value
     */
    public static boolean verifyPassword3times() {
        Scanner scanner = new Scanner(System.in);
        final String adminPassword = "password";
        int passwordAttempts = 0; // Counter for password input

        do {
            System.out.println("Password: ");
            String userInputedPassword = scanner.nextLine(); //Reads Line for input, should it be **CHECK***** ASK teacher why next vs nextLine

            //If user input is invalid
            if (adminPassword.equals(userInputedPassword)) {
                break;
            } else {
                System.out.println("Wrong Password! Please try again.");
                passwordAttempts++;

            }if (passwordAttempts == 3) {//User Input is invalid 3 times
                System.out.println("It's been 3 tries");
                return false;
            }
        } while (passwordAttempts < 3) ;

        return true;

    }

    /**
     * Static void method for option 1 in the main menu
     * 1. Enter a new Consumer (password required)
     */
    public static void option1() {

        do {

            System.out.println("1. Enter a new Consumer (password required)");
            System.out.println("-----------------------------------------------------------");


            // Check 3 times for valid user input
            //If password input is valid
            if (verifyPassword3times()) {
                //ask the user how many consumers he/she wants to enter
                System.out.println("How many consumers would you like to enter?");
                Scanner scanner = new Scanner(System.in);
                String numberOfConsumersToEnter = scanner.nextLine();
                int numberOfConsumersToEnterConverted = Integer.parseInt(numberOfConsumersToEnter);


                if(numberOfConsumersToEnterConverted<0){
                    System.out.println("Error: Please enter a positive integer");
                    displayMainMenu();
                }

                //Check to make sure that there is enough space in the consumerDatabase (array of Consumers)
                if(maximumNumberOfConsumersConverted >=numberOfConsumersToEnterConverted){

                    // ******** ASK QUESTION: Is this dynamic, as in will it keep track previously entered consumers or not??


                    // Add Consumer objects to the ConsumerDatabase array
                    for (int i = 0; i < numberOfConsumersToEnterConverted; i++) {
                        System.out.println("Please input the following information about consumer "+ (i+1) );



                        System.out.println("Enter Name: ");
                        String name = scanner.nextLine();


                        System.out.println("Enter Street number: ");
                        String streetNumber = scanner.nextLine();
                        int streetNumberConverted = Integer.parseInt(streetNumber);

                        System.out.println("Enter Street name: ");
                        String streetName = scanner.nextLine();

                        System.out.println("Enter City name: ");
                        String city = scanner.nextLine();

                        System.out.println("Enter Postal Code: ");
                        String postalCode = scanner.nextLine();

                        System.out.println("Enter Age: ");
                        String age = scanner.nextLine();
                        int ageConverted = Integer.parseInt(age);

                        String inputNewGenderChoice;
                        int inputNewGenderChoiceConverted;
                        String gender = "";


                        do {
                            // make the changes to the attribute
                            System.out.println("Enter Gender (Input number 1 to 3)");
                            System.out.println("1. Male" + "\n2. Female" + "\n3. Other");
                            inputNewGenderChoice = scanner.nextLine();
                            inputNewGenderChoiceConverted = Integer.parseInt(inputNewGenderChoice);

                            switch (inputNewGenderChoiceConverted){
                                case 1:
                                    gender = "Male";
                                    break;
                                case 2:
                                    gender = "Female";
                                    break;
                                case 3:
                                    gender = "Other";
                                    break;
                                default:
                                    System.out.println("Invalid Input. Please try again.");
                                    break;
                            }

                        }while (inputNewGenderChoiceConverted<1 ||inputNewGenderChoiceConverted>3);



                        //Marital Status
                        String inputNewMaritalStatusChoice;
                        int inputNewMaritalStatusChoiceConverted;
                        Consumer.MaritalStatus maritalStatus = null;
                        do {
                            System.out.println("Enter Marital Status (Input number 1 to 4) :");
                            System.out.println("1. Single" + "\n2. Married" + "\n3. Widowed" + "\n4. Divorced" );
                            String maritalStatusChoice = scanner.nextLine();
                            inputNewMaritalStatusChoiceConverted = Integer.parseInt(maritalStatusChoice);

                            switch (inputNewMaritalStatusChoiceConverted) {
                                case 1:
                                    maritalStatus = Consumer.MaritalStatus.SINGLE;
                                    break;
                                case 2:
                                    maritalStatus = Consumer.MaritalStatus.MARRIED;
                                    break;
                                case 3:
                                    maritalStatus = Consumer.MaritalStatus.WIDOWED;
                                    break;
                                case 4:
                                    maritalStatus = Consumer.MaritalStatus.DIVORCED;
                                    break;
                                default:
                                    System.out.println("Invalid Input. Please try again.");
                                    break;
                            }
                        } while (inputNewMaritalStatusChoiceConverted<1 || inputNewMaritalStatusChoiceConverted>4);




                        //Education Level
                        String inputEducationChoice;
                        int inputEducationChoiceConverted;
                        Consumer.Education education = null;

                        do {
                            System.out.println("Enter Education Level (Input number 1 to 4) :");
                            System.out.println("1. ELEMENTARY" + "\n2. HIGHSCHOOL" + "\n3. CEGEP" + "\n4. UNIVERSITY" );

                            inputEducationChoice = scanner.nextLine();
                            inputEducationChoiceConverted = Integer.parseInt(inputEducationChoice);


                            switch (inputEducationChoiceConverted) {
                                case 1:
                                    education = Consumer.Education.ELEMENTARY;
                                    break;
                                case 2:
                                    education = Consumer.Education.HIGHSCHOOL;
                                    break;
                                case 3:
                                    education = Consumer.Education.CEGEP;
                                    break;
                                case 4:
                                    education = Consumer.Education.UNIVERSITY;
                                    break;
                                default:
                                    System.out.println("Invalid Input. Please try again.");
                                    break;
                            }
                        } while (inputEducationChoiceConverted<1 || inputEducationChoiceConverted>4);


                        Consumer consumer = new Consumer(name,streetNumberConverted,streetName,city,postalCode,ageConverted,gender,maritalStatus,education);
                        consumerDatabase[i] =  consumer;
                    }

                    displayMainMenu();

                }


                //Not enough space
                else{
                    System.out.println("Error: You can only add the number of remaining places in the array");
                    //******* NOT CLEAR FOR NEXT STEP: SHOULD I GO BACK TO THE MAIN MENU????
                    displayMainMenu();

                }
                //If password input is invalid
            } else {
                counterOption1Terminator++;

                // If not on the 12 try, then go back to main menu
                if (counterOption1Terminator != 3) {
                    displayMainMenu();
                }

                // After 12th try, terminate program
                if (counterOption1Terminator == 3) {
                    System.out.println("Program has detected suspicious activity and will terminate immediately");
                    option5(); //Quits program
                }
            }

        } while (counterOption1Terminator<3); // While condition is irrelevant, as soon it is 3, program exits, so in this case, it can replaced with any infinite loop
    }

    /**
     * static void method that display a given consumer's attributes (Method used in Option 1 and 2 from Main Menu)
     * @param consumerToUpdate is an int value
     */
    public static void displayConsumer(int consumerToUpdate){
        //If the consumer is present, display the current information of that consumer in the following format
        System.out.println("Consumer: #"+ consumerToUpdate + " (index of the consumer in the consumerDatabase array)");
        System.out.println("Name: "+ consumerDatabase[consumerToUpdate].getName());
        System.out.println("Location: "+ consumerDatabase[consumerToUpdate].getStreetNumber()+ ", " + consumerDatabase[consumerToUpdate].getStreetName()+ ", " + consumerDatabase[consumerToUpdate].getCity() + ", " + consumerDatabase[consumerToUpdate].getPostalCode());
        System.out.println("Age: " + consumerDatabase[consumerToUpdate].getAge());
        System.out.println("Gender: " + consumerDatabase[consumerToUpdate].getGender());
        System.out.println("Marital Status: " + consumerDatabase[consumerToUpdate].getMaritalStatus()); //***CHECK****
    }

    /**
     * Static void method for option 2 in the main menu
     *  2. Change information of a Consumer (password required)
     *  You may change the following attributes such as:
         *  1. Consumer name
         *  2. Location
         *  3. Age
         *  4. Gender
         *  5. Marital Status
     **/
    public static void option2() {

        System.out.println("2. Change information of a Consumer (password required)");
        System.out.println("-----------------------------------------------------------");

        // Check 3 times for valid user input
        //If password input is valid
        if (verifyPassword3times()){
            System.out.println("Which Consumer do you wish to update? (Enter index) ");

            Scanner scanner = new Scanner(System.in); //Create scanner object to read user input
            String consumerToUpdate = scanner.nextLine();
            int consumerToUpdateConverted = Integer.parseInt(consumerToUpdate);


            //If there is no Consumer at the specified index location,display a message
            // asking user if he/she wishes to re-enter another consumer,
            // or quit this operation and go back to the main menu
            if(consumerDatabase[consumerToUpdateConverted]== null || consumerToUpdateConverted> maximumNumberOfConsumersConverted || consumerToUpdateConverted<0){

                String option2Menu;
                int option2MenuConverted;

                do {
                    System.out.println("There is no Consumer at the specified index location");
                    System.out.println("1. Would you like to update another Consumer? (Enter index)");
                    System.out.println("2. Go back to menu");
                    System.out.println("Please enter your choice>");

                    option2Menu = scanner.nextLine();

                    option2MenuConverted = Integer.parseInt(option2Menu);

                    switch (option2MenuConverted) {
                        case 1:
                            option2();
                        case 2:
                            displayMainMenu();
                    }

                } while (option2MenuConverted!=1 || option2MenuConverted!=2);

            }

            //If the consumer is present, display the current information of that consumer in the following format
            displayConsumer(consumerToUpdateConverted);



            String whichAttributeToChange;
            int whichAttributeToChangeConverted;

            do{
                //Then ask the user which attribute they wish to change by displaying the following menu. This will repeat until user input value from 1 to 6
                System.out.println("What information would you like to change? " + "\n" +
                        "1. Consumer name " + "\n"+
                        "2. Location" + "\n" +
                        "3. Age " + "\n" +
                        "4. Gender " + "\n" +
                        "5. Marital Status " + "\n" +
                        "6. Quit " + "\n"+
                        "Please enter your choice > (Input number 1 to 6)" );

                // Tracks user input
                whichAttributeToChange = scanner.nextLine();
                whichAttributeToChangeConverted = Integer.parseInt(whichAttributeToChange);

                //Switch for menu : which attribute to change
                switch (whichAttributeToChangeConverted){
                    //Consumer Name
                    case 1:
                        // make the changes to the attribute
                        System.out.println("What would you like to change the consumer name to?");
                        String inputNewName = scanner.nextLine();
                        consumerDatabase[consumerToUpdateConverted].setName(inputNewName);

                        //then display again all the attributes on the screen to show that the attribute has been changed
                        System.out.println("Displaying Consumer with updated information:");
                        displayConsumer(consumerToUpdateConverted);
                        break;

                        // Location
                    case 2:
                        // make the changes to the attribute
                        System.out.println("What would you like to change the location to?");

                        System.out.println("Enter new Street Number:");
                        String inputNewStreetNumber = scanner.nextLine();
                        consumerDatabase[consumerToUpdateConverted].setStreetNumber(Integer.parseInt(inputNewStreetNumber));

                        System.out.println("Enter new Street Name:");
                        String inputNewStreetName = scanner.nextLine();
                        consumerDatabase[consumerToUpdateConverted].setStreetName(inputNewStreetName);

                        System.out.println("Enter new City Name:");
                        String inputNewCityName = scanner.nextLine();
                        consumerDatabase[consumerToUpdateConverted].setCity(inputNewCityName);

                        System.out.println("Enter new Postal Code:");
                        String inputNewPostalCode = scanner.nextLine();
                        consumerDatabase[consumerToUpdateConverted].setPostalCode(inputNewPostalCode);

                        //then display again all the attributes on the screen to show that the attribute has been changed
                        System.out.println("Displaying Consumer with updated information:");
                        displayConsumer(consumerToUpdateConverted);
                        break;

                        //Age
                    case 3:
                        // make the changes to the attribute
                        System.out.println("What would you like to change the age to?");
                        String inputNewAge = scanner.nextLine();
                        consumerDatabase[consumerToUpdateConverted].setAge(Integer.parseInt(inputNewAge));

                        //then display again all the attributes on the screen to show that the attribute has been changed
                        System.out.println("Displaying Consumer with updated information:");
                        displayConsumer(consumerToUpdateConverted);
                        break;

                        //Gender
                    case 4:
                        String inputNewGenderChoice;
                        int inputNewGenderChoiceConverted;
                        do {
                            // make the changes to the attribute
                            System.out.println("What would you like to change the gender to? (Input number 1 to 3)");
                            System.out.println("1. Male" + "\n2. Female" + "\n3. Other");
                            inputNewGenderChoice = scanner.nextLine();
                            inputNewGenderChoiceConverted = Integer.parseInt(inputNewGenderChoice);

                            switch (inputNewGenderChoiceConverted){
                                case 1:
                                    consumerDatabase[consumerToUpdateConverted].setGender("Male");
                                    break;
                                case 2:
                                    consumerDatabase[consumerToUpdateConverted].setGender("Female");
                                    break;
                                case 3:
                                    consumerDatabase[consumerToUpdateConverted].setGender("Other");
                                    break;
                                default:
                                    System.out.println("Invalid Input. Please try again.");
                                    break;
                            }

                        }while (inputNewGenderChoiceConverted<1 ||inputNewGenderChoiceConverted>3);


                        //then display again all the attributes on the screen to show that the attribute has been changed
                        System.out.println("Displaying Consumer with updated information:");
                        displayConsumer(consumerToUpdateConverted);
                        break;


                        //Marital Status
                    case 5:
                        String inputNewMaritalStatusChoice;
                        int inputNewMaritalStatusChoiceConverted;
                        do {
                            System.out.println("What would you to change the marital status? (Input number 1 to 4)");
                            System.out.println("1. Single" + "\n2. Married" + "\n3. Widowed" + "\n4. Divorced");
                            inputNewMaritalStatusChoice = scanner.nextLine();
                            inputNewMaritalStatusChoiceConverted = Integer.parseInt(inputNewMaritalStatusChoice);

                            switch (inputNewMaritalStatusChoiceConverted) {
                                case 1:
                                    consumerDatabase[consumerToUpdateConverted].setMaritalStatus(Consumer.MaritalStatus.SINGLE);
                                    break;
                                case 2:
                                    consumerDatabase[consumerToUpdateConverted].setMaritalStatus(Consumer.MaritalStatus.MARRIED);
                                    break;
                                case 3:
                                    consumerDatabase[consumerToUpdateConverted].setMaritalStatus(Consumer.MaritalStatus.WIDOWED);
                                    break;
                                case 4:
                                    consumerDatabase[consumerToUpdateConverted].setMaritalStatus(Consumer.MaritalStatus.DIVORCED);
                                    break;
                                default:
                                    System.out.println("Invalid Input. Please try again.");
                                    break;
                            }
                        } while (inputNewMaritalStatusChoiceConverted<1 || inputNewMaritalStatusChoiceConverted>4);


                        //then display again all the attributes on the screen to show that the attribute has been changed
                        System.out.println("Displaying Consumer with updated information:");
                        displayConsumer(consumerToUpdateConverted);
                        break;


                        //Quit **CHECK** Does that mean to quit fully or just go back to the main menu
                    case 6:
                        System.out.println("Quitting! Going back to the Main Menu: ");
                        displayMainMenu();
                }


            } while (whichAttributeToChangeConverted >= 1 && whichAttributeToChangeConverted <= 6); // Infinite loops until valid input (1 to 6)

        }
        //If password input is valid
        else{
            System.out.println("program has terminated due to safety reasons");
            System.exit(0);
        }
    }

    /**
     * Static void method for option 3 in the main menu
     * 3. Display all Consumers similar to a given consumer
     */
    public static void option3() {
        System.out.println("3. Display all Consumers similar to a given consumer");
        System.out.println("-----------------------------------------------------------");

        //Create scanner object
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter age of given consumer: ");
        String ageOfGivenConsumer = scanner.nextLine();
        int ageOfGivenConsumerConverted = Integer.parseInt(ageOfGivenConsumer);

        String inputNewGenderChoice;
        int inputNewGenderChoiceConverted;
        String gender = "";


        do {
            // make the changes to the attribute
            System.out.println("Enter Gender (Input number 1 to 3)");
            System.out.println("1. Male" + "\n2. Female" + "\n3. Other");
            inputNewGenderChoice = scanner.nextLine();
            inputNewGenderChoiceConverted = Integer.parseInt(inputNewGenderChoice);

            switch (inputNewGenderChoiceConverted){
                case 1:
                    gender = "Male";
                    break;
                case 2:
                    gender = "Female";
                    break;
                case 3:
                    gender = "Other";
                    break;
                default:
                    System.out.println("Invalid Input. Please try again.");
                    break;
            }

        }while (inputNewGenderChoiceConverted<1 ||inputNewGenderChoiceConverted>3);

        //Education Level
        String inputEducationChoice;
        int inputEducationChoiceConverted;
        Consumer.Education education = null;

        do {
            System.out.println("Enter Education Level (Input number 1 to 4) :");
            System.out.println("1. ELEMENTARY" + "\n2. HIGHSCHOOL" + "\n3. CEGEP" + "\n4. UNIVERSITY" );

            inputEducationChoice = scanner.nextLine();
            inputEducationChoiceConverted = Integer.parseInt(inputEducationChoice);


            switch (inputEducationChoiceConverted) {
                case 1:
                    education = Consumer.Education.ELEMENTARY;
                    break;
                case 2:
                    education = Consumer.Education.HIGHSCHOOL;
                    break;
                case 3:
                    education = Consumer.Education.CEGEP;
                    break;
                case 4:
                    education = Consumer.Education.UNIVERSITY;
                    break;
                default:
                    System.out.println("Invalid Input. Please try again.");
                    break;
            }
        } while (inputEducationChoiceConverted<1 || inputEducationChoiceConverted>4);

        findConsumersBy(ageOfGivenConsumerConverted,gender,education);

    }

    /**
     * Static void method used in option 3 in the main menu to find similar consumers who share the same age, gender, and education level
     * @param age is an int value
     * @param gender is a string value
     * @param education is an enum value of type Education
     */
    public static void findConsumersBy(int age, String gender, Consumer.Education education) {
        //**CHECK: Is it OR or AND, similar in terms one attribute is the same or all 3
        //** CHECK : ENUM
        int commonConsumers =0;

        //Check if there consumers in the database
        if(Consumer.getNumberOfConsumers() == 0){
            System.out.println("Error: There no consumers in the database");
        }
        else {
            for (int i = 0; i < Consumer.getNumberOfConsumers(); i++) {
                if (consumerDatabase[i].getAge() == age && consumerDatabase[i].getGender() == gender && consumerDatabase[i].getEducation() == education) {
                    displayConsumer(i);
                    commonConsumers++;
                }
            }

            //Display message if no consumers in common
            if (commonConsumers == 0){
                System.out.println("There are no similar consumers");
            }
            //Display message if there are consumers in common
            else {
                System.out.println("Above are listed are all the similar consumers");
            }

        }

        System.out.println("Going back to main menu....");
        displayMainMenu();
    }


    /**
     * Static void method for option 4 in the Main Menu
     * 4. Display all Consumers with given age and location
     */
    public static void option4() {
        //Create scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.println("4. Display all Consumers with given age and location");
        System.out.println("-----------------------------------------------------------");

        System.out.println("Enter age of given consumer: ");
        String ageOfGivenConsumer = scanner.nextLine();
        int ageOfGivenConsumerConverted = Integer.parseInt(ageOfGivenConsumer);

        System.out.println("Enter postal code of given consumer: ");
        String postalCodeOfGivenConsumer =scanner.nextLine();

        findConsumerByAgeNGender(ageOfGivenConsumerConverted,postalCodeOfGivenConsumer);

    }

    /**
     * static void method used in option 4, which helps displays all Consumers with given age and location
     * @param age is an int value
     * @param postalCode is a String value
     */
    public static void findConsumerByAgeNGender(int age, String postalCode){
        int similarConsumers =0;
        if(Consumer.getNumberOfConsumers() == 0){
            System.out.println("Error: There no consumers in the database");
        }
        else {
            for (int i = 0; i < Consumer.getNumberOfConsumers(); i++) {
                if (consumerDatabase[i].getAge() == age && consumerDatabase[i].getPostalCode().equalsIgnoreCase(postalCode)) {
                    displayConsumer(i);
                    similarConsumers++;
                }
            }
            if(similarConsumers ==0){
                System.out.println("There are no consumers that have the given age and location");
            } else {
                System.out.println("Above are listed the consumers that have the given age and location");
            }

        }
        System.out.println("Going back to main menu....");
        displayMainMenu();
    }
    /**
     * Static void method for option 5 in the main menu, which terminates the program
     * 5. Quit
     */
    public static void option5() {
        System.out.println("5. Quit");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Program terminated. Goodbye!");
        System.exit(0);
    }



}




