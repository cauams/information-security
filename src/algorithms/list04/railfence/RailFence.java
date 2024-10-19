package algorithms.list04.railfence;

public class RailFence {

    public static String encrypt(String text, int rails) {
        StringBuilder[] rail = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) {
            rail[i] = new StringBuilder();
        }

        boolean goingDown = false;
        int currentRail = 0;

        for (char c : text.toCharArray()) {
            rail[currentRail].append(c);
            if (currentRail == 0 || currentRail == rails - 1) {
                goingDown = !goingDown;
            }
            currentRail += goingDown ? 1 : -1;
        }

        StringBuilder encryptedText = new StringBuilder();
        for (StringBuilder r : rail) {
            encryptedText.append(r);
        }

        return encryptedText.toString();
    }

    public static String decrypt(String cipherText, int rails) {
        StringBuilder[] rail = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) {
            rail[i] = new StringBuilder();
        }

        boolean[] railPattern = new boolean[cipherText.length()];
        boolean goingDown = false;
        int currentRail = 0;

        for (int i = 0; i < cipherText.length(); i++) {
            rail[currentRail].append('*');
            if (currentRail == 0 || currentRail == rails - 1) {
                goingDown = !goingDown;
            }
            currentRail += goingDown ? 1 : -1;
        }

        int textIndex = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < rail[i].length(); j++) {
                if (rail[i].charAt(j) == '*') {
                    rail[i].setCharAt(j, cipherText.charAt(textIndex++));
                }
            }
        }

        StringBuilder decryptedText = new StringBuilder();
        currentRail = 0;
        goingDown = false;

        for (int i = 0; i < cipherText.length(); i++) {
            decryptedText.append(rail[currentRail].charAt(0));
            rail[currentRail].deleteCharAt(0);
            if (currentRail == 0 || currentRail == rails - 1) {
                goingDown = !goingDown;
            }
            currentRail += goingDown ? 1 : -1;
        }

        return decryptedText.toString();
    }
}
