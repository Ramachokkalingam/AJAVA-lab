import java.rmi.*;

public class MessageClient {
    public static void main(String args[]) {
        try {
            Message stub = (Message) Naming.lookup("rmi://localhost/MessageService");
            System.out.println("Server Message: " + stub.getMessage());
        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}
