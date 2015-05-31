package logic;

public class RomanNumeralsValidator {

    public void validate(String romanNumber) {
        int iCounter = 0, xCounter = 0, cCounter = 0, mCounter = 0;
        int dCounter = 0, lCounter = 0, vCounter = 0;

        for (int i = 0; i < romanNumber.length(); i++) {

            if (romanNumber.charAt(i) == 'I') {
                iCounter++;
            } else {
                iCounter = 0;
            }

            if (romanNumber.charAt(i) == 'X') {
                xCounter++;
            } else {
                xCounter = 0;
            }

            if (romanNumber.charAt(i) == 'C') {
                cCounter++;
            } else {
                cCounter = 0;
            }

            if (romanNumber.charAt(i) == 'M') {
                mCounter++;
            } else {
                mCounter = 0;
            }

            if (romanNumber.charAt(i) == 'D') {
                dCounter++;
            } else  {
                dCounter = 0;
            }

            if (romanNumber.charAt(i) == 'L') {
                lCounter++;
            } else  {
                lCounter = 0;
            }

            if(romanNumber.charAt(i) == 'V') {
                vCounter++;
            } else  {
                vCounter = 0;
            }

            if (iCounter == 4 || xCounter == 4 || cCounter == 4 || mCounter == 4 || dCounter == 2 || lCounter == 2 || vCounter == 2) {
                throw new RuntimeException();
            }
        }
    }
}
