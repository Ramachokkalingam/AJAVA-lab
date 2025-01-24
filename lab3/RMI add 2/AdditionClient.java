import java.rmi.*;

public class AdditionClient {
    public static void main(String[] args) {
        try {
            AdditionInterface stub = (AdditionInterface) Naming.lookup("rmi://localhost/AdditionService");
            int result = stub.add(10, 20); // Example numbers
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

