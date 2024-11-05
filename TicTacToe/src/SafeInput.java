import java.util.Scanner;

public class SafeInput {

    // Method to get a non-zero length string
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Initialize as empty to ensure loop runs
        do {
            System.out.print("\n" + prompt + ": "); // Display the prompt
            retString = pipe.nextLine(); // Get the user input
        } while (retString.length() == 0); // Keep looping until a non-empty string is provided
        return retString;
    }

    // Method to get an integer input
    public static int getInt(Scanner pipe, String prompt) {
        int retValue = 0;
        boolean validInput = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                pipe.next(); // Clear invalid input
            }
            pipe.nextLine(); // Clear the newline character
        } while (!validInput);

        return retValue;
    }

    // Method to get a double input
    public static double getDouble(Scanner pipe, String prompt) {
        double retValue = 0;
        boolean validInput = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid double.");
                pipe.next(); // Clear invalid input
            }
            pipe.nextLine(); // Clear the newline character
        } while (!validInput);

        return retValue;
    }

    // Method to get an integer within a specified range
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retValue = 0;
        boolean validInput = false;

        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                if (retValue >= low && retValue <= high) {
                    validInput = true;
                } else {
                    System.out.println("Input out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                pipe.next(); // Clear invalid input
            }
            pipe.nextLine(); // Clear the newline character
        } while (!validInput);

        return retValue;
    }

    // Method to get a double within a specified range
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retValue = 0;
        boolean validInput = false;

        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                if (retValue >= low && retValue <= high) {
                    validInput = true;
                } else {
                    System.out.println("Input out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid double.");
                pipe.next(); // Clear invalid input
            }
            pipe.nextLine(); // Clear the newline character
        } while (!validInput);

        return retValue;
    }

    // Method to get Yes or No confirmation
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        boolean validInput = false;
        boolean result = false;

        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine().trim();
            if (response.equalsIgnoreCase("Y")) {
                result = true;
                validInput = true;
            } else if (response.equalsIgnoreCase("N")) {
                result = false;
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!validInput);

        return result;
    }

    // Method to get a string that matches a regular expression pattern
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input;
        boolean validInput = false;

        do {
            System.out.print("\n" + prompt + ": ");
            input = pipe.nextLine();
            if (input.matches(regEx)) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please ensure the input matches the required format.");
            }
        } while (!validInput);

        return input;
    }
    // New Method to create a pretty header
    public static void prettyHeader(String msg) {
        int totalWidth = 60;
        int msgLength = msg.length();
        int padding = (totalWidth - msgLength - 6) / 2; // 6 for the asterisks

        // Print the top border
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

        // Print the message line with stars and padding
        System.out.print("***");
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < padding; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        // Print the bottom border
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    // Main method for testing all input methods
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test getNonZeroLenString method
        String userInput = getNonZeroLenString(scanner, "Enter your name");
        System.out.println("You entered: " + userInput);

        // Test getInt method
        int userInt = getInt(scanner, "Enter an integer");
        System.out.println("You entered the integer: " + userInt);

        // Test getDouble method
        double userDouble = getDouble(scanner, "Enter a double");
        System.out.println("You entered the double: " + userDouble);

        // Test getRangedInt method
        int rangedInt = getRangedInt(scanner, "Enter a number", 10, 20);
        System.out.println("You entered the number: " + rangedInt);

        // Test getRangedDouble method
        double rangedDouble = getRangedDouble(scanner, "Enter a number", 5.5, 10.5);
        System.out.println("You entered the number: " + rangedDouble);

        // Test getYNConfirm method
        boolean confirm = getYNConfirm(scanner, "Do you want to continue?");
        System.out.println("You selected: " + (confirm ? "Yes" : "No"));

        // Test getRegExString method
        String regExInput = getRegExString(scanner, "Enter a valid email", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        System.out.println("You entered a valid email: " + regExInput);



        scanner.close();
    }

}



