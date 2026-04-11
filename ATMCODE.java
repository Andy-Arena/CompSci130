package aTMachine; // change as needed for your setup
import java.util.Scanner;

public class ATMCODE {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pin = 0;

        do {
            System.out.print("Enter your PIN please: ");
            pin = input.nextInt();

            if (pin < 0) {
                break;
            }

            if (pin % 2 != 0) {
                // Type 1 customer
                System.out.printf("Enter the amount to be withdrawn: ");
                int money = input.nextInt();

                while (money <= 0 || money > 500) {
                    System.out.printf("Invalid amount: %d\n", money);
                    System.out.printf("Enter the amount to be withdrawn: ");
                    money = input.nextInt();
                }

                int money10 = money / 10;
                int money5 = (money - (money10 * 10)) / 5;
                int money1 = money - (money10 * 10) - (money5 * 5);

                System.out.printf(
                    "You are receiving the following bills:\n\tNumber of $10 bills: %d\n\tNumber of $5 bills: %d\n\tNumber of $1 bills: %d\n\n",
                    money10,
                    money5,
                    money1
                );
            } else {
                // Type 2 customer
                System.out.printf("Enter the amount to be withdrawn: ");
                int money = input.nextInt();

                while (money <= 0 || money > 500) {
                    System.out.printf("Invalid amount: %d\n", money);
                    System.out.printf("Enter the amount to be withdrawn: ");
                    money = input.nextInt();
                }

                if (money % 5 != 0) {
                    System.out.printf(
                        "You are a type 2 customer, but the amount you requested was %d.\nYou will be charged $1 for changing your default setting.\nDo you want to be charged $1? (y/n) ",
                        money
                    );
                    char userInput = input.next().toLowerCase().charAt(0);

                    while (userInput != 'y') {
                        System.out.printf("Enter the amount to be withdrawn: ");
                        money = input.nextInt();

                        if (money <= 0 || money > 500) {
                            System.out.printf("Invalid amount: %d\n", money);
                            System.out.printf(
                                "Enter the amount to be withdrawn: "
                            );
                            money = input.nextInt();
                        }

                        if (money % 5 != 0) {
                            System.out.printf(
                                "You are a type 2 customer, but the amount you requested was %d.\nYou will be charged $1 for changing your default setting.\nDo you want to be charged $1? (y/n) ",
                                money
                            );
                            userInput = input.next().toLowerCase().charAt(0);
                        } else {
                            break;
                        }
                    }

                    if (userInput == 'y') {
                        money -= 1;
                        int money10 = money / 10;
                        int money5 = (money - (money10 * 10)) / 5;
                        int money1 = money - (money10 * 10) - (money5 * 5);

                        System.out.printf(
                            "You are receiving the following bills:\n\tNumber of $10 bills: %d\n\tNumber of $5 bills: %d\n\tNumber of $1 bills: %d\n\n",
                            money10,
                            money5,
                            money1
                        );
                    }
                } else {
                    while (money <= 0 || money > 500) {
                        System.out.printf("Invalid amount: %d\n", money);
                        System.out.printf("Enter the amount to be withdrawn: ");
                        money = input.nextInt();
                    }

                    int money10 = money / 10;
                    int money5 = (money - (money10 * 10)) / 5;
                    int money1 = money - (money10 * 10) - (money5 * 5);

                    System.out.printf(
                        "You are receiving the following bills:\n\tNumber of $10 bills: %d\n\tNumber of $5 bills: %d\n\tNumber of $1 bills: %d\n\n",
                        money10,
                        money5,
                        money1
                    );
                }
            }
        } while (pin > 0);

        System.out.println("The program will terminate!");

        input.close();
    }
}
