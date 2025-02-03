import java.rmi.*;

public class MessageClient {
    public static void main(String args[]) {
        try {
            Message stub = (Message) Naming.lookup("rmi://127.0.0.1/MessageService");
            //change local host ip into actual ip
            System.out.println("Server Message: " + stub.getMessage());
        } catch (Exception e) {
            System.out.println("Client Error: " + e);
        }
    }
}
