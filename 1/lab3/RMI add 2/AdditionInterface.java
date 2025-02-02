import java.rmi.*;
import java.rmi.server.*;

public class AdditionServer extends UnicastRemoteObject implements AdditionInterface {
    public AdditionServer() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    public static void main(String[] args) {
        try {
            AdditionServer server = new AdditionServer();
            Naming.rebind("rmi://localhost/AdditionService", server);
            System.out.println("Addition Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
