package be.lars.projectje22;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by brandonstark on 23/06/16.
 */
public class CalculatorTestCase {
    @Test
    public void productOfTwoFactors(){
        assertEquals(40, new Calculator().multiply(5,8));

    }
    @Test
    public void productOfNegativeFactors(){
        assertEquals(40, new Calculator().multiply(-5,-8));

    }

}
