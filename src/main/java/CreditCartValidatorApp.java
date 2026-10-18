import java.util.Scanner;

public class CreditCartValidatorApp {
    public static void run() {
        Scanner input = new Scanner(System.in);
        CardInputFormatter formatter = new CardInputFormatter();
        LuhnValidator validator = new LuhnValidator();
        CardTypeDetector detector = new CardTypeDetector();

        while (true) {
            System.out.print("Enter credit card number ('q' to quit): ");
            String inp = input.nextLine();

            if (inp.toLowerCase().startsWith("q")) {
                break;
            }

            FormattedInput formattedCardNumber = formatter.formatCardNumber(inp);

            if (!formattedCardNumber.isValid()) {
                System.out.println("Invalid card number!");
                continue;
            }

            String cleanCardNumber = formattedCardNumber.cleanNumber();
            CardType cardType = detector.detectType(cleanCardNumber);

            if (cardType == CardType.UNKNOWN) {
                System.out.println("Unknown card type!");
                continue;
            }

            boolean isValid = detector.isValidLength(cleanCardNumber, cardType);

            if (!isValid) {
                System.out.println("Invalid length!");
                continue;
            }

            boolean isValidForLuhn = validator.isValidLuhn(cleanCardNumber);

            if (isValidForLuhn) {
                System.out.println("Success: The " + cardType + "-type card number " + cleanCardNumber + " has passed the Luhn algorithm.");
            } else {
                System.out.println("Failed: The " + cardType + "-type card number " + cleanCardNumber + " did not pass the Luhn algorithm.");
            }
        }
    }
}
