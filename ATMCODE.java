package aTMachine; // change as needed for your setup
import java.util.Scanner;

public class ATMCODE {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pin = 0;

        System.out.print("Please enter your pin: ");
        pin = input.nextInt();

        if (pin > 0) {
            if (pin % 2 != 0) {
                // Type 1 customer
                System.out.printf("%n%nHow much money would you like: ");
                int money = input.nextInt();

                while (money <= 0 || money > 500) {
                    System.out.printf(
                        "%nError: cannot dispense more than $500"
                    );
                    System.out.printf("%n%nHow much money would you like: ");
                    money = input.nextInt();
                }

                int money20 = money / 20;
                int money10 = (money - (money20 * 20)) / 10;
                int money5 = (money - (money10 * 10) - (money20 * 20)) / 5;
                int money1 = (money -
                    (money20 * 20) -
                    (money10 * 10) -
                    (money5 * 5));

                System.out.printf(
                    "\nYou will receive: \nTwenties: %d\nTens:%d\nFives:%d\nSingles:%d",
                    money20,
                    money10,
                    money5,
                    money1
                );
            } else {
                // Type 2 customer
                System.out.printf("%n%nHow much money would you like: ");
                int money = input.nextInt();

                while (money <= 0 || money > 500) {
                    System.out.printf(
                        "%nError: cannot dispense more than $500"
                    );
                    System.out.printf("%n%nHow much money would you like: ");
                    money = input.nextInt();
                }

                if (money % 5 != 0) {
                    System.out.printf(
                        "%nThe value you you entered isn't divisible by 5 and will be charged at a 1 dollar. Do you accept? (y/n)"
                    );
                    char userInput = input.next().toLowerCase().charAt(0);

                    while (userInput != 'y') {
                        System.out.printf(
                            "%n%nHow much money would you like: "
                        );
                        money = input.nextInt();

                        if (money <= 0 || money > 500) {
                            System.out.printf(
                                "%nError: cannot dispense more than $500"
                            );
                            System.out.printf(
                                "%n%nHow much money would you like: "
                            );
                            money = input.nextInt();
                        }

                        if (money % 5 != 0) {
                            System.out.printf(
                                "%nThe value you you entered isn't divisible by 5 and will be charged at a 1 dollar. Do you accept? (y/n)"
                            );
                            userInput = input.next().toLowerCase().charAt(0);
                        } else {
                            break;
                        }
                    }

                    if (userInput == 'y') {
                        money -= 1;
                        int money20 = money / 20;
                        int money10 = (money - (money20 * 20)) / 10;
                        int money5 =
                            (money - (money10 * 10) - (money20 * 20)) / 5;
                        int money1 = (money -
                            (money20 * 20) -
                            (money10 * 10) -
                            (money5 * 5));

                        System.out.printf(
                            "\nYou will receive: \nTwenties: %d\nTens:%d\nFives:%d\nSingles:%d",
                            money20,
                            money10,
                            money5,
                            money1
                        );
                    } else {
                    }
                } else {
                    System.out.printf("%n%nHow much money would you like: ");
                    money = input.nextInt();

                    while (money <= 0 || money > 500) {
                        System.out.printf(
                            "%nError: cannot dispense more than $500"
                        );
                        System.out.printf(
                            "%n%nHow much money would you like: "
                        );
                        money = input.nextInt();
                    }

                    int money20 = money / 20;
                    int money10 = (money - (money20 * 20)) / 10;
                    int money5 = (money - (money10 * 10) - (money20 * 20)) / 5;
                    int money1 = (money -
                        (money20 * 20) -
                        (money10 * 10) -
                        (money5 * 5));

                    System.out.printf(
                        "\nYou will receive: \nTwenties: %d\nTens:%d\nFives:%d\nSingles:%d",
                        money20,
                        money10,
                        money5,
                        money1
                    );
                }
            }
        } else {
            System.out.println("goodbye");
        }

        input.close();
    }
}
