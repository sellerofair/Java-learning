package GenericsCollectionsStreams.PairOptional;

public class Pair <T, U> {

    private final T first;
    private final U second;

    private Pair(T a, U b) {
        first = a;
        second = b;
    }

    public T getFirst() { return first; }

    public U getSecond() { return second; }

    public static <T, U> Pair<T, U> of(T a, U b) {
        return new Pair<T, U>(a, b);
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Pair) || obj == null) { return false; }

        Pair that = (Pair) obj;

        return 
            (first == null && that.getFirst() == null ||
                first != null && that.getFirst() != null && first.equals(that.getFirst())) && 
            (second == null && that.getSecond() == null ||
                second != null && that.getSecond() != null && second.equals(that.getSecond()));

    }

    @Override
    public int hashCode() {

        int hash1;
        int hash2;

        if (first == null) { hash1 = 0; }
        else { hash1 = first.hashCode(); }

        if (second == null) { hash2 = 0; }
        else { hash2 = second.hashCode(); }

        return hash1 ^ hash2;

    }
    
}
