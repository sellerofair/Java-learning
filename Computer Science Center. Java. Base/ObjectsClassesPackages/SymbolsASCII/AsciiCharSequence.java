package ObjectsClassesPackages.SymbolsASCII;

/**
 * Sequence of ASCII symbols.
 */
class AsciiCharSequence implements CharSequence {
    
    byte[] sequence;

    public AsciiCharSequence(byte[] seq) {
        sequence = new byte[seq.length];
        for (int i = 0; i < seq.length; i++) {
            sequence[i] = seq[i];
        }
    }

    @Override
    public CharSequence subSequence(int arg0, int arg1) {
        byte[] subSeq = new byte[arg1 - arg0];
        for (int i = 0; i < subSeq.length; i++) {
            subSeq[i] = sequence[i + arg0];
        }

        return new AsciiCharSequence(subSeq);
    }

    @Override
    public char charAt(int arg0) {
        return (char) sequence[arg0];
    }

    @Override
    public int length() {
        return sequence.length;
    }

    @Override
    public String toString() {
        if (sequence.length == 0) { return ""; }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sequence.length; i++) {
            result.append((char) sequence[i]);
        }
        return result.toString();
    }
}