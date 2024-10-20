import java.util.Scanner;

public class Main {
    private double a;
    private double b;
    private double c;

    public Main(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void solve() {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("方程有两个不同的实根: x1 = %.2f, x2 = %.2f%n", x1, x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.printf("方程有一个实根: x = %.2f%n", x);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            System.out.printf("方程没有实根, 复数根为: x1 = %.2f + %.2fi, x2 = %.2f - %.2fi%n",
                    realPart, imaginaryPart, realPart, imaginaryPart);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入系数 a: ");
        double a = scanner.nextDouble();
        System.out.print("请输入系数 b: ");
        double b = scanner.nextDouble();
        System.out.print("请输入系数 c: ");
        double c = scanner.nextDouble();

        Main solver = new Main(a, b, c);
        solver.solve();

        scanner.close();
    }
}
