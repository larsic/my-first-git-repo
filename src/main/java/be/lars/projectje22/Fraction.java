package be.lars.projectje22;

import static com.realdolmen.Utilities.greatestCommonFactor;

/**
 * Created by brandonstark on 23/06/16.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    @Override
    public String toString() {
        return  numerator + "/" + denominator;

    }

    private void simplify(){
        int deler = greatestCommonFactor(numerator,denominator);
        this.numerator = numerator/deler;
        this.denominator = denominator/deler;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }


    public Fraction add(Fraction f){

        return new Fraction(((this.numerator*f.getDenominator())+(this.denominator*f.getNumerator())),(this.denominator*f.getDenominator()));

    }



}
