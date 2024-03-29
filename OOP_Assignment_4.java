import java.util.*;

public class OOP_Assignment_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int max_Attempts = 3;
        int attempts = 0;

        try {
            while (attempts < max_Attempts) {
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                try {
                    login(password);
                    System.out.println("Login successful!");
                    break;
                } catch (InvalidPasswordException e) {
                    System.out.println(e.getMessage());
                    attempts++;
                }
            }
            if (attempts == max_Attempts) {
                throw new MaxLoginTriesException("Maximum login attempts reached.");
            }
        } catch (MaxLoginTriesException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void login(String pass) throws MaxLoginTriesException, InvalidPasswordException {
        final String valid = "password";

        if (!pass.equals(valid)) {
            throw new InvalidPasswordException("Invalid password.");
        }
    }

    static class MaxLoginTriesException extends Exception {
        public MaxLoginTriesException(String message) {
            super(message);
        }
    }

    static class InvalidPasswordException extends Exception {
        public InvalidPasswordException(String message) {
            super(message);
        }
    }
}
