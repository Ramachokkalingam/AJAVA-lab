import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

public class ChatServer extends UnicastRemoteObject implements Chat {
    private static ArrayList<Chat> clients = new ArrayList<>();

    protected ChatServer() throws RemoteException {
        super();
    }

    public void sendMessage(String message) throws RemoteException {
        System.out.println("Client: " + message);
        for (Chat client : clients) {
            if (client != this) {
                client.sendMessage("Server Echo: " + message);
            }
        }
    }

    public static void main(String args[]) {
        try {
            ChatServer server = new ChatServer();
            Naming.rebind("ChatService", server);
            clients.add(server);
            System.out.println("Chat Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }
}
