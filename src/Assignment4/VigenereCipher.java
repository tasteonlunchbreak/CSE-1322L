package Assignment4;
public class VigenereCipher extends Mendec {
    //fields 
    private String key;


    public VigenereCipher(String name, String key) {
        super(name, "A Vigenere Cipher with key '" + key + "'.");
        this.key = key.toUpperCase();
    } 

    @Override
    public String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int shift = key.charAt(keyIndex % key.length()) - 'A';
                if (Character.isUpperCase(c)) {
                    char newChar = (char) ((c - 'A' + shift) % 26 + 'A');
                    result.append(newChar);
                } else {
                    char newChar = (char) ((c - 'a' + shift) % 26 + 'a');
                    result.append(newChar);
                }
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    @Override
    public String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        int keyIndex = 0;
        
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int shift = key.charAt(keyIndex % key.length()) - 'A';
                if (Character.isUpperCase(c)) {
                    char newChar = (char) ((c - 'A' - shift + 26) % 26 + 'A');
                    result.append(newChar);
                } else {
                    char newChar = (char) ((c - 'a' - shift + 26) % 26 + 'a');
                    result.append(newChar);
                }
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    @Override
    public String toString() {
        return "#" + getId() + ": '" + getName() + "' - Vigenere Cipher";
    }
}