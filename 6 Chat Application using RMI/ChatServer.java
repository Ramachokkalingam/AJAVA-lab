import java.rmi.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            // Connect to the ChatService
            Chat chat = (Chat) Naming.lookup("rmi://localhost/ChatService");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.println("Connected to chat! Type messages and press Enter.");

            while (true) {
                System.out.print("> ");
                String message = scanner.nextLine();
                
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting chat...");
                    break;
                }

                // Send message to server
                chat.sendMessage(username, message);

                // Fetch and display chat history
                System.out.println("\nChat History:\n" + chat.receiveMessages());
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}
