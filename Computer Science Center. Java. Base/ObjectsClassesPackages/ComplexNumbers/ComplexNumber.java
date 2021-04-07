package ObjectsClassesPackages.ComplexNumbers;

/**
 * Class of complex numbers.
 */
class ComplexNumber {

    private final double re;
    private final double im;

    ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (!(obj instanceof ComplexNumber)) { return false; }
        ComplexNumber number = (ComplexNumber) obj;
        return number.im == this.im && number.re == this.re;
    }

    @Override
    public int hashCode() {
        long h = (
            Double.doubleToLongBits(re) +
            Double.doubleToLongBits(im)
        );
        return (int)h ^ (int)(h >>> 32);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(re);
        result.append(im > 0 ? " + " : " - ");
        result.append(Math.abs(im));
        result.append('i');
        return result.toString();
    }
    
}