package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    /**
     * Test cases for toElbonian() method
     */

    @Test
    public void toElbonainTests() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("3660");
        ElbonianArabicConverter converter0 = new ElbonianArabicConverter("6753");
        ElbonianArabicConverter converter1 = new ElbonianArabicConverter("9999");
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("1");
        ElbonianArabicConverter converter3 = new ElbonianArabicConverter("NNMX");
        ElbonianArabicConverter converter4 = new ElbonianArabicConverter("30");
        ElbonianArabicConverter converter5 = new ElbonianArabicConverter("M");
        ElbonianArabicConverter converter6 = new ElbonianArabicConverter("7357");
        assertEquals(converter.toElbonian(), "NDDYY");
        assertEquals(converter0.toElbonian(), "NNDDCYXXJ");
        assertEquals(converter1.toElbonian(), "NNNDDDYYYJJJ");
        assertEquals(converter2.toElbonian(), "I");
        assertEquals(converter3.toElbonian(), "NNMX");
        assertEquals(converter4.toElbonian(), "Y");
        assertEquals(converter5.toElbonian(), "M");
        assertEquals(converter6.toElbonian(), "NNMDYXXJJI");
    }


    /**
     * Test cases for toArabic() method
     */

    @Test
    public void toArabicTests() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter ND = new ElbonianArabicConverter("ND");
        ElbonianArabicConverter N = new ElbonianArabicConverter("N");
        ElbonianArabicConverter I = new ElbonianArabicConverter("I");
        ElbonianArabicConverter NNNDDD = new ElbonianArabicConverter("NNNDDD");
        ElbonianArabicConverter JII = new ElbonianArabicConverter("JII");
        ElbonianArabicConverter NDCY = new ElbonianArabicConverter("NDCY");
        ElbonianArabicConverter converter = new ElbonianArabicConverter("9834");
        ElbonianArabicConverter converter0 = new ElbonianArabicConverter("1");
        assertEquals(ND.toArabic(), 3300);
        assertEquals(N.toArabic(), 3000);
        assertEquals(I.toArabic(), 1);
        assertEquals(NNNDDD.toArabic(), 9900 );
        assertEquals(JII.toArabic(), 5);
        assertEquals(NDCY.toArabic(), 3430);
        assertEquals(converter.toArabic(), 9834);
        assertEquals(converter0.toArabic(), 1);
    }


    /**
     * Test cases for ValueOutOfBoundsException
     */

    @Test(expected = ValueOutOfBoundsException.class)
    public void zero() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter zero = new ElbonianArabicConverter("0");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void decimal() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter decimal = new ElbonianArabicConverter("63.4");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void negativeDecimal() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter decimal = new ElbonianArabicConverter("-2.0");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void biggerThanMax() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter biggerThanMax = new ElbonianArabicConverter("10010");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void negative() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter negative = new ElbonianArabicConverter("-9");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void moreNegative() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter moreNegative = new ElbonianArabicConverter("-1");
    }


    /**
     * Test cases for MalformedNumberException
     */

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test (expected = MalformedNumberException.class)
    public void caseDetect() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter caseDetect = new ElbonianArabicConverter("n");
    }

    @Test (expected = MalformedNumberException.class)
    public void randomLetters() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter randomLetters = new ElbonianArabicConverter("MLX");
    }

    @Test (expected = MalformedNumberException.class)
    public void mixedDigitLetter() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter mixedDigitLetter = new ElbonianArabicConverter("1M");
    }

    @Test (expected = MalformedNumberException.class)
    public void yOverload() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter yOverload = new ElbonianArabicConverter("NDYYYYJ");
    }

    @Test (expected = MalformedNumberException.class)
    public void xOverload() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter xOverload = new ElbonianArabicConverter("MCXXXI");
    }

    @Test (expected = MalformedNumberException.class)
    public void nOverload() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter nOverload = new ElbonianArabicConverter("NNNNDYJ");
    }

    @Test (expected = MalformedNumberException.class)
    public void mOverload() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter mOverload = new ElbonianArabicConverter("MMMCXI");
    }

    @Test (expected = MalformedNumberException.class)
    public void jOverload() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter jOverload = new ElbonianArabicConverter("NDYJJJJ");
    }

    @Test (expected = MalformedNumberException.class)
    public void iOverload() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter iOverload = new ElbonianArabicConverter("MCXIII");
    }

    @Test (expected = MalformedNumberException.class)
    public void dOverload() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter dOverload = new ElbonianArabicConverter("NDDDDYJ");
    }

    @Test (expected = MalformedNumberException.class)
    public void cOverload() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter cOverload = new ElbonianArabicConverter("MCCCXI");
    }

    @Test (expected = MalformedNumberException.class)
    public void threeDsButC() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter threeDsButC = new ElbonianArabicConverter("NMDDDCYXJI");
    }

    @Test (expected = MalformedNumberException.class)
    public void threeYsButX() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter threeYsButX = new ElbonianArabicConverter("NMDCYYYXJI");
    }

    @Test (expected = MalformedNumberException.class)
    public void threeNsButM() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter threeNsButM = new ElbonianArabicConverter("NNNMDCYXJI");
    }

    @Test (expected = MalformedNumberException.class)
    public void threeJsButI() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter threeJsButI = new ElbonianArabicConverter("NMDCYXJJJI");
    }

    @Test (expected = MalformedNumberException.class)
    public void lostOrder() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter lostOrder = new ElbonianArabicConverter("DYN");
    }

    @Test (expected = MalformedNumberException.class)
    public void incorrectOrder() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter incorrectOrder = new ElbonianArabicConverter("IXJ");
    }

    @Test (expected = MalformedNumberException.class)
    public void anotherWrongOrder() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter anotherWrongOrder = new ElbonianArabicConverter("NMDYCXJI");
    }

    @Test (expected = MalformedNumberException.class)
    public void really() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter really = new ElbonianArabicConverter("NMDCXYJI");
    }

    @Test (expected = MalformedNumberException.class)
    public void cantgetItRight() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter cantGetItRight = new ElbonianArabicConverter("MDCYXJIN");
    }

    @Test (expected = MalformedNumberException.class)
    public void stillWrongOrder() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter stillWrongOrder = new ElbonianArabicConverter("MNDCYXJI");
    }

    @Test (expected = MalformedNumberException.class)
    public void didItAgain() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter didItAgain = new ElbonianArabicConverter("NMDCYJXI");
    }

    @Test (expected = MalformedNumberException.class)
    public void andAgain() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter andAgain = new ElbonianArabicConverter("INMDCYXJ");
    }

    @Test (expected = MalformedNumberException.class)
    public void seriously() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter seriously = new ElbonianArabicConverter("NDMCYXJI");
    }

    @Test (expected = MalformedNumberException.class)
    public void oneMoreTime() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter oneMoreTime = new ElbonianArabicConverter("NMCDYXJI");
    }
}