package programingAssignment2;

import java.util.Scanner;

public class ElectricBill {

    public static Scanner input = new Scanner(System.in);

    //public static double kWH = 0.0;

    // Method to determine customer type
    public static boolean customerType() {
        boolean whatType = true;
        System.out.printf(
            "Enter customer type: R, r (Residential) or B, b (Business):\n"
        );
        char custType = input.next().toLowerCase().charAt(0);

        if (custType == 'r') {
            whatType = true;
        } else if (custType == 'b') {
            whatType = false;
        } else {
            whatType = customerType();
            //			System.out.printf("Error%nEnter Customer Type: R,r (Residential) or B, b (Business):%n");
            //		custType = input.next().charAt(0);
        }

        return whatType;
    }

    // Method to calculate residential bill
    public static double calcResidential() {
        // variable to calculate the bill for residental
        double userEnergy = 0.0,
            energyCharge = 0.12,
            flatCharge = 8.07,
            resSalesTax = 1.05;

        // input to get kilowatt hours for residential
        System.out.printf("Please enter your energy usage in kWh:%n");
        userEnergy = input.nextDouble();

        return ((userEnergy * energyCharge) + flatCharge) * resSalesTax;
    }

    // Method to calculate the business bill
    public static double calcBusiness() {
        // variables to calculate bill for business
        double userEnergy = 0.0,
            energyChargeb4 = 0.17,
            energyChargeAfter = 0.12,
            flatCharge = 17.07,
            busSalesTax = 1.08;

        // input to get kilowatt hours and number of prem channels
        System.out.printf("Please enter your energy usage in kWh: %n");
        userEnergy = input.nextDouble();
        System.out.printf("How many Premium channels? %n");
        int premChannel = input.nextInt();

        if (userEnergy <= 1200) {
            // return if energy is less than 1200
            return (
                ((userEnergy * energyChargeb4) +
                    flatCharge +
                    (premChannel * 47)) *
                busSalesTax
            );
        } else {
            // return if energy is greater than 1200
            return (
                ((1200 * energyChargeb4) +
                    ((userEnergy - 1200) * energyChargeAfter) +
                    flatCharge +
                    (premChannel * 47)) *
                busSalesTax
            );
        }
    }

    // Method to Display amount due
    public static void displayBill(double bill) {
        System.out.printf(
            "%nAmount Due = %.2f%n30 Billing Days%nAverage Cost per Day = %.2f",
            bill,
            (bill / 30)
        );
    }

    // Method to run the installment plan
    public static void installmentPlan(double bill) {
        System.out.println("--------------------------------");
        System.out.printf(
            "If you do not want to make a onetime payment, we have an easy installment plan for you. This is an intrest charge plan.%nSign up for the Installment Payment Plan (y/n)?%n"
        );
        char x = input.next().toLowerCase().charAt(0);
        switch (x) {
            case 'y':
                System.out.printf(
                    "Number of required installments? (2, 3, or 4):%n"
                );
                int userChoice = input.nextInt();
                switch (userChoice) {
                    case 2:
                        System.out.printf(
                            "With 2 installment options your bill of $%.2f will be worth $%.2f.%nEach installment will be worth $%.2f",
                            bill,
                            bill * 1.0535,
                            ((bill * 1.0535) / 2)
                        );
                        break;
                    case 3:
                        System.out.printf(
                            "With 3 installment options your bill of $%.2f will be worth $%.2f.%nEach installment will be worth $%.2f",
                            bill,
                            bill * 1.055,
                            ((bill * 1.055) / 3)
                        );
                        break;
                    case 4:
                        System.out.printf(
                            "With 4 installment options your bill of $%.2f will be worth $%.2f.%nEach installment will be worth $%.2f",
                            bill,
                            bill * 1.0575,
                            ((bill * 1.0575) / 4)
                        );
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
            case 'n':
                break;
            default:
                System.out.print("Error");
        }
    }

    // Method to calc and display change in rate of consumption
    public static void changeInConsumption(double bill) {
        double deltaBill;
        System.out.printf("What was your last bill?");
        double lastBill = input.nextDouble();
        if (lastBill > bill) {
            deltaBill = (lastBill - bill) / lastBill;
        } else if (lastBill < bill) {
            deltaBill = (bill - lastBill) / lastBill;
        } else {
            deltaBill = 0;
        }
        if (deltaBill != 0) {
            System.out.printf(
                "Your energy consumption is %s by %.2f%% when comparted to the previous one.",
                (deltaBill > 0 ? "increasing" : "decreasing"),
                (deltaBill * 100)
            );
        } else {
            System.out.printf(
                "Your energy consumption has stayed the same when compared to the previous one."
            );
        }
    }

    // Method to display the main menu
    public static void menuDisplay(double billing) {
        displayBill(billing);
        // main while statement
        char userInput;
        do {
            System.out.printf(
                "%n%nI- Enroll in out installment plan%nV- View Change in consumption with previous bill%nE- Exit%nUser Choice: "
            );
            userInput = input.next().toLowerCase().charAt(0);

            // switch case to assess userInput
            switch (userInput) {
                case 'i':
                    // do you really want a plan?
                    //System.out.printf("Do you really wish to sign up for the installment plan?(y/n):%n");
                    //char accept = input.next().charAt(0);

                    // mini switch menu
                    //switch (accept){
                    //case 'y':case 'Y':
                    installmentPlan(billing); // call installment plan
                    //	break;
                    //case 'n':case'N':
                    // just break
                    //	break;
                    //default:
                    //	System.out.print("error"); // temp message
                    //}
                    break;
                case 'v':
                    changeInConsumption(billing);
                    break;
                case 'e':
                    System.out.printf("%nGoodbye");
                    break;
                default:
                    System.out.print("try again");
                    break;
            }
        } while (userInput != 'e');
    }

    public static void main(String[] args) {
        double amountDue = 0;

        boolean customer = customerType(); // changed to boolean type
        if (customer == true) {
            amountDue = calcResidential();
        } else {
            amountDue = calcBusiness();
        }
        menuDisplay(amountDue);
    }
}
