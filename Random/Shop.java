import java.util.*;

public class Shop {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int totalAmount = 0;
            int choice;
            int quantity;

            do {
                System.out.println("Select Choice:");
                System.out.println("1. Burger (Rs.200)");
                System.out.println("2. Fries (Rs.100)");
                System.out.println("3. Coke (Rs.50)");
                System.out.println("4. Checkout");
                System.out.print("Enter Choice- ");

                choice = sc.nextInt();

                if (choice == 4) {
                    break;  
                }

                System.out.print("Enter Quantity- ");
                quantity = sc.nextInt();

                switch (choice) {
                    case 1:
                        totalAmount += 200 * quantity;
                        System.out.println("Added " + quantity + " Burger(s) to your order.");
                        break;
                    case 2:
                        totalAmount += 100 * quantity;
                        System.out.println("Added " + quantity + " Fries to your order.");
                        break;
                    case 3:
                        totalAmount += 50 * quantity;
                        System.out.println("Added " + quantity + " Coke(s) to your order.");
                        break;
                    default:
                        System.out.println("Please select a valid choice.");
                }

            System.out.println("");

            } while (true);

            // Checkout
            System.out.println("Checkout selected.");
            System.out.println("Total Bill Amount = Rs." + totalAmount);
        }
    }
}
