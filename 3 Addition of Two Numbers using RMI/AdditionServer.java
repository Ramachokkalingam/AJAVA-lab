import java.rmi.*;
import java.rmi.server.*;

public class AdditionServer extends UnicastRemoteObject implements Addition {
    protected AdditionServer() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    public static void main(String args[]) {
        try {
            AdditionServer obj = new AdditionServer();
            Naming.rebind("AdditionService", obj);
            System.out.println("Addition Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}


