package logic;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralConverterTest {

    private RomanNumeralConverter romanNumeralConverter;

    @Before
    public void setUp() {
        romanNumeralConverter = new RomanNumeralConverter();
    }

    @Test
    public void convertsDefaultRomanNumberToDecimalNumber() {
        int decimalValue = romanNumeralConverter.convertToDecimal("MMVII");

        assertThat(decimalValue).isEqualTo(2007);
    }
}
