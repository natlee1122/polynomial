package RingPackage;

import java.util.List;
import java.util.Objects;

/**
 * @author Vidyut Veedgav
 * a class to demonstrate the concept of Rings on Polynomials
 */
public final class PolynomialRing<T> implements Ring<BuggyPolynomial<T>> {

    private Ring<T> baseRing; //a private field storing a ring 

    /**
     * a constructor for the PolynomialRing class
     * @param ring
     */
    private PolynomialRing(Ring<T> ring) {
        //null check
        assert ring != null : "ring cannot be null";

        this.baseRing = ring;
    }

    /**
     * a static method to return a new polynomial
     * @param <T> a ring
     * @return a new polynomial
     */
    public static <T> PolynomialRing<T> instance(Ring<T> ring) {
        //null check
        Objects.requireNonNull(ring, "ring cannot be null");

        return new PolynomialRing<>(ring);
    }

    /**
     * overriding the zero method
     */
    @Override
    public BuggyPolynomial<T> zero() {
        return BuggyPolynomial.from(List.of());
    }

    /**
     * overriding the identity method
     */
    @Override
    public BuggyPolynomial<T> identity() {
        return BuggyPolynomial.from(List.of(baseRing.identity()));
    }

    /**
     * overriding the sum method
     */
    @Override
    public BuggyPolynomial<T> sum(BuggyPolynomial<T> x, BuggyPolynomial<T> y) {
        //null checks
        Objects.requireNonNull(x, "x cannot be null");
        Objects.requireNonNull(y, "y cannot be null");

        return x.plus(y, baseRing);
    }

    /**
     * overriding the product method
     */
    @Override
    public BuggyPolynomial<T> product(BuggyPolynomial<T> x, BuggyPolynomial<T> y) {
        //null checks
        Objects.requireNonNull(x, "x cannot be null");
        Objects.requireNonNull(y, "y cannot be null");

        return x.times(y, baseRing);
    }

    public static void main(String[] args) {

        PolynomialRing<Integer> ring = PolynomialRing.instance(new IntegerRing());
        BuggyPolynomial<Integer> p1 = BuggyPolynomial.from(List.of(1,2, 3));
        BuggyPolynomial<Integer> p2 = BuggyPolynomial.from(List.of(4,5, 6));
        System.out.println(ring.product(p1, p2));
    }

    
}
