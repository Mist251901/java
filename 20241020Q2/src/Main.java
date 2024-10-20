import java.util.Scanner;

public class Main {
    private double principal;
    private int months;
    private double annualRate;
    private double monthlyRate;

    public Main(double principal, int months, double annualRate) {
        this.principal = principal;
        this.months = months;
        this.annualRate = annualRate;
        this.monthlyRate = annualRate / 12 / 100; // 将年利率转换为月利率（百分数转换为小数）
    }

    public double calculateEqualPrincipalInterest() {
        return (months + 1) * principal * monthlyRate / 2;
    }

    public double calculateEqualInstallmentInterest() {
        double numerator = months * principal * monthlyRate * Math.pow(1 + monthlyRate, months);
        double denominator = Math.pow(1 + monthlyRate, months) - 1;
        return numerator / denominator - principal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入贷款总额（万元）: ");
        double principal = scanner.nextDouble();
        System.out.print("请输入贷款时间（月数）: ");
        int months = scanner.nextInt();
        System.out.print("请输入年利率（%）: ");
        double annualRate = scanner.nextDouble();

        Main loanCalculator = new Main(principal, months, annualRate);

        double equalPrincipalInterest = loanCalculator.calculateEqualPrincipalInterest();
        double equalInstallmentInterest = loanCalculator.calculateEqualInstallmentInterest();

        System.out.printf("等额本金还款法的总利息: %.2f 元%n", equalPrincipalInterest * 10000); // 转换为元
        System.out.printf("等额本息还款法的总利息: %.2f 元%n", equalInstallmentInterest * 10000); // 转换为元

        scanner.close();
    }
}
