import java.util.ArrayList;
import java.util.Arrays;

public class WordTask {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(wordReversal(splitIntoWords(args[0]))));

        //System.out.println(findTheWord(splitIntoWords(args[0]), Integer.parseInt(args[1])));

        //System.out.println(wordSearch(splitIntoWords(args[0]), args[1]));

        //System.out.println(wordSearchAdvanced(splitIntoWords(args[0]), args[1]));

        anagrams(args[0], args[1]);
    }

    static boolean isSpace(char inputChar) {
        if (inputChar == ' ') {
            return true;
        } else {
            return false;
        }
    }

    static boolean isPunct(char inputChar) {
        if (inputChar == '!' || inputChar == '?' || inputChar == ',' || inputChar == ';' || inputChar == '.') {
            return true;
        } else {
            return false;
        }
    }

    static boolean isPunct(String inputStr) {
        if (inputStr.equals("!") || inputStr.equals("?") || inputStr.equals(",") || inputStr.equals(";") || inputStr.equals(".")) {
            return true;
        } else {
            return false;
        }
    }

    static String[] splitIntoWords(String input) {
        char[] inputArray = input.toCharArray();
        ArrayList<String> wordArrayList = new ArrayList<>();
        int currentWordLength = 0;

        //split the words
        for (int i = 0; i < inputArray.length; i++) {
            if (isSpace(inputArray[i])) {
                wordArrayList.add(input.substring(i - currentWordLength, i));
                currentWordLength = 0;
            } else if (isPunct(inputArray[i])) {
                wordArrayList.add(input.substring(i - currentWordLength, i));
                wordArrayList.add(String.valueOf(inputArray[i]));
                currentWordLength = 0;
            } else {
                ++currentWordLength;
            }
        }

        if (currentWordLength != 0) {
            wordArrayList.add(input.substring(inputArray.length - currentWordLength, inputArray.length));
        }

        //System.out.println(wordArrayList);
        String[] wordArray = new String[wordArrayList.size()];
        wordArray = wordArrayList.toArray(wordArray);
        return wordArray;
    }

    static String[] wordReversal(String[] input) {
        String[] inputArrayRev = new String[input.length];
        ArrayList<String> onlyWordsArrayList = new ArrayList<>();

        // reverse Array
        for (int i = 0; i < input.length; i++) {
            if (!isPunct(input[i])) {
                onlyWordsArrayList.add(input[i]);
                continue;
            } else if (isPunct(input[i])) {
                continue;
            }

            inputArrayRev[i] = input[input.length - 1 - i];
        }
        //separate words from punctuation elements to reverse
        String[] onlyWordsArrayRev = new String[onlyWordsArrayList.size()];
        for (int i = 0; i < onlyWordsArrayList.size(); i++) {
            onlyWordsArrayRev[i] = onlyWordsArrayList.get(onlyWordsArrayList.size() - 1 - i);
        }
        return onlyWordsArrayRev;
    }

    static String findTheWord(String[] wordFind, int wordFindIndex) {
        return wordFind[wordFind.length - 2] + " " + wordFind[wordFindIndex + 1];
    }

    static boolean wordSearch(String[] sentenceSearch, String wordSearch) {
        if (sentenceSearch[0].equals(wordSearch)) {
            return true;
        } else {
            return false;
        }
    }

    static int wordSearchAdvanced(String[] sentenceSearch, String wordSearch) {
        int timesWordAppears = 0;
        char[] wordSearchArray = wordSearch.toCharArray();
        int correctChar = 0;
        for (int i = 0; i < sentenceSearch.length; i++) {
            char[] wordInSentence = sentenceSearch[i].toCharArray();
            int lengthDiff = wordInSentence.length - wordSearchArray.length;
            //check if search word is longer than word in sentence word
            if (lengthDiff >= 0) {
                //loop through # of times search word fits in sentence word, starting at different indexes
                for (int j = 0; j <= lengthDiff; j++) {
                    correctChar = 0;
                    //match search word against sentence word
                    for (int k = 0; k < wordSearchArray.length; k++) {
                        if (wordSearchArray[k] == wordInSentence[k + j]) {
                            correctChar++;
                        }
                    }
                    if (correctChar == wordSearchArray.length) {
                        timesWordAppears++;
                    }
                }
            }

        }
        return timesWordAppears;
    }
    
    static boolean anagrams(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] word1Arr = new char[word1.length()];
        char[] word2Arr = new char[word2.length()];
        char[] word1ArrSorted = new char[word1Arr.length];
        char[] word2ArrSorted = new char[word2Arr.length];

        for (int i = 0; i < word1Arr.length; i++) {
            
        }

        if (word1ArrSorted == word2ArrSorted) {
            return true;
        } else {
            return false;
        }
    }
}
