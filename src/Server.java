import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 34522;

    public static void main(String[] args) {
        System.out.println("Сервер запущен");
        try (ServerSocket server = new ServerSocket(PORT)) {
            try (
                    Socket socket = server.accept();
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream())
            ) {
                String username = input.readUTF();
                System.out.println("К нам пришел " + username);
                output.writeUTF("Hello " + username + "\n" + "Введите 11 аргументов: ");

                double a = Double.parseDouble(input.readUTF());
                double a0 = Double.parseDouble(input.readUTF());
                double a1 = Double.parseDouble(input.readUTF());
                double a2 = Double.parseDouble(input.readUTF());
                double b = Double.parseDouble(input.readUTF());
                double c = Double.parseDouble(input.readUTF());
                double d = Double.parseDouble(input.readUTF());
                double x = Double.parseDouble(input.readUTF());
                double y = Double.parseDouble(input.readUTF());
                double w = Double.parseDouble(input.readUTF());
                double n = Double.parseDouble(input.readUTF());

                output.writeUTF("Введите вариант ");

                String v = input.readUTF();
                double result = 0;

                switch (Integer.parseInt(v)) {
                    case (1) -> result = ((Math.pow(5.0 * a, (n * x))) / (b + c) - Math.sqrt(Math.abs(Math.cos(Math.pow(x, 3.0)))));
                    case (2) -> result = (((Math.abs(x - y)) / (Math.pow((1.0 + 2.0 * x), a))) - Math.exp(Math.sqrt(1.0 + w)));
                    case (3) -> result = (Math.sqrt(a0 + (a1 * x) + (a2 * Math.pow(Math.sqrt(Math.abs(Math.sin(x))), 0.33))));
                    case (4) -> result = (Math.log(Math.abs(Math.pow(a, 7.0))) + Math.atan(x * x) + (Math.PI / (Math.sqrt(Math.abs(a + x)))));
                    case (5) -> result = (Math.pow(Math.sqrt(Math.pow(a + b, 2.0) / (c + d)) + Math.exp(Math.sqrt(x + 1.0)), 0.2));
                    case (6) -> result = (Math.exp((2.0 * Math.sin(4.0 * x) + Math.pow(Math.cos(Math.pow(x, 2.0)), 2.0))) / (3.0 * x));
                    case (7) -> result = (0.25 * (((1.0 + Math.pow(x, 2.0)) / (1.0 - x)) + 0.5 * Math.tan(x)));
                }
                System.out.println("Вариант: " + v);
                output.writeUTF("Результат: " + result);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}