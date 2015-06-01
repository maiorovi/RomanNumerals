package logic;

import java.util.HashMap;

public class RomanNumeralsMapper {

    private HashMap<Character, Integer> romanNumeralsToDecimalValMapping = new HashMap<>();

    public RomanNumeralsMapper() {
        buildDecimalMapping();
    }

    public int getDeciamlValueFrom(Character romanNumeral) {
        return romanNumeralsToDecimalValMapping.get(romanNumeral);
    }

    private void buildDecimalMapping() {
        romanNumeralsToDecimalValMapping.put('I', 1);
        romanNumeralsToDecimalValMapping.put('V', 5);
        romanNumeralsToDecimalValMapping.put('X', 10);
        romanNumeralsToDecimalValMapping.put('L', 50);
        romanNumeralsToDecimalValMapping.put('C', 100);
        romanNumeralsToDecimalValMapping.put('D', 500);
        romanNumeralsToDecimalValMapping.put('M', 1000);
    }
}
