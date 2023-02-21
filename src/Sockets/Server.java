package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 34522;

    public static void main(String[] args) {
        System.out.println("Серевер запущен и готов к работе...");
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (
                        Socket socket = server.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    String username = input.readUTF();
                    System.out.println("К нам пришел " + username);
                    output.writeUTF("Hello " + username);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}