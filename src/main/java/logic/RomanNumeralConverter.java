package logic;

import java.util.HashMap;

public class RomanNumeralConverter {

    private HashMap<Character, Integer> mapping = new HashMap<Character, Integer>();

    public RomanNumeralConverter() {
        buildMapping();
    }

    private void buildMapping() {
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
    }

    public int convertToDecimal(String romanNumber) {
        int summary = 0;
        for(int i = 0; i < romanNumber.length(); i++) {
            char romanDigit = romanNumber.charAt(i);
            summary += mapping.get(romanDigit);
        }
        
        return summary;
    }



}
