package ObjectsClassesPackages.SymbolsASCII;

public class Main {
    public static void main(String[] args) {
        byte[] acs = {100, 101, 102, 103};
        AsciiCharSequence acs1 = new AsciiCharSequence(acs);
        System.out.println(acs1);
        System.out.println(acs1.length());
        System.out.println(acs1.subSequence(1, 3));        
    }
}
