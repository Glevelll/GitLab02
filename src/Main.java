import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output  = new DataOutputStream(socket.getOutputStream())
        ) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ваше имя: ");
            String username = scanner.nextLine();
            output.writeUTF(username);
            String receivedUsername = input.readUTF();
            System.out.println(receivedUsername);

            String a = scanner.nextLine();
            String a0 = scanner.nextLine();
            String a1 = scanner.nextLine();
            String a2 = scanner.nextLine();
            String b = scanner.nextLine();
            String c = scanner.nextLine();
            String d = scanner.nextLine();
            String x = scanner.nextLine();
            String y = scanner.nextLine();
            String w = scanner.nextLine();
            String n = scanner.nextLine();


            output.writeUTF(a);
            output.writeUTF(a0);
            output.writeUTF(a1);
            output.writeUTF(a2);
            output.writeUTF(b);
            output.writeUTF(c);
            output.writeUTF(d);
            output.writeUTF(x);
            output.writeUTF(y);
            output.writeUTF(w);
            output.writeUTF(n);

            String recMsg = input.readUTF();
            System.out.println(recMsg);

            String v = scanner.nextLine();
            output.writeUTF(v);
            String receivedMsg = input.readUTF();
            System.out.println(receivedMsg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}