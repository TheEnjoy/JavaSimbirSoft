import java.util.HashMap;
import java.util.Locale;

public class CounterWords {
    public static HashMap<String, Integer> countWords(String inputPhrase) {
        HashMap<String, Integer> words = new HashMap<>();
        boolean increment = false;
        int wordStart = -1;
        int phraseWordCount = 0;
        int uniqueWordCount = 0;
        inputPhrase = inputPhrase.toLowerCase(Locale.ROOT);
        for (int i = 0; i < inputPhrase.length(); i++) {
            if (StringUtils.validChar(inputPhrase.charAt(i))) { //validChar(char c) is a simple method that returns a valid character{
                increment = true;
                if (wordStart == -1) {
                    wordStart = i;
                }
            } else if (increment) {
                phraseWordCount++;
                final String lastWord = inputPhrase.substring(wordStart, i).toLowerCase(Locale.ROOT);
                boolean unique = findUpTo(lastWord, inputPhrase.toLowerCase(Locale.ROOT), wordStart);
                if (unique) {
                    uniqueWordCount++;
                    if (words.get(lastWord) != null || (words.get(lastWord) == null && words.containsKey(lastWord)))
                        words.put(lastWord, words.get(lastWord) + 1);
                    else {
                        words.put(lastWord, 1);
                    }
                } else {
                    words.put(lastWord, words.get(lastWord) + 1);
                }
                increment = false;
                wordStart = -1;
            }
        }
        if (increment) {
            phraseWordCount++; //in the case the last word is a valid character
            final String lastWord = inputPhrase.substring(wordStart, inputPhrase.length());
            boolean unique = findUpTo(lastWord, inputPhrase, wordStart);
            if (unique) {
                uniqueWordCount++;
            }
        }
        System.out.println("Words: " + phraseWordCount);
        System.out.println("Unique: " + uniqueWordCount);
        return words;
    }

    private static boolean findUpTo(String wordSearch, String lineInSearch, int lastPos) {
        boolean previousValid = false;
        boolean unique = true;
        wordSearch = (wordSearch.toLowerCase(Locale.ROOT));
        lineInSearch = (lineInSearch.toLowerCase(Locale.ROOT));
        for (int j = 0; unique && j < lastPos - wordSearch.length(); j++) {
            final boolean nextValid = StringUtils.validChar(lineInSearch.charAt(j));
            if (!previousValid && nextValid) {
                previousValid = true;
                for (int k = 0; k < lastPos - j; k++) {
                    if (k == wordSearch.length()) {
                        if (StringUtils.isWhiteSpace(lineInSearch.charAt(j + k))) {
                            break;
                        }
                        unique = StringUtils.validChar(lineInSearch.charAt(j + k));
                        break;
                    }
                    if (wordSearch.charAt(k) != lineInSearch.charAt(j + k)) {
                        break;
                    }
                }
            } else {
                previousValid = nextValid;
            }
        }
        return unique;
    }

}
