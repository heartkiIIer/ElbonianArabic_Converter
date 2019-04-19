package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    //A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        boolean nmComboValid = false;
        boolean dcComboValid = false;
        boolean yxComboValid = false;
        boolean jiComboValid = false;

        number = number.replaceAll(" ",""); //remove all spaces; leading, trailing, and in-between

        if((number != null) && (!number.equals("")) && (number.matches("[0-9]+")) && (number.charAt(0) != '0') && (Integer.parseInt(number) <= 9999) && (Integer.parseInt(number) != 0)) {
            this.number = number;

        } else if((number != null) && (!number.equals("")) && (number.matches("N{0,3}M{0,2}D{0,3}C{0,2}Y{0,3}X{0,2}J{0,3}I{0,2}"))) {

            if (number.matches("(N{3})D*C*Y*X*J*I*") || number.matches("(N{0,2})M*D*C*Y*X*J*I*")) {
                nmComboValid = true;
            } else { this.number = null; return; }

            if (number.matches("N*M*(D{3})Y*X*J*I*") || number.matches("N*M*(D{0,2})C*Y*X*J*I*")) {
                dcComboValid = true;
            } else { this.number = null; return; }

            if (number.matches("N*M*D*C*(Y{3})J*I*") || number.matches("N*M*D*C*(Y{0,2})X*J*I*")) {
                yxComboValid = true;
            } else { this.number = null; return; }

            if (number.matches("N*M*D*C*Y*X*(J{3})") || number.matches("N*M*D*C*Y*X*(J{0,2})I*")) {
                jiComboValid = true;
            } else { this.number = null; return; }

            if(nmComboValid && dcComboValid && yxComboValid && jiComboValid) {
                this.number = number;
            } else {
                this.number = null;
                throw new MalformedNumberException("Input Elbonian does not follow Elbonian rules.");
            }

        } else if(number.matches("[0-9]+")) {

            if(Integer.parseInt(number) <= 0 || Integer.parseInt(number) > 9999) {
                this.number = null;
                throw new ValueOutOfBoundsException("Input Arabic exceeds Elbonian bounds.");
            } else if(Double.parseDouble(number) <= 0 || Double.parseDouble(number) >= 0) {
                this.number = null;
                throw new ValueOutOfBoundsException("Input Arabic cannot be decimal.");
            } else { this.number = null; return; }

        } else if(!number.matches("[0-9]+") && !number.matches("N{0,3}M{0,2}D{0,3}C{0,2}Y{0,3}X{0,2}J{0,3}I{0,2}")) {
            this.number = null;
            throw new MalformedNumberException("Input Elbonian does not follow Elbonian rules.");

        } else { this.number = null; return; }
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        if(this.number.matches("[0-9]+")) {
            return Integer.parseInt(this.number);
        } else {
            int arabicNum = 0;
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) == 'N') {
                    arabicNum += 3000;
                }
                if (number.charAt(i) == 'M') {
                    arabicNum += 1000;
                }
                if (number.charAt(i) == 'D') {
                    arabicNum += 300;
                }
                if (number.charAt(i) == 'C') {
                    arabicNum += 100;
                }
                if (number.charAt(i) == 'Y') {
                    arabicNum += 30;
                }
                if (number.charAt(i) == 'X') {
                    arabicNum += 10;
                }
                if (number.charAt(i) == 'J') {
                    arabicNum += 3;
                }
                if (number.charAt(i) == 'I') {
                    arabicNum += 1;
                }
            }
            return arabicNum;
        }
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        if(this.number.matches("N{0,3}M{0,2}D{0,3}C{0,2}Y{0,3}X{0,2}J{0,3}I{0,2}")) {
            return this.number;
        } else {
            int arabic = Integer.parseInt(number);
            StringBuilder Elbo = new StringBuilder();

            int remainder = arabic % 3000;
            int timesDivided = arabic / 3000;
            for (int i = 0; i < timesDivided; i++) {
                Elbo.append('N');
            }

            int remainder2 = remainder % 1000;
            int timesDivided2 = remainder / 1000;
            for (int i = 0; i < timesDivided2; i++) {
                Elbo.append('M');
            }

            int remainder3 = remainder2 % 300;
            int timesDivided3 = remainder2 / 300;
            for (int i = 0; i < timesDivided3; i++) {
                Elbo.append('D');
            }

            int remainder4 = remainder3 % 100;
            int timesDivided4 = remainder3 / 100;
            for (int i = 0; i < timesDivided4; i++) {
                Elbo.append('C');
            }

            int remainder5 = remainder4 % 30;
            int timesDivided5 = remainder4 / 30;
            for (int i = 0; i < timesDivided5; i++) {
                Elbo.append('Y');
            }

            int remainder6 = remainder5 % 10;
            int timesDivided6 = remainder5 / 10;
            for (int i = 0; i < timesDivided6; i++) {
                Elbo.append('X');
            }

            int remainder7 = remainder6 % 3;
            int timesDivided7 = remainder6 / 3;
            for (int i = 0; i < timesDivided7; i++) {
                Elbo.append('J');
            }

            int timesDivided8 = remainder7;
            for (int i = 0; i < timesDivided8; i++) {
                Elbo.append('I');
            }

            return Elbo.toString();
        }
    }
}
