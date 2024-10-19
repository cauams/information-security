package algorithms.list04.columnartransposition;

public class ColumnarTransposition {

    public String encrypt(String text, int columns) {
        text = text.replaceAll("\\s+", "");

        int rows = text.length() / columns;
        char[][] matrix = new char[rows][columns];
        int textIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < columns; j++) {
                if (textIndex < text.length()) {
                    matrix[i][j] = text.charAt(textIndex);
                } else {
                    matrix[i][j] = 'X';
                }
                textIndex++;
            }
        }

        StringBuilder encryptedText = new StringBuilder();
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                encryptedText.append(matrix[i][j]);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String ciphertext, int columns) {
        int rows = (int) Math.ceil((double) ciphertext.length() / columns);
        char[][] matrix = new char[rows][columns];
        int textIndex = 0;

        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                if (textIndex < ciphertext.length()) {
                    matrix[i][j] = ciphertext.charAt(textIndex);
                    textIndex++;
                } else {
                    matrix[i][j] = 'X';
                }
            }
        }

        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                decryptedText.append(matrix[i][j]);
            }
        }

        return decryptedText.toString().replaceAll("X+$", "");
    }}
