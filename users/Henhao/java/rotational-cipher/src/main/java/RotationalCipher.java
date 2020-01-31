import java.util.stream.Collectors;

class RotationalCipher {

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        return data.chars().map(this::rotation).mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
    }

    private int rotation(int c) {
        if (!Character.isLetter(c))
            return c;

        int cipher = c + shiftKey;

        if ((Character.isLowerCase(c) != Character.isLowerCase(cipher))
                || (Character.isUpperCase(c) != Character.isUpperCase(cipher)))
            return cipher - 26;
        else
            return cipher;
    }

    public static void main(String[] args) {
        System.out.println(new RotationalCipher(25).rotate("This is a test."));
    }
}
