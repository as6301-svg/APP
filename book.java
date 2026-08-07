import java.util.*;
public class book {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String title, author;
        int price;
        System.out.println("Enter title of the book");
        title = sc.nextLine();
        System.out.println("Enter author of the book");
        author = sc.nextLine();
        System.out.println("Enter price of the book");
        price = sc.nextInt();
        System.out.println("The details of the car are: ");
        System.out.println("Title of the book is : " +title);
        System.out.println("The author of the book is : " +author);
        System.out.println("The price of the book is : " +price);
    }
}
