package GenericsCollectionsStreams.PairOptional;

public class Main {

    public static void main(String[] args) {

        Pair<Integer, String> pair = Pair.of(null, "hello");

        Integer i = pair.getFirst(); // 1
        System.out.println(i);

        String s = pair.getSecond(); // "hello"
        System.out.println(s);

        Pair<Integer, String> pair2 = Pair.of(null, "hello");

        boolean mustBeTrue = pair.equals(pair2); // true!
        System.out.println(mustBeTrue);

        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustAlsoBeTrue);

    }

}
