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

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;
    private boolean isArabic;

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

        // TODO check to see if the number is valid, then set it equal to the string
        number = number.trim(); // remove leading numbers

        isArabic = true;

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == ' '){
                throw new ValueOutOfBoundsException("This Number has a Space in it; making it Invalid");
            }
            if (!Character.isDigit(number.charAt(i))) {
                isArabic = false;
            }
        }

        if isArabic{ // If the Number is Arabic
            //First Make sure it is not greater than 9999
            //Then convert the Number to Elbonian
            if (number.length() > 4){
                throw new ValueOutOfBoundsException("This number has too many characters so it exceds the maximum value limit of 9999");
            }
            for (int i = 0; i < number.length(); i++){
                if (!Character.isDigit(number.charAt(i))) {
                    throw new ValueOutOfBoundsException("This number is a mix between Elbonian and Arabic and is Invalid");
                }
            }

            this.number = number;

            toElbonian(this.number);
        }
        if !isArabic{ // If the number is elbonian
            //Convert the Elbonian Number to Arabic
            int mcount = 0;
            int ccount = 0;
            int xcount = 0;
            int icount = 0;
            int ncount = 0;
            int dcount = 0;
            int ycount = 0;
            int jcount = 0;

            boolean isValid = true;

            int count;
            for (int i = 0; i<number.length(); i++) {
                //Checking to Make sure the Elbonian ONLY consists of MCXI etc.
                if(number.charAt(i) == 'M' || number.charAt(i) == 'C' || number.charAt(i) == 'X' || number.charAt(i) == 'I' || number.charAt(i) == 'N' || number.charAt(i) == 'D' || number.charAt(i) == 'Y' || number.charAt(i) == 'J') {
                    if(number.charAt(i) == 'M'){
                        mcount++;
                        if (mcount >2 ){
                            isValid = false;
                        }
                    }
                    if(number.charAt(i) == 'C'){
                        ccount++;
                        if (ccount >2 ){
                            isValid = false;
                        }
                    }
                    if(number.charAt(i) == 'X'){
                        xcount++;
                        if (xcount >2 ){
                            isValid = false;
                        }
                    }
                    if(number.charAt(i) == 'I'){
                        icount++;
                        if icount >2 ){
                            isValid = false;
                        }
                    }
                    if(number.charAt(i) == 'N'){
                        ncount++;
                        if (ncount >3 ){
                            isValid = false;
                        }
                    }
                    if(number.charAt(i) == 'D'){
                        dcount++;
                        if (dcount >3 ){
                            isValid = false;
                        }
                    }
                    if(number.charAt(i) == 'Y'){
                        ycount++;
                        if (ycount >3 ){
                            isValid = false;
                        }
                    }

                    if(number.charAt(i) == 'J'){
                        jcount++;
                        if (xcount >3 ){
                            isValid = false;
                        }
                    }
                }
                else{
                    isValid = false; //One of the characers in the string is something other than MCXINDYJ
                }
            }
            //Checking Maximum Amount of Each Elbonian Character
            for (int i = 0; i<number.length(); i++) {
                if (number.charAt(i) == 'M' && ncount >= 3) {
                    isValid = false;
                }
                if (number.charAt(i) == 'C' && dcount >= 3) {
                    isValid = false;
                }
                if (number.charAt(i) == 'X' && ycount >= 3) {
                    isValid = false;
                }
                if (number.charAt(i) == 'I' && jcount >= 3) {
                    isValid = false;
                }
                if (number.charAt(i) == 'I') {
                    if (number.charAt(i + 1) != 'I' && i < number.length()) {
                        isValid = false;
                    }
                }
                if (number.indexOf('C') > number.indexOf('M') || number.indexOf('C') > number.indexOf('N') || number.indexOf('C') > number.indexOf('D')) {
                    isValid = false;
                }
                if (number.indexOf('M') > number.indexOf('D') || number.indexOf('M') > number.indexOf('C') || number.indexOf('M') > number.indexOf('Y') || number.indexOf('M') > number.indexOf('X') || number.indexOf('M') > number.indexOf('J') || number.indexOf('M') > number.indexOf('I')) {
                    isValid = false;
                }
                if (number.indexOf('D') > number.indexOf('C') || number.indexOf('D') > number.indexOf('Y') || number.indexOf('D') > number.indexOf('X') || number.indexOf('D') > number.indexOf('J') || number.indexOf('D') > number.indexOf('I')){
                    isValid = false;
                }
                if (number.indexOf('N') != 0 || number.indexOf('I') != number.length() + 1){
                    isValid = false;
                }
            }
        }

        if isValid{
            this.number = number; //It will only get here if the number is Valid for ALL of the elbonian rules
        }

        toArabic(this.number);
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
        for (int i = 0; i < number.length; i++) {
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
        String Elbo;
        int remainder = arabic % 3000;
        int timesDivided = arabic / 3000;
        for (int i = 0; i <timesDivided, i++) {
            Elbo.append('N');
        }

        int remainder2 = remainder % 1000;
        int timesDivided2 = remainder / 1000;
        for (int i = 0; i <timesDivided2, i++) {
            Elbo.append('M');
        }

        int remainder3 = remainder2 % 300;
        int timesDivided3 = remainder2 / 300;
        for (int i = 0; i <timesDivided3, i++) {
            Elbo.append('D');
        }

        int remainder4 = remainder3 % 100;
        int timesDivided4 = remainder3 / 100;
        for (int i = 0; i <timesDivided4, i++) {
            Elbo.append('C');
        }

        int remainder5 = remainder4 % 30;
        int timesDivided5 = remainder4 / 30;
        for (int i = 0; i <timesDivided5, i++) {
            Elbo.append('Y');
        }

        int remainder6 = remainder5 % 10;
        int timesDivided6 = remainder5 / 10;
        for (int i = 0; i <timesDivided6, i++) {
            Elbo.append('X');
        }

        int remainder7 = remainder6 % 3;
        int timesDivided7 = remainder6 / 3;
        for (int i = 0; i <timesDivided7, i++) {
            Elbo.append('J');
        }

        int remainder8 = remainder7 % 1;
        int timesDivided8 = remainder7 / 1;
        for (int i = 0; i <timesDivided, i++) {
            Elbo.append('I');
        }
        return ELBO;
    }

}
