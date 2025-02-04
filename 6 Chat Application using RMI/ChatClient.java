import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends UnicastRemoteObject implements Chat {
    private List<String> chatHistory;

    protected ChatServer() throws RemoteException {
        chatHistory = new ArrayList<>();
    }

    // Store new messages
    public synchronized void sendMessage(String username, String message) throws RemoteException {
        String formattedMessage = username + ": " + message;
        chatHistory.add(formattedMessage);
        System.out.println(formattedMessage);
    }

    // Return chat history
    public synchronized String receiveMessages() throws RemoteException {
        return String.join("\n", chatHistory);
    }

    public static void main(String[] args) {
        try {
            ChatServer server = new ChatServer();
            LocateRegistry.createRegistry(1099);  // Start RMI registry
            Naming.rebind("ChatService", server);
            System.out.println("Chat Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}
