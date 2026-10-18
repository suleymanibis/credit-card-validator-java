import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTypeDetectorTest {
    private CardTypeDetector detector;

    @BeforeEach
    void setUp(){
        detector = new CardTypeDetector();
    }

    @Test
    void testCartTypeDetector_WhenCardNumberIsValidForVisa(){
        String cardNumber = "4123123123";

        CardType result = detector.detectType(cardNumber);
        assertEquals(CardType.VISA, result);
    }

    @Test
    void testCartTypeDetector_WhenCardNumberIsValidForMasterCard(){
        String cardNumber = "5123123123";
        String cardNumber2 = "5223123123";
        String cardNumber3 = "5323123123";
        String cardNumber4 = "5423123123";
        String cardNumber5 = "5523123123";

        CardType result = detector.detectType(cardNumber);
        assertEquals(CardType.MASTERCARD, result);

        CardType result2 = detector.detectType(cardNumber2);
        assertEquals(CardType.MASTERCARD, result2);

        CardType result3 = detector.detectType(cardNumber3);
        assertEquals(CardType.MASTERCARD, result3);

        CardType result4 = detector.detectType(cardNumber4);
        assertEquals(CardType.MASTERCARD, result4);

        CardType result5 = detector.detectType(cardNumber5);
        assertEquals(CardType.MASTERCARD, result5);
    }

    @Test
    void testCartTypeDetector_WhenCardNumberIsValidForTroy(){
        String cardNumber = "9792123123";

        CardType result = detector.detectType(cardNumber);
        assertEquals(CardType.TROY, result);
    }

    @Test
    void testCartTypeDetector_WhenCardNumberIsValidForAmex(){
        String cardNumber = "3792123123";
        String cardNumber2 = "3492123123";

        CardType result = detector.detectType(cardNumber);
        assertEquals(CardType.AMEX, result);
        CardType result2 = detector.detectType(cardNumber2);
        assertEquals(CardType.AMEX, result2);
    }

    @Test
    void testCartTypeDetector_WhenCardNumberIsInvalid(){
        String cardNumber = "13792123123";

        CardType result = detector.detectType(cardNumber);
        assertEquals(CardType.UNKNOWN, result);
    }

    @Test
    void testCartTypeDetector_WhenCardTypeIsVisaForValidLength(){
        boolean result1 = detector.isValidLength("4123123123234", CardType.VISA);
        boolean result2 = detector.isValidLength("4123123123234567", CardType.VISA);

        assertTrue(result1);
        assertTrue(result2);
    }

    @Test
    void testCartTypeDetector_WhenCardTypeIsVisaForInvalidLength(){
        boolean result = detector.isValidLength("412312312323", CardType.VISA);
        assertFalse(result);
    }

    @Test
    void testCartTypeDetector_WhenCardTypeIsMastercardForValidLength(){
        boolean result = detector.isValidLength("5223123123234567", CardType.MASTERCARD);
        assertTrue(result);
    }

    @Test
    void testCartTypeDetector_WhenCardTypeIsMastercardForInvalidLength(){
        boolean result = detector.isValidLength("412312312323", CardType.MASTERCARD);
        assertFalse(result);
    }

    @Test
    void testCartTypeDetector_WhenCardTypeIsTroyForValidLength(){
        boolean result = detector.isValidLength("9792123123234567", CardType.TROY);
        assertTrue(result);
    }

    @Test
    void testCartTypeDetector_WhenCardTypeIsTroyForInvalidLength(){
        boolean result = detector.isValidLength("979212312323", CardType.TROY);
        assertFalse(result);
    }

    @Test
    void testCartTypeDetector_WhenCardTypeIsAmexForValidLength(){
        boolean result = detector.isValidLength("342312312323467", CardType.AMEX);
        assertTrue(result);
    }

    @Test
    void testCartTypeDetector_WhenCardTypeIsAmexForInvalidLength(){
        boolean result = detector.isValidLength("34231231232346", CardType.AMEX);
        assertFalse(result);
    }

    @Test
    void testCartTypeDetector_WhenCardTypeIsUnknown(){
        boolean result = detector.isValidLength("302312312323467", CardType.UNKNOWN);
        assertFalse(result);
    }
}
