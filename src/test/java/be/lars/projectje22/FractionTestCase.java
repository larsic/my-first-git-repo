package be.lars.projectje22;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.realdolmen.Utilities.greatestCommonFactor;
import static org.junit.Assert.assertEquals;

/**
 * Created by brandonstark on 23/06/16.
 */
public class FractionTestCase {
    @Test
    public void fractionIsSimplifiedInConstructor(){
        Fraction f = new Fraction(1, 3);
        assertEquals(1, f.getNumerator());
        assertEquals(3, f.getDenominator());
    }
    @Test
    public void simplifyTest(){
        Fraction g = new Fraction(3, 9);
        assertEquals(1, g.getNumerator());
        assertEquals(3, g.getDenominator());

    }

    @Test
    public void stringTest(){

        Assert.assertEquals("1/2", new Fraction(1,2).toString());
    }
    @BeforeClass
    public static void firstTest(){
        System.out.println("First");
    }

    @Before
    public void newTest(){
        System.out.println("Start");
    }
    @Test
    public void addTest(){
        Fraction a = new Fraction(1,2);
        Fraction b = new Fraction(2,3);
        Fraction c = a.add(b);
        Assert.assertEquals(7, c.getNumerator());
        Assert.assertEquals(6, c.getDenominator());
    }
}
