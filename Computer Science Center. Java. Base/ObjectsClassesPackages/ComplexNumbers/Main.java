package ObjectsClassesPackages.ComplexNumbers;

public class Main {
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
}