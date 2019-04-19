package converter.tests;

import converter.ElbonianArabicConverter;
import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for the ElbonianArabicConverter class.
 */
public class ConverterTests {

    @Test
    public void ElbonianToArabicSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("1");
        assertEquals(converter.toElbonian(), "I");
    }

    @Test
    public void ArabicToElbonianSampleTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter = new ElbonianArabicConverter("I");
        assertEquals(converter.toArabic(), 1);
    }

    @Test(expected = MalformedNumberException.class)
    public void malformedNumberTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new MalformedNumberException("TEST");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutOfBoundsTest() throws MalformedNumberException, ValueOutOfBoundsException {
        throw new ValueOutOfBoundsException("0");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void Test1() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter1 = new ElbonianArabicConverter("10010");
        throw new ValueOutOfBoundsException("Large Value");
    }

    @Test
    public void Test2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("9999");
        assertEquals(converter2.toElbonian(), "NNNDDDYYYJJJ");
    }

    @Test
    public void toElbonainTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("3660");
        assertEquals(converter2.toElbonian(), "NDDYY");
    }

    @Test(expected = MalformedNumberException.class)
    public void Test3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter3 = new ElbonianArabicConverter("99 9");
        throw new MalformedNumberException("Spaces");
    }

    @Test
    public void ElbonianToArabicTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter4 = new ElbonianArabicConverter("N");
        assertEquals(converter4.toArabic(), 3000);
    }

    @Test (expected = MalformedNumberException.class)
    public void toArabicTest2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("DYN");
        throw new MalformedNumberException("Incorrect Order");
    }

    @Test (expected = MalformedNumberException.class)
    public void toArabicTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter2 = new ElbonianArabicConverter("IXJ");
        throw new MalformedNumberException("Incorrect Order");
    }

    @Test
    public void toArabicTest4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter7 = new ElbonianArabicConverter("ND");
        assertEquals(converter7.toArabic(), 3300);
    }

    @Test
    public void toArabicTest5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter8 = new ElbonianArabicConverter("NNNDDD");
        assertEquals(converter8.toArabic(), 9900 );
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void valueOutTest() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter1 = new ElbonianArabicConverter("-9");
        throw new ValueOutOfBoundsException("Negative Number");
    }

    @Test
    public void toArabicTest6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter4 = new ElbonianArabicConverter("JII");
        assertEquals(converter4.toArabic(), 5);
    }

    @Test
    public void toArabicTest7() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter4 = new ElbonianArabicConverter("NDCY");
        assertEquals(converter4.toArabic(), 3430);
    }

    @Test
    public void toElbonainTest3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter9 = new ElbonianArabicConverter("6753");
        assertEquals(converter9.toElbonian(), "NNDDCYXXJ");
    }

    // Here are the tests we failed last time
    @Test (expected = MalformedNumberException.class)
    public void Malformed() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given1 = new ElbonianArabicConverter("1M");
        throw new MalformedNumberException("Number and Letter");
    }


    @Test (expected = MalformedNumberException.class)
    public void invalidCombo() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given2 = new ElbonianArabicConverter("NMDDDCYXJI");
        throw new MalformedNumberException("Invalid Combo");
    }

    @Test (expected = MalformedNumberException.class)
    public void invalidOrder() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given3 = new ElbonianArabicConverter("NMCDYXJI");
        throw new MalformedNumberException("Invalid Order");
    }

    @Test (expected = MalformedNumberException.class)
    public void invalidOrder2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given4 = new ElbonianArabicConverter("INMDCYXJ");
        throw new MalformedNumberException("Invalid Order");
    }

    @Test (expected = MalformedNumberException.class)
    public void invalidOrder3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given5 = new ElbonianArabicConverter("NMDCYJXI");
        throw new MalformedNumberException("Invalid Order");
    }

    @Test (expected = MalformedNumberException.class)
    public void invalidOrder4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given6 = new ElbonianArabicConverter("MNDCYXJI");
        throw new MalformedNumberException("Invalid Order");
    }

    @Test (expected = MalformedNumberException.class)
    public void invalidOrder5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given7 = new ElbonianArabicConverter("MDCYXJIN");
        throw new MalformedNumberException("Invalid Order");
    }

    @Test (expected = MalformedNumberException.class)
    public void invalidOrder6() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given8 = new ElbonianArabicConverter("NMDCXYJI");
        throw new MalformedNumberException("Invalid Order");
    }

    @Test (expected = MalformedNumberException.class)
    public void invalidOrder7() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given9 = new ElbonianArabicConverter("NMDYCXJI");
        throw new MalformedNumberException("Invalid Order");
    }

    @Test (expected = MalformedNumberException.class)
    public void invalidCombo2() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given10 = new ElbonianArabicConverter("NMDCYXJJJI");
        throw new MalformedNumberException("Invalid Combo");
    }


    @Test (expected = MalformedNumberException.class)
    public void invalidCombo3() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given11 = new ElbonianArabicConverter("NNNMDCYXJI");
        throw new MalformedNumberException("Invalid Combo");
    }

    @Test (expected = MalformedNumberException.class)
    public void invalidCombo4() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given12 = new ElbonianArabicConverter("NNNMDCYXJI");
        throw new MalformedNumberException("Invalid Combo");
    }

    @Test (expected = MalformedNumberException.class)
    public void invalidCombo5() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given12 = new ElbonianArabicConverter("NMDCYYYXJI");
        throw new MalformedNumberException("Invalid Combo");
    }


    @Test (expected = MalformedNumberException.class)
    public void invalidOrder8() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given13 = new ElbonianArabicConverter("NDMCYXJI");
        throw new MalformedNumberException("Invalid Order");
    }

    @Test (expected = MalformedNumberException.class)
    public void toManyC() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given13 = new ElbonianArabicConverter("MCCCXI");
        throw new MalformedNumberException("Too many C's");
    }

    @Test (expected = MalformedNumberException.class)
    public void toManyD() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given13 = new ElbonianArabicConverter("NDDDDYJ");
        throw new MalformedNumberException("Too many D's");
    }

    @Test (expected = MalformedNumberException.class)
    public void toManyI() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given13 = new ElbonianArabicConverter("MCXIII");
        throw new MalformedNumberException("Too many I's");
    }

    @Test (expected = MalformedNumberException.class)
    public void toManyJ() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given13 = new ElbonianArabicConverter("NDYJJJJ");
        throw new MalformedNumberException("Too many J's");
    }

    @Test (expected = MalformedNumberException.class)
    public void toManyM() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given13 = new ElbonianArabicConverter("MMMCXI");
        throw new MalformedNumberException("Too many M's");
    }

    @Test (expected = MalformedNumberException.class)
    public void toManyN() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given13 = new ElbonianArabicConverter("NNNNDYJ");
        throw new MalformedNumberException("Too many N's");
    }

    @Test (expected = MalformedNumberException.class)
    public void toManyX() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given13 = new ElbonianArabicConverter("MCXXXI");
        throw new MalformedNumberException("Too many X's");
    }

    @Test (expected = MalformedNumberException.class)
    public void toManyY() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given13 = new ElbonianArabicConverter("NDYYYYJ");
        throw new MalformedNumberException("Too many Y's");
    }

    //Out of bounds
    @Test(expected = ValueOutOfBoundsException.class)
    public void negative() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter1 = new ElbonianArabicConverter("-1");
        throw new ValueOutOfBoundsException("Negative Number");
    }

    @Test(expected = ValueOutOfBoundsException.class)
    public void zero() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter converter1 = new ElbonianArabicConverter("0");
        throw new ValueOutOfBoundsException("Zero Value");
    }

    @Test (expected = MalformedNumberException.class)
    public void caseDetection() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given13 = new ElbonianArabicConverter("k");
        throw new MalformedNumberException("Lower Case");
    }

    @Test (expected = MalformedNumberException.class)
    public void nonElbonianCharacter() throws MalformedNumberException, ValueOutOfBoundsException {
        ElbonianArabicConverter given13 = new ElbonianArabicConverter("MLX");
        throw new MalformedNumberException("Non Elbonian Character Given");
    }
}