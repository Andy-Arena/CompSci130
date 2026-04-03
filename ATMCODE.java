package aTMachine;
import java.util.Scanner;

public class ATMCODE {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int pin = 0;
		
		System.out.print("Please enter your pin: ");
		pin = input.nextInt();
		
		if (pin > 0) {
			if (pin %2 == 0) {
				System.out.printf("%n%nHow much money would you like: ");
				int money = input.nextInt();
				if (money < 0 && money > 100) {
					System.out.printf("%nError: cannot dispense more than $500");
					System.out.printf("%n%nHow much money would you like: ");
					money = input.nextInt();
				} else {
					int money20 = money/20;
					int money10 = (money - (money20*20))/10;
					int money5 = (money - (money10*10) - (money20*20))/5;
					int money1 = (money - (money20*20) - (money10*10) - (money5*5));
					System.out.printf("%n%s%n%s %d%n%s %d%n%s %d%n%s %d",
							"You will recieve:", "Twenties:", money20, "Tens:",
							money10,"Fives:", money5,"Singles:", money1);
				}
			}
		}else {
			//GOODBYE
		}
		
	}

}
