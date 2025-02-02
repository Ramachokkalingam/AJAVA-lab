import java.rmi.*;

public interface Message extends Remote {
    String getMessage() throws RemoteException;

}
