import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardInputFormatterTest {
    private CardInputFormatter cardInputFormatter;

    @BeforeEach
    void setUp(){
        cardInputFormatter = new CardInputFormatter();
    }

    @Test
    void testCardInputFormatter_IfInputContainsOnlyNumber(){
        String enteredCardNumber = "123456789012";

        FormattedInput result = cardInputFormatter.formatCardNumber(enteredCardNumber);

        assertTrue(result.isValid());
        assertEquals(enteredCardNumber, result.cleanNumber());
    }

    @Test
    void testCardInputFormatter_IfInputContainsHyphenOrSpace(){
        String enteredCardNumber = "1234 5678-9012";
        String formattedCardNumber = enteredCardNumber
                .replace(" ", "")
                .replace("-", "");

        FormattedInput result = cardInputFormatter.formatCardNumber(enteredCardNumber);

        assertTrue(result.isValid());
        assertEquals(formattedCardNumber, result.cleanNumber());
    }

    @Test
    void testCardInputFormatter_IfInputContainsUnsupportedChar(){
        String enteredCardNumber = "1234*56789012";
        FormattedInput result = cardInputFormatter.formatCardNumber(enteredCardNumber);

        assertFalse(result.isValid());
        assertEquals("", result.cleanNumber());
    }

    @Test
    void testCardInputFormatter_IfInputContainsLetter(){
        String enteredCardNumber = "1234a56789012";
        FormattedInput result = cardInputFormatter.formatCardNumber(enteredCardNumber);

        assertFalse(result.isValid());
        assertEquals("", result.cleanNumber());
    }

    @Test
    void testCardInputFormatter_IfInputIsNull(){
        String enteredCardNumber = null;
        FormattedInput result = cardInputFormatter.formatCardNumber(enteredCardNumber);

        assertFalse(result.isValid());
        assertEquals("", result.cleanNumber());
    }

    @Test
    void testCardInputFormatter_IfInputIsEmpty(){
        String enteredCardNumber = "";
        FormattedInput result = cardInputFormatter.formatCardNumber(enteredCardNumber);

        assertFalse(result.isValid());
        assertEquals("", result.cleanNumber());
    }
}
