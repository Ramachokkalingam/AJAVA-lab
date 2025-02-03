import java.rmi.*;
import java.rmi.server.*;

public class MessageServer extends UnicastRemoteObject implements Message {
    protected MessageServer() throws RemoteException {
        super();
    }

    public String getMessage() throws RemoteException {
        return "Hello from RMI Server!";
    }

    public static void main(String args[]) {
        try {
            MessageServer obj = new MessageServer();
            Naming.rebind("MessageService", obj);
            System.out.println("Message Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}
