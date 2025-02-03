import java.rmi.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String args[]) {
        try {
            Chat stub = (Chat) Naming.lookup("rmi://localhost/ChatService");
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.print("You: ");
                String message = sc.nextLine();
                stub.sendMessage(message);
            }
        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}
