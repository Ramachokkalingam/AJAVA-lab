import java.rmi.*;

public interface Chat extends Remote {
    void sendMessage(String username, String message) throws RemoteException;
    String receiveMessages() throws RemoteException;
}
