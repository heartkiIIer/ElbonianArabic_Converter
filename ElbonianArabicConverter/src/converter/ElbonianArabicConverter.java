package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    //A string that holds the number (Elbonian or Arabic) you would like to convert
    private String number = null;

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

        boolean conditionX = false;
        boolean nmComboValid = false;
        boolean dcComboValid = false;
        boolean yxComboValid = false;
        boolean jiComboValid = false;

        String holder = null;
        number = number.replaceAll(" ",""); //remove all spaces; leading, trailing, and in-between

        if((number != null) && (!number.equals("")) && (number.matches("[0-9]+")) && (number.charAt(0) != '0') && (Integer.parseInt(number) <= 9999) && (Integer.parseInt(number) != 0)) {
            this.number = number;
        } else if((number != null) && (!number.equals("")) && (number.matches("N{0,3}M{0,2}D{0,3}C{0,2}Y{0,3}X{0,2}J{0,3}I{0,2}"))) {
            conditionX = true;
            holder = number;
        }
        /*else if(Integer.parseInt(number) <= 0 || Integer.parseInt(number) > 9999) {
            throw new ValueOutOfBoundsException("Input Arabic exceeds Elbonian bounds.");
        } else if(Double.parseDouble(number) <= 0 || Double.parseDouble(number) >= 0) {
            throw new ValueOutOfBoundsException("Input Arabic cannot be decimal.");
        }
        */

        if(conditionX && (holder != null) && (!holder.equals(""))) {

            if (holder.matches("(N{3})D*C*Y*X*J*I*") || holder.matches("(N{0,2})M*D*C*Y*X*J*I*")) {
                nmComboValid = true;
            } else {
                return;
            }

            if (holder.matches("N*M*(D{3})Y*X*J*I*") || holder.matches("N*M*(D{0,2})C*Y*X*J*I*")) {
                dcComboValid = true;
            } else {
                return;
            }

            if (holder.matches("N*M*D*C*(Y{3})J*I*") || holder.matches("N*M*D*C*(Y{0,2})X*J*I*")) {
                yxComboValid = true;
            } else {
                return;
            }

            if (holder.matches("N*M*D*C*Y*X*(J{3})") || holder.matches("N*M*D*C*Y*X*(J{0,2})I*")) {
                jiComboValid = true;
            } else {
                return;
            }
        } else { return; }

        if(nmComboValid && dcComboValid && yxComboValid && jiComboValid) {
            number = holder;
            this.number = number;
        } else { return; }

    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        // TODO Fill in the method's body
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == 'N') {
                count += 3000;
            }
            if(number.charAt(i) == 'M') {
                count += 1000;
            }
            if(number.charAt(i) == 'D') {
                count += 300;
            }
            if(number.charAt(i) == 'C') {
                count += 100;
            }
            if(number.charAt(i) == 'Y') {
                count += 30;
            }
            if(number.charAt(i) == 'X') {
                count += 10;
            }
            if(number.charAt(i) == 'J') {
                count += 3;
            }
            if(number.charAt(i) == 'I') {
                count += 1;
            }
        }
        return count;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // TODO Fill in the method's body
        int arabic = Integer.parseInt(number);
        StringBuilder Elbo = new StringBuilder();
        int remainder = arabic % 3000;
        int timesDivided = arabic / 3000;
        for (int i = 0; i <timesDivided; i++) {
            Elbo.append('N');
        }

        int remainder2 = remainder % 1000;
        int timesDivided2 = remainder / 1000;
        for (int i = 0; i <timesDivided2; i++) {
            Elbo.append('M');
        }

        int remainder3 = remainder2 % 300;
        int timesDivided3 = remainder2 / 300;
        for (int i = 0; i <timesDivided3; i++) {
            Elbo.append('D');
        }

        int remainder4 = remainder3 % 100;
        int timesDivided4 = remainder3 / 100;
        for (int i = 0; i <timesDivided4; i++) {
            Elbo.append('C');
        }

        int remainder5 = remainder4 % 30;
        int timesDivided5 = remainder4 / 30;
        for (int i = 0; i <timesDivided5; i++) {
            Elbo.append('Y');
        }

        int remainder6 = remainder5 % 10;
        int timesDivided6 = remainder5 / 10;
        for (int i = 0; i <timesDivided6; i++) {
            Elbo.append('X');
        }

        int remainder7 = remainder6 % 3;
        int timesDivided7 = remainder6 / 3;
        for (int i = 0; i <timesDivided7; i++) {
            Elbo.append('J');
        }

        int timesDivided8 = remainder7 / 1;
        for (int i = 0; i < timesDivided8; i++) {
            Elbo.append('I');
        }

        return Elbo.toString();
    }

}
