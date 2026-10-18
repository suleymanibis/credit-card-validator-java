import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LuhnValidatorTest {
    private LuhnValidator luhnValidator;

    @BeforeEach
    void setUp(){
        luhnValidator = new LuhnValidator();
    }

    @Test
    void testLuhnValidator_IfCardNumberIsValid(){
        String cardNumber = "79927398713";

        boolean result = luhnValidator.isValidLuhn(cardNumber);

        assertTrue(result);
    }

    @Test
    void testLuhnValidator_IfCardNumberIsInvalid(){
        String cardNumber = "79927398714";

        boolean result = luhnValidator.isValidLuhn(cardNumber);

        assertFalse(result);
    }
}
