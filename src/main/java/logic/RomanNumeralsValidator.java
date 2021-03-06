package logic;

import java.util.ArrayList;

public class RomanNumeralsValidator {

    public static final int LIMIT_FOR_CHARS_I_X_C_M = 4;
    public static final int LIMIT_FOR_CHARS_D_L_V = 2;

    private ArrayList<Character> list = new ArrayList<>();
    private RomanNumeralsMapper mapper = new RomanNumeralsMapper();

    public RomanNumeralsValidator() {
        constructList();
    }

    private void constructList() {
        list.add('I');
        list.add('X');
        list.add('C');
        list.add('M');
        list.add('D');
        list.add('L');
        list.add('V');
    }

    public void validate(String romanNumber) {
        validateDuplicationInRomanNumeral(romanNumber);
        validateDuplicationForSubtraction(romanNumber);
        validateSubtractionOfI(romanNumber);
        validateSubtractionOfX(romanNumber);
        validateSubtractionOfC(romanNumber);
        validateSubtractionOfVLD(romanNumber);
    }

    private void validateSubtractionOfVLD(String romanNumber) {
        for(int i = 0; i < romanNumber.length(); i++) {
            char currentChar = romanNumber.charAt(i);
            if (isNextCharPresent(i,romanNumber.length())
                    && (currentChar == 'V' || currentChar == 'L' || currentChar == 'D')) {
                int currentValue = mapper.getDeciamlValueFrom(currentChar);
                int nextValue = mapper.getDeciamlValueFrom(romanNumber.charAt(i+1));

                if (nextValue > currentValue)
                    throw new RuntimeException();
            }
        }
    }

    private void validateDuplicationInRomanNumeral(String romanNumber) {
        int counter = 0;
        char lastCharacter = romanNumber.charAt(0);

        for (int i = 0; i < romanNumber.length(); i++) {
            char currentChar = romanNumber.charAt(i);

            if (list.contains(currentChar)) {
                if ( lastCharacter == currentChar ) {
                    counter++;
                } else  {
                    counter = 1;
                    lastCharacter = currentChar;
                }
            }

            throwExceptionIfCounterOverLimitForChar(lastCharacter, counter);
        }
    }

    private void validateDuplicationForSubtraction(String romanNumber) {
        for(int i = 1; i < romanNumber.length(); i++) {
            char currentChar = romanNumber.charAt(i);

            if (isNextCharPresent(i, romanNumber.length()) ) {
                int fValue = mapper.getDeciamlValueFrom(currentChar);
                int sValue = mapper.getDeciamlValueFrom(romanNumber.charAt(i+1));
                int prevVal = mapper.getDeciamlValueFrom(romanNumber.charAt(i-1));

                if (sValue > fValue && prevVal <= fValue)
                    throw new RuntimeException();
            }
        }
    }

    private void validateSubtractionOfI(String romanNumber) {
        for (int i = 0; i <romanNumber.length(); i++) {
            if (isNextCharPresent(i, romanNumber.length()) && romanNumber.charAt(i) == 'I') {
                if(romanNumber.charAt(i+1) != 'V' && romanNumber.charAt(i+1) != 'X' && romanNumber.charAt(i+1) != 'I')
                    throw new RuntimeException();
            }
        }
    }

    private void validateSubtractionOfX(String romanNumber) {
        for (int i = 0; i <romanNumber.length(); i++) {
            if (isNextCharPresent(i, romanNumber.length()) && romanNumber.charAt(i) == 'X') {
                if(romanNumber.charAt(i+1) != 'C' && romanNumber.charAt(i+1) != 'L' && romanNumber.charAt(i+1) != 'X')
                    throw new RuntimeException();
            }
        }
    }

    private void validateSubtractionOfC(String romanNumber) {
        for (int i = 0; i <romanNumber.length(); i++) {
            if (isNextCharPresent(i, romanNumber.length()) && romanNumber.charAt(i) == 'C') {
                if(romanNumber.charAt(i+1) != 'D' && romanNumber.charAt(i+1) != 'M' && romanNumber.charAt(i+1) != 'I')
                    throw new RuntimeException();
            }
        }
    }
    
    private boolean isNextCharPresent(int currentPosition, int strLength) {
        return strLength - 1  > currentPosition;
    }

    private boolean characterEqualIorXorCorM(char lastCharacter) {
        return (lastCharacter == 'I' || lastCharacter == 'X' || lastCharacter == 'C' || lastCharacter == 'M');
    }

    private boolean characterEqualDorLorV(char lastCharacter) {
        return (lastCharacter == 'D' || lastCharacter == 'L' || lastCharacter == 'V');
    }

    private void throwExceptionIfCounterOverLimitForChar(char lastCharacter, int counter) {
        if( counter == LIMIT_FOR_CHARS_I_X_C_M && characterEqualIorXorCorM(lastCharacter)
                || (counter == LIMIT_FOR_CHARS_D_L_V && characterEqualDorLorV(lastCharacter))) {
            throw  new RuntimeException();
        }
    }
}
