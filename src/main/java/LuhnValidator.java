public class LuhnValidator {
    public boolean isValidLuhn(String cardNumber) {
        int total = 0;
        boolean isSecondFromRight;
        for (int i = cardNumber.length() - 1 , step = 1; i >= 0; i--, step++) {
            int number = cardNumber.charAt(i) - '0';

            isSecondFromRight = step % 2 == 0;

            if (isSecondFromRight) {
                number *= 2;
                total += number > 9 ? number - 9 : number;
            } else {
                total += number;
            }
        }

        return total % 10 == 0;
    }
}
