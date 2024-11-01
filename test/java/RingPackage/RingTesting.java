package RingPackage;

import org.junit.*;
import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vidyut Veedgav
 * a tester class for the Ring classes
 */
public class RingTesting {

    //lists that store each of the number types
    List<Integer> intList; 
    List<BigInteger> bigIntList;
    List<Double> doubleList = new ArrayList<>(Arrays.asList());

    /**
     * testing the sum method
     */
    @Test
    public void testSum() {

        //testing for the Polynomial<Integer> type
        Ring<Integer> ring = new IntegerRing();

        //test 0
        WorkingPolynomial<Integer> a = WorkingPolynomial.from(List.of());
        WorkingPolynomial<Integer> b = WorkingPolynomial.from(List.of());
        WorkingPolynomial<Integer> result = WorkingPolynomial.from(a.plus(b, ring).getCoefficients());
        assertEquals(true, result.getCoefficients().isEmpty());

        //test 1
        a = WorkingPolynomial.from(List.of(1));
        b = WorkingPolynomial.from(List.of(1));
        result = WorkingPolynomial.from(a.plus(b, ring).getCoefficients());
        assertEquals(true, result.getCoefficients().get(0).equals(2));

        //test many
        a = WorkingPolynomial.from(List.of(1, 2, 3));
        b = WorkingPolynomial.from(List.of(4, 5, 6));
        result = WorkingPolynomial.from(a.plus(b, ring).getCoefficients());
        assertEquals(List.of(5, 7, 9), result.getCoefficients());

        //test polynomials of different lengths
        a = WorkingPolynomial.from(List.of(1, 2, 3, 4, 5));
        b = WorkingPolynomial.from(List.of(4, 5, 6));
        result = WorkingPolynomial.from(a.plus(b, ring).getCoefficients());
        assertEquals(List.of(5, 7, 9, 4, 5), result.getCoefficients());
        result = WorkingPolynomial.from(b.plus(a, ring).getCoefficients());
        assertEquals(List.of(5, 7, 9, 4, 5), result.getCoefficients());

        // Negative coefficients
        a = WorkingPolynomial.from(List.of(1, -2, 3));
        b = WorkingPolynomial.from(List.of(-4, 5, -6));
        result = a.plus(b, ring);
        assertEquals(List.of(-3, 3, -3), result.getCoefficients());
    }

    /**
     * testing the product method
     */
    @Test
    public void testProduct() {
    

        //testing the Polynomial<Integer> type
        Ring<Integer> ring = new IntegerRing();

        //test 0
        WorkingPolynomial<Integer> a = WorkingPolynomial.from(List.of());
        WorkingPolynomial<Integer> b = WorkingPolynomial.from(List.of());
        WorkingPolynomial<Integer> result = WorkingPolynomial.from(a.times(b, ring).getCoefficients());
        assertEquals(true, result.getCoefficients().isEmpty());

        //test 1
        a = WorkingPolynomial.from(List.of(1));
        b = WorkingPolynomial.from(List.of(1));
        result = WorkingPolynomial.from(a.times(b, ring).getCoefficients());
        assertEquals(List.of(1), result.getCoefficients());

        //test many
        a = WorkingPolynomial.from(List.of(1, 2, 3));
        b = WorkingPolynomial.from(List.of(4, 5, 6));
        result = WorkingPolynomial.from(a.times(b, ring).getCoefficients());
        assertEquals(List.of(4, 13, 28, 27, 18), result.getCoefficients());

        //test polynomials of different lengths
        a = WorkingPolynomial.from(List.of(1, 2, 3, 4, 5));
        b = WorkingPolynomial.from(List.of(4, 5, 6));
        result = WorkingPolynomial.from(a.times(b, ring).getCoefficients());
        assertEquals(List.of(4, 13, 28, 43, 58, 49, 30), result.getCoefficients());
        result = WorkingPolynomial.from(b.times(a, ring).getCoefficients());
        assertEquals(List.of(4, 13, 28, 43, 58, 49, 30), result.getCoefficients());

        //test with zero in coefficient
        a = WorkingPolynomial.from(List.of(1, 0, 3));
        b = WorkingPolynomial.from(List.of(4, 0, 6));
        result = a.times(b, ring);
        assertEquals(List.of(4, 0, 18, 0, 18), result.getCoefficients());

        // Identity element in multiplication
        a = WorkingPolynomial.from(List.of(1, 2, 3));
        b = WorkingPolynomial.from(List.of(1));
        result = a.times(b, ring);
        assertEquals(List.of(1, 2, 3), result.getCoefficients());

        // Negative coefficients
        a = WorkingPolynomial.from(List.of(1, -2, 3));
        b = WorkingPolynomial.from(List.of(-4, 5, -6));
        result = a.times(b, ring);
        assertEquals(List.of(-4, 13, -28, 27, -18), result.getCoefficients());
    }        
}

