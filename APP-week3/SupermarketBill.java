import java.util.Scanner;
public class SupermarketBill {
    public static void main(String[] args) {
        Scanner vc = new Scanner(System.in);
        int n = 5;
        double[] prices = new double[n];
        double total = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter price of product " + (i + 1) + ": ");
            prices[i] = vc.nextDouble();
            total += prices[i];
        }
        System.out.println("Total Bill : " + total);
        double discount = 0;
        if (total > 5000) {
            discount = total * 0.10;   // 10% discount
            System.out.println("Discount Applicable");
            System.out.println("Discount Amount : " + discount);
            System.out.println("Amount Payable : " + (total - discount));
        } else {
            System.out.println("No Discount");
            System.out.println("Amount Payable : " + total);
        }
        vc.close();
    }
}