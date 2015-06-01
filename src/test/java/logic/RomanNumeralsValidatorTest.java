package logic;

import org.junit.Before;
import org.junit.Test;
import org.omg.SendingContext.RunTime;

public class RomanNumeralsValidatorTest {
    private RomanNumeralsValidator romanNumeralsValidator;

    @Before
    public void setUp() {
        romanNumeralsValidator = new RomanNumeralsValidator();
    }

    @Test
    public void shouldNotThrowExceptionWhenNumberCorrect() {
        String romanNumber = "MCMXLIV";

        romanNumeralsValidator.validate("MCMXLIV");
    }

    @Test(expected = RuntimeException.class)
    public void throwExceptionWhenIRepeatedMoreThenThreeTimes() {
        String romanNumber= "MCMXIIII";

        romanNumeralsValidator.validate(romanNumber);
    }

    @Test(expected = RuntimeException.class)
    public void throwExceptionWhenXRepeateMoreThenThreeTimes() {
        String romanNumber = "MCMXXXXI";

        romanNumeralsValidator.validate(romanNumber);
    }

    @Test(expected =  RuntimeException.class)
    public void throwExceptionWhenCRepeatedMoreThenThreeTimes() {
        String romanNumber = "MCCCCMXI";

        romanNumeralsValidator.validate(romanNumber);
    }

    @Test(expected =  RuntimeException.class)
    public void throwExceptionWhenMRepeatedMoreThenThreeTimes() {
        String romanNumber = "MCMMMMXI";

        romanNumeralsValidator.validate(romanNumber);
    }

    @Test(expected =  RuntimeException.class)
    public void throwExceptionWhenDRepeated() {
        String romanNumber = "MCMDD";

        romanNumeralsValidator.validate(romanNumber);
    }

    @Test(expected = RuntimeException.class)
    public void throwExceptionWhenLRepeated() {
        String romanNumber = "MCMLL";

        romanNumeralsValidator.validate(romanNumber);
    }

    @Test(expected = RuntimeException.class)
    public void throwExceptionWhenVRepeated() {
        String romanNumber = "MCMVV";

        romanNumeralsValidator.validate(romanNumber);
    }

    @Test(expected = RuntimeException.class)
    public void throwExceptionWhenNumeralRepeatedForSubtraction() {
        String romanNumber = "MCCMLI";

        romanNumeralsValidator.validate(romanNumber);
    }

    @Test(expected = RuntimeException.class)
    public void throwExceptionWhenISubtractedNotFromTheVorX() {
        String romanNumber = "MCMXLIC";

        romanNumeralsValidator.validate(romanNumber);
    }
}
