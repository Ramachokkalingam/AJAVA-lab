import java.rmi.*;
import java.util.Scanner;

public class AdditionClient {
    public static void main(String args[]) {
        try {
            // Lookup the remote object
            Addition stub = (Addition) Naming.lookup("rmi://localhost/AdditionService");

            // Create Scanner for user input
            Scanner sc = new Scanner(System.in);

            // Get user input
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();
            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            // Call remote method and display result
            System.out.println("Sum: " + stub.add(num1, num2));

            sc.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}

