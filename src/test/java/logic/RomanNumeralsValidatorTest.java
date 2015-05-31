package logic;

import org.junit.Before;
import org.junit.Test;

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
}