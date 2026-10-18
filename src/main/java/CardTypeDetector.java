public class CardTypeDetector {
    public CardType detectType(String cardNumber) {
        return switch (cardNumber) {
            case String s when s.startsWith("9792") -> CardType.TROY;
            case String s when s.startsWith("51") || s.startsWith("52") || s.startsWith("53") || s.startsWith("54") || s.startsWith("55") -> CardType.MASTERCARD;
            case String s when s.startsWith("4") -> CardType.VISA;
            case String s when s.startsWith("34") || s.startsWith("37") -> CardType.AMEX;
            default -> CardType.UNKNOWN;
        };
    }

    public boolean isValidLength(String cardNumber, CardType type){
        return switch (type) {
            case CardType.VISA -> cardNumber.length() == 13 || cardNumber.length() == 16;
            case CardType.TROY, CardType.MASTERCARD -> cardNumber.length() == 16;
            case CardType.AMEX -> cardNumber.length() == 15;
            case CardType.UNKNOWN -> false;
        };
    }
}
