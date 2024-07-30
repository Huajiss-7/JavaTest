package CSC3101.lab8;

public class Q2 {
    public static void main(String[] args) {
        try {
            Fraction fraction1 = new Fraction(1, 2);
            System.out.println("Fraction 1: " + fraction1);

            Fraction fraction2 = new Fraction(3, 0);
            System.out.println("Fraction 2: " + fraction2);
        } catch (NullDenominatorException e) {
            System.out.println(e.getMessage());
        }
    }
}

class NullDenominatorException extends Exception {
    public NullDenominatorException(String input) {
        super(input);
    }
}

class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) throws NullDenominatorException {
        if (denominator == 0) {
            throw new NullDenominatorException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

}