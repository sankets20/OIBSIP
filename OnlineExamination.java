import java.util.Scanner;

public class OnlineExamination {
    private static User currentUser;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        while (true) {
            displayMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    updateProfileAndPassword();
                    break;
                case 3:
                    selectAnswersForMCQs();
                    break;
                case 4:
                    timerAndAutoSubmit();
                    break;
                case 5:
                    closeSessionAndLogout();
                    break;
                case 6:
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("Welcome to the Online Examination System!");
        System.out.println("1. Login");
        System.out.println("2. Update Profile and Password");
        System.out.println("3. Select Answers for MCQs");
        System.out.println("4. Timer and Auto Submit");
        System.out.println("5. Close Session and Logout");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        return scanner.nextInt();
    }

    private static void login() {
        scanner.nextLine(); 

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (User.isValid(username, password)) {
            currentUser = new User(username);
            System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void updateProfileAndPassword() {
        if (isLoggedIn()) {
            System.out.println("Update Profile and Password");
            System.out.print("Enter new profile information: ");
            String profileInfo = scanner.nextLine();
            
            System.out.println("Profile and password updated successfully.");
        } else {
            System.out.println("Please login first.");
        }
    }
    private static void selectAnswersForMCQs() {
        if (isLoggedIn()) {
            System.out.println("Select Answers for MCQs");
            System.out.println("Answers for MCQs selected successfully.");
        } else {
            System.out.println("Please login first.");
        }
    }
    private static void timerAndAutoSubmit() {
        if (isLoggedIn()) {
            System.out.println("Timer and Auto Submit");
            System.out.print("Enter timer duration (in minutes): ");
            int duration = scanner.nextInt();

            System.out.println("Timer started. Auto submission enabled.");
        } else {
            System.out.println("Please login first.");
        }
    }

    private static void closeSessionAndLogout() {
        if (isLoggedIn()) {
            System.out.println("Closing session and logging out. Goodbye, " + currentUser.getUsername() + "!");
            currentUser = null;
        } else {
            System.out.println("Please login first.");
        }
    }

    private static void exitProgram() {
        System.out.println("Thank you for using the Online Examination System!");
        System.exit(0);
    }

    private static boolean isLoggedIn() {
        return currentUser != null;
    }

    private static class User {
        private String username;
        private String password;

        private User(String username) {
            this.username = username;
        }

        private String getUsername() {
            return username;
        }

        private static boolean isValid(String username, String password) {
            // Implement the logic to validate username and password
            return username.equals("admin") && password.equals("password");
        }
    }
}
