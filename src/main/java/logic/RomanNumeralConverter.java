package logic;

public class RomanNumeralConverter {

    private RomanNumeralsValidator romanNumeralsValidator = new RomanNumeralsValidator();
    private RomanNumeralsMapper mapper = new RomanNumeralsMapper();

    public int convertToDecimal(String romanNumber) {
        int summary = 0;

        romanNumeralsValidator.validate(romanNumber);

        for(int i = 0; i < romanNumber.length(); i++) {
            if (notLastCharacter(i, romanNumber.length() - 1) && shouldSubstract(romanNumber.charAt(i), romanNumber.charAt(i+1))) {
                summary += doSubtract(romanNumber, i++);
                continue;
            }

            char romanDigit = romanNumber.charAt(i);
            summary += mapper.getDeciamlValueFrom(romanDigit);
        }
        
        return summary;
    }

    private boolean shouldSubstract(char current, char next) {
        return mapper.getDeciamlValueFrom(next) > mapper.getDeciamlValueFrom(current);
    }

    private boolean notLastCharacter(int currentPosition, int maxPosition) {
        return maxPosition > currentPosition;
    }

    private int doSubtract(String romanNumeral, int currentPosition) {
        int smaller = mapper.getDeciamlValueFrom(romanNumeral.charAt(currentPosition));
        int higher = mapper.getDeciamlValueFrom(romanNumeral.charAt(currentPosition + 1));

        return higher - smaller;
    }



}
