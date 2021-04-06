package ObjectsClassesPackages;

public class ComplexNumbers {
    public static void main(String[] args) {
        ComplexNumber cn1 = new ComplexNumber(2.12, -3.25);
        ComplexNumber cn2 = new ComplexNumber(-2.12, 3.25);
        ComplexNumber cn3 = new ComplexNumber(2.12, 3.25);
        ComplexNumber cn4 = new ComplexNumber(2.12, 3.25);
        System.out.println(cn1);
        System.out.println(cn2);
        System.out.println(cn3);
        System.out.println(cn3.equals(cn4));
        System.out.println(cn3.hashCode());
        System.out.println(cn4.hashCode());
    }

    // 3.4 Inheritance. Class Object
  // Step 9
    /**
     * Class of complex numbers.
     */
    public static class ComplexNumber {
        private final double re;
        private final double im;
    
        public ComplexNumber(double re, double im) {
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
}
