import java.util.Scanner;

public class OnlineReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Login page
        System.out.println("===== Login Form =====");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        if (authenticateUser(username, password)) {
            System.out.println("Login successful. Welcome, " + username + "!");
            
            // Reservation System
            System.out.println("++++++===== Reservation System =====+++++");
            
            // Gather necessary details
            System.out.print("Enter your Basic details: ");
            String userDetails = scanner.nextLine();
            
            System.out.print("Enter train number: ");
            int trainNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter class type: ");
            String classType = scanner.nextLine();
            
            System.out.print("Enter date of journey: ");
            String dateOfJourney = scanner.nextLine();
            
            System.out.print("Enter source station: ");
            String sourceStation = scanner.nextLine();
            
            System.out.print("Enter destination station: ");
            String destinationStation = scanner.nextLine();
            
            // Reservation
            boolean reservationSuccess = performReservation(userDetails, trainNumber, classType, dateOfJourney, sourceStation, destinationStation);
            if (reservationSuccess) {
                System.out.println("Reservation successful!");
            } else {
                System.out.println("Reservation failed. Please try again.");
            }
            
            // Cancel Form
            System.out.println("++++===== Cancellation Form =====+++++");
            System.out.print("Enter your PNR number: ");
            String pnrNumber = scanner.nextLine();
            
            boolean cancellationSuccess = cancelReservation(pnrNumber);
            if (cancellationSuccess) {
                System.out.println("Cancellation successful!");
            } else {
                System.out.println("Cancellation failed. Please try again.");
            }
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
        
        scanner.close();
    }
    
    private static boolean authenticateUser(String username, String password) {

        // Example: Hardcoded credentials
        String storedUsername = "Sanket";
        String storedPassword = "Pass@898";
        
        return username.equals(storedUsername) && password.equals(storedPassword);
    }
    
    private static boolean performReservation(String userDetails, int trainNumber, String classType, String dateOfJourney, String sourceStation, String destinationStation) {
    
        // Print reservation details
        System.out.println("User Details:" + userDetails);
        System.out.println("Train Number:" + trainNumber);
        System.out.println("Class Type:" + classType);
        System.out.println("Date of Journey:" + dateOfJourney);
        System.out.println("Source Station:" + sourceStation);
        System.out.println("Destination Station:" + destinationStation);
        
        return true; // Return true if reservation is successful, false otherwise
    }
    
    private static boolean cancelReservation(String pnrNumber) {
        // Print cancellation details
        System.out.println("Cancelled reservation with PNR number: " + pnrNumber);
        
        return true; // Return true if cancellation is successful, false otherwise
    }
}
