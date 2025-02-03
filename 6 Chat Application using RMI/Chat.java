import java.rmi.*;

public interface Chat extends Remote {
    void sendMessage(String message) throws RemoteException;
}
