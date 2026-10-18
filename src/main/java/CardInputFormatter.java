import java.util.regex.Pattern;

public class CardInputFormatter {
    public static final Pattern NUMERIC_PATTERN = Pattern.compile("^\\d+$");

    public FormattedInput formatCardNumber(String cardNumber) {
        String cleanedCardNumber = "";
        if (cardNumber == null || cardNumber.isEmpty()) return new FormattedInput(false, "");
        if (cardNumber.contains(" ")) cardNumber = cardNumber.replace(" ", "");
        if (cardNumber.contains("-")) cardNumber = cardNumber.replace("-", "");
        cleanedCardNumber = cardNumber;
        if (!NUMERIC_PATTERN.matcher(cleanedCardNumber).matches()) return new FormattedInput(false, "");
        return new FormattedInput(true, cleanedCardNumber);
    }
}
