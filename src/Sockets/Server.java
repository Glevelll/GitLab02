package Sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Server {
    private static final int PORT = 34522;
    public static void main(String[] args) throws IOException {
        System.out.println("Серевер запущен и готов к работе...");
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            Socket socket = server.accept();
            Thread t = new Thread(new ClientHandler(socket));
            t.start();
        }

    }
}

class ClientHandler implements Runnable{
    Socket socket;
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            String username = input.readUTF();
            System.out.println("К нам пришел " + username);
            output.writeUTF("Hello " + username);

            String str = null;
            int n = 0;
            while (!Objects.equals(str, "bye")){
                n++;
                str = input.readUTF();
                if (str.equals("bye")){
                    System.out.println("Пока " + username);
                    break;
                }
                if ((username.equals("admin")) && (str.equals("exit"))){
                    socket.shutdownInput();
                    socket.shutdownOutput();
                    socket.close();
                } else {
                    System.out.println("Получено сообщение №" + n + " - " + str);
                    output.writeUTF("Ответ сервера: " + n + " - " + str);
                }
            }
        }

        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}