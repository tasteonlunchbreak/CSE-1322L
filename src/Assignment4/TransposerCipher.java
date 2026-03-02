package Assignment4;
public class TransposerCipher extends Mendec {
    private int width;

    public TransposerCipher(String name, int width) {
        super(name, "A Transposer Cipher with width " + width + ".");
        this.width = width;
    }
    @Override
    public String encrypt(String text) {
        int rows = (int) Math.ceil((double) text.length() / width);
        char[][] grid = new char[rows][width];
        int index = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < width; c++) {
                if (index < text.length()) {
                    grid[r][c] = text.charAt(index++);
                } else {
                    grid[r][c]  = '.';
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int c = 0; c < width; c++) {
            for (int r = 0; r < rows; r++) {
                result.append(grid[r][c]);
            }
        }
        return result.toString();
    }
    @Override
    public String decrypt(String text) {
        int rows = (int) text.length() / width;
        char[][] grid = new char[rows][width];
        int index = 0;

        for (int c = 0; c < width; c++) {
            for (int r = 0; r < rows; r++) {
                if (index < text.length()) {
                    grid[r][c] = text.charAt(index++);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < width; c++) {
                result.append(grid[r][c]);
            }
        }
        return result.toString();
    }
    @Override
    public String toString() {
        return "#" + getId() + ": '" + getName() + "' - Transposer Cipher";
    }
}
