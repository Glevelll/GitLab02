import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello " + args[0]);

//        System.out.print("x = ");
//        double x = scanner.nextDouble();
//        System.out.print("y = ");
//        double y = scanner.nextDouble();
//        System.out.println((3.0 * Math.pow(Math.cos(x - (Math.PI / 6.0)), 2.0)) / (0.5 + Math.sin(Math.pow(y, 2.0))));

        double a = Double.parseDouble(args[2]);
        double a0 = Double.parseDouble(args[3]);
        double a1 = Double.parseDouble(args[4]);
        double a2 = Double.parseDouble(args[5]);
        double b = Double.parseDouble(args[6]);
        double c = Double.parseDouble(args[7]);
        double d = Double.parseDouble(args[8]);
        double x = Double.parseDouble(args[9]);
        double y = Double.parseDouble(args[10]);
        double w = Double.parseDouble(args[11]);
        double n = Double.parseDouble(args[12]);

        try {
            switch (parseInt(args[1])) {
                case (1) -> System.out.println((Math.pow(5.0 * a, (n * x))) / (b + c) - Math.sqrt(Math.abs(Math.cos(Math.pow(x, 3.0)))));
                case (2) -> System.out.println(((Math.abs(x - y)) / (Math.pow((1.0 + 2.0 * x), a))) - Math.exp(Math.sqrt(1.0 + w)));
                case (3) -> System.out.println(Math.sqrt(a0 + (a1 * x) + (a2 * Math.pow(Math.sqrt(Math.abs(Math.sin(x))), 0.33))));
                case (4) -> System.out.println(Math.log(Math.abs(Math.pow(a, 7.0))) + Math.atan(x * x) + (Math.PI / (Math.sqrt(Math.abs(a + x)))));
                case (5) -> System.out.println(Math.pow(Math.sqrt(Math.pow(a + b, 2.0) / (c + d)) + Math.exp(Math.sqrt(x + 1.0)), 0.2));
                case (6) -> System.out.println(Math.exp((2.0 * Math.sin(4.0 * x) + Math.pow(Math.cos(Math.pow(x, 2.0)), 2.0))) / (3.0 * x));
                case (7) -> System.out.println(0.25 * (((1.0 + Math.pow(x, 2.0)) / (1.0 - x)) + 0.5 * Math.tan(x)));
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
