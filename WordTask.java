import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class WordTask {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(wordReversal(splitIntoWords(args[0]))));

        //System.out.println(findTheWord(splitIntoWords(args[0]), Integer.parseInt(args[1])));

        //System.out.println(wordSearch(splitIntoWords(args[0]), args[1]));

        //System.out.println(wordSearchAdvanced(splitIntoWords(args[0]), args[1]));

        //System.out.println(removeElementFromArr(args[0].toCharArray(),Integer.parseInt(args[1]),Integer.parseInt(args[2])));

        //System.out.println(anagrams(args[0], args[1]));

        //System.out.print(imperfectPanagram(args[0]));

        //System.out.println(perfectPanagram(args[0]));

//        System.out.println(numberReversal(Integer.parseInt(args[0])));

        //System.out.println(isArmstrongNum(Integer.parseInt(args[0])));

        //armstrongNumCalc(Integer.parseInt(args[0]));

        /*int[] intArr = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            intArr[i] = Integer.parseInt(args[i]);
        }
        productMaximizer(intArr);
        */

        //System.out.print(primeChecker(Integer.parseInt(args[0])));

        //primeCheckerNum(Integer.parseInt(args[0]));

//        productMaximizerArr(new int[]{40, 20, 3, 6, 23}, new int[] {18, 21, 5, 7, 3});

        //System.out.println(Arrays.toString(primeFactorization(Integer.parseInt(args[0]))));

        anagramGroups(args);
    }

    static char[] extractNumReversed (int input) {
        ArrayList<Character> numCharacters = new ArrayList<>();
        int number = input;

        while (number > 0) {
            int remainder = number % 10;
            char remainderChar = (char)(remainder + '0');
            numCharacters.add(remainderChar);
            number = number / 10;
        }

        char[] numChars = new char[numCharacters.size()];

        for (int i = 0; i < numCharacters.size(); i++) {
            numChars[i] = numCharacters.get(i);
        }

        return numChars;
    }

    static boolean isSpace(char inputChar) {
        return (inputChar == ' ');
    }

    static boolean isPunct(char inputChar) {
        return (inputChar == '!' || inputChar == '?' || inputChar == ',' || inputChar == ';' || inputChar == '.' || inputChar == ':');
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

    static char[] splitIntoChars(String input) {
        char[] inputArr = input.toCharArray();
        int numOfNonChars = 0;

        for (char element: inputArr) {
            if (isPunct(element) || isSpace(element)) {
                numOfNonChars++;
            }
        }

        char[] charArr = new char[inputArr.length - numOfNonChars];

        for (int i = 0, j = 0; i < inputArr.length; i++) {
            if (!(isPunct(inputArr[i]) || isSpace(inputArr[i]))) {
                charArr[j++] = inputArr[i];
            }
        }
        return charArr;
    }

    //1
    static String[] wordReversal(String[] input) {
        String[] inputArrayRev = new String[input.length];
        ArrayList<String> onlyWordsArrayList = new ArrayList<>();
        ArrayList<String> onlyPunctArrayList = new ArrayList<>();
        ArrayList<Integer> onlyPunctIndexArrayList = new ArrayList<>();
        ArrayList<String> finalArrayList = new ArrayList<>();

        //separate words from punctuation characters and their indexes in original array
        for (int i = 0; i < input.length; i++) {
            if (!isPunct(input[i])) {
                onlyWordsArrayList.add(input[i]);
                continue;
            } else if (isPunct(input[i])) {
                onlyPunctArrayList.add(input[i]);
                onlyPunctIndexArrayList.add(i);
                continue;
            }

            inputArrayRev[i] = input[input.length - 1 - i];
        }
        //separate words from punctuation elements to reverse
        String[] onlyWordsArrayRev = new String[onlyWordsArrayList.size()];
        for (int i = 0; i < onlyWordsArrayList.size(); i++) {
            onlyWordsArrayRev[i] = onlyWordsArrayList.get(onlyWordsArrayList.size() - 1 - i);
        }

        int[] onlyPunctIndexArray = new int[onlyPunctIndexArrayList.size()];
        for (int i = 0; i < onlyPunctIndexArrayList.size(); i++) {
            onlyPunctIndexArray[i] = onlyPunctIndexArrayList.get(i);
        }

        String[] onlyPunctArray = new String[onlyPunctIndexArrayList.size()];
        for (int i = 0; i < onlyPunctIndexArrayList.size(); i++) {
            onlyPunctArray[i] = onlyPunctArrayList.get(i);
        }

        for (int i = 0; i < onlyWordsArrayList.size() + onlyPunctArrayList.size(); i++){
            for (int j = 0; j < onlyPunctIndexArray.length; j++) {
                if (i == onlyPunctIndexArray[j]) {
                    finalArrayList.add(onlyPunctArray[j]);
                } else {
                    finalArrayList.add(onlyWordsArrayRev[i]);
                }
            }
//            System.out.println(finalArrayList.get(i));
        }

        String[] finalArray = new String[finalArrayList.size()];
        for (int i = 0; i < finalArray.length; i++) {
            finalArray[i] = finalArrayList.get(i);
        }

        System.out.println(Arrays.toString(onlyPunctArray));
        System.out.println(Arrays.toString(onlyPunctIndexArray));
        System.out.println(Arrays.toString(finalArray));

        return finalArray;
    }

    //2 & 2.5
    static String findTheWord(String[] wordFind, int wordFindIndex) {
        return wordFind[wordFind.length - 2] + " " + wordFind[wordFindIndex - 1];
    }

    //3
    static boolean wordSearch(String[] sentenceSearch, String wordSearch) {
        return (sentenceSearch[0].equals(wordSearch));
    }

    //3.5
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

    //4
    static boolean anagrams(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        ArrayList<Character> word2ArrList = new ArrayList<>();
        ArrayList<Character> savedCharacters = new ArrayList<>();

        for (char element : word2Arr) {
            word2ArrList.add(element);
        }

        for (int i = 0; i < word1Arr.length; i++) {
            for (int j = 0; j < word2ArrList.size(); j++) {
                if (Character.toLowerCase(word2ArrList.get(j)) == (Character.toLowerCase(word1Arr[i]))) {
                    savedCharacters.add(word2ArrList.get(j));
                    word2ArrList.remove(j);
                }
            }
        }
        return word2ArrList.isEmpty();
    }

    static void anagramGroups(String[] inputArray) {
        
        char[][] inputCharArray = new char[inputArray.length][];
        
        for (int i = 0; i < inputCharArray.length; i++) {
            for (int j = 0; j < inputArray[i].length(); j++){
                inputCharArray[i][j] = inputArray[i].toCharArray()[j];
            }
        }
        System.out.println(inputCharArray.toString());
    }

    //5
    static boolean imperfectPanagram(String sentence) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] onlyChars = splitIntoChars(sentence);
        int numOfAlphabetLetters = 0;

        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < onlyChars.length; j++) {
                if (alphabet[i] == Character.toLowerCase(onlyChars[j])) {
                    numOfAlphabetLetters++;
                }
            }
        }
        return numOfAlphabetLetters >= 26;
    }

    //5.5
    static boolean perfectPanagram(String sentence) {
        char[] onlyChars = splitIntoChars(sentence);
        return anagrams(String.valueOf(onlyChars), "abcdefghijklmnopqrstuvwxyz");
    }

    //6
    static int numberReversal(int inputNumber) {
        char[] numCharArr = extractNumReversed(inputNumber);
        return Integer.parseInt(String.valueOf(numCharArr));
    }

    //7
    static boolean isArmstrongNum(int inputNumber) {
        char[] inputNumCorrectOrder = new char[extractNumReversed(inputNumber).length];

        for (int i = 0; i < inputNumCorrectOrder.length; i++) {
            inputNumCorrectOrder[i] = extractNumReversed(inputNumber)[inputNumCorrectOrder.length - i - 1];
        }

        int result = 0;

        for (char element : inputNumCorrectOrder) {
            result = result + raiseToPower(Integer.parseInt(String.valueOf(element)), inputNumCorrectOrder.length);
        }
        return (result == inputNumber);
    }

    //7.5
    static void armstrongNumCalc(int limit) {
        for (int i = 0; i <= limit; i++) {
            if (isArmstrongNum(i)) {
                System.out.println(i);
            }
        }
    }

    static int raiseToPower(int num, int power) {
        int result = 1;
        if (power == 0) {
           return result;
       }
        for (int i = 0; i < power; i++) {
            result = result * num;
        }
        return result;
    }

    //8
    static void productMaximizer(int[] input) {
        int maxProduct = 0;
        int maxProductValue1 = 0;
        int maxProductValue2 = 0;

        //first value starts at the first element of input
        for (int i = 0; i < input.length; i++) {
            System.out.println("first value: " + input[i]);
            //second value starts at the input occurring one element after the first one
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] * input[j] > maxProduct) {
                    maxProduct = input[i] * input[j];
                    maxProductValue1 = input[i];
                    maxProductValue2 = input[j];
                }
            }
        }
        System.out.print("Maximum product: " + maxProduct + "\n" +
                         "Value one: " + maxProductValue1 + "\n" +
                         "Value two: " + maxProductValue2);
            }

    //8.5
    static void productMaximizerArr(int[] input1, int[] input2) {
        int maxProduct = 0;
        int maxProductValue1 = 0;
        int maxProductValue2 = 0;

        for(int i = 0; i < input1.length; i++) {
            for (int j = 0; j < input2.length; j++) {
                if (input1[i] * input2[j] > maxProduct) {
                    maxProduct = input1[i] * input2[j];
                    maxProductValue1 = input1[i];
                    maxProductValue2 = input2[j];
                }
            }
        }
        System.out.print("Maximum product: " + maxProduct + "\n" +
                "Value one: " + maxProductValue1 + "\n" +
                "Value two: " + maxProductValue2);
    }

    //9
    static boolean primeChecker(int inputNum) {
        int remainder;
        for (int i = 1; i < inputNum; i++) {
            if (!(i == 1 || i == inputNum)) {
                if (inputNum % i == 0) {
                    return false;
                }
            }
        }
    return true;
    }

    //9.5
    static void primeCheckerNum(int inputNum) {
        for (int i = 2; i < inputNum; i++) {
            if (primeChecker(i)) {
                System.out.println(i);
            }
        }
    }

    //10 & 10.5
    static int[] primeFactorization(int inputNum) {
        ArrayList<Integer> primeArrList = new ArrayList<>();
        //divide by 2 to safe resources
        for (int i = 1; i <= inputNum / 2; i++) {
            if (inputNum % i == 0) {
                System.out.println(i);
                if (primeChecker(i)) {
                    primeArrList.add(i);
                }
            }
        }
        int[] primeArr = new int[primeArrList.size()];
        for (int i = 0; i < primeArr.length; i++) {
            primeArr[i] = primeArrList.get(i);
        }

        return primeArr;
    }
}
