package Sockets;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Client1 {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Who are you?");
            String username = sc.nextLine();
            output.writeUTF(username);
            String receivedUsername = input.readUTF();
            System.out.println(receivedUsername);

            String str = null;
            while (!Objects.equals(str, "bye")){
                str = sc.nextLine();
                if (str.equals("bye")){
                    output.writeUTF(str);
                    break;
                }
                if ((username.equals("admin")) && (str.equals("exit"))){
                    break;
                } else {
                    output.writeUTF(str);
                    String receivedStr = input.readUTF();
                    System.out.println(receivedStr);
                }
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}