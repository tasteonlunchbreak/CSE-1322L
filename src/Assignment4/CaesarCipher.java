package Assignment4;
public class CaesarCipher extends Mendec {
    private int offset;

    private static final String[] GROUPS = {
            "!\"#$%&\'()*+,-./",
            "0123456789",
            ":;<=>?@",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "[\\]^_`",
            "abcdefghijklmnopqrstuvwxyz",
            "{|}~"
    };
    public CaesarCipher(String name, int offset) {
        super(name, "A Caesar Cypher with an offset of " + offset + ".");
        this.offset = offset;
    }
    private char shiftChar(char c, int shift) {
        for (String group : GROUPS) {
            int index = group.indexOf(c);
            if (index != -1) {
                int len = group.length();
                int newIndex = (index + shift) % len;
                if (newIndex < 0) newIndex += len;
                return group.charAt(newIndex);
            }
        }
        return c;
    }
    @Override
    public String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(shiftChar(c, offset));
        }
        return result.toString();
    }
    @Override
    public String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(shiftChar(c, -offset));
        }
        return result.toString();
    }
    @Override
    public String toString() {
        return "#" +getId() + ": '" + getName() + "' - Caesar Cipher";
    }
}