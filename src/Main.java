import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello " + args[0]);

        System.out.print("x = ");
        double x = scanner.nextDouble();
        System.out.print("y = ");
        double y = scanner.nextDouble();
        System.out.println((3.0 * Math.pow(Math.cos(x - (Math.PI / 6.0)), 2.0)) / (0.5 + Math.sin(Math.pow(y, 2.0))));
    }
}
