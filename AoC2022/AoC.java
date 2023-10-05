import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdventOfCode {
    public static void main(String[] args) throws IOException {
        //adventOfCodeDay1();
        //adventOfCodeDay3();
//        adventOfCodeDay4();
//        adventOfCodeDay5();
//        adventOfCodeDay2();
        adventOfCodeDay6();
    }

    static void adventOfCodeDay1() throws IOException {
        String input = "1000\n" +
                "2000\n" +
                "3000\n" +
                "\n" +
                "1000\n" +
                "\n" +
                "5000\n" +
                "6000\n" +
                "\n" +
                "7000\n" +
                "8000\n" +
                "9000\n" +
                "\n" +
                "10000";

        Path path = Paths.get("C:\\\\Users\\Unterwegs\\IdeaProjects\\WordTask\\Day1.txt");
        String inputStr = Files.readString(path);

        String[] inputToArr = inputStr.split("\\r\\n");
        //System.out.println(Arrays.toString(inputToArr));
        int mostCalories = 0;
        int currentCalories = 0;
        int currentElf = 1;
        int maxElf = 1;

        for (int i = 0; i < inputToArr.length; i++) {
            if (!(inputToArr[i].isEmpty())) {
                //System.out.println(Integer.parseInt(inputToArr[i]));
                currentCalories += Integer.parseInt(inputToArr[i]);
            } else {
                //System.out.println("Is Empty");
                currentCalories = 0;
                currentElf++;
                continue;
            }
            if (currentCalories > mostCalories) {
                mostCalories = currentCalories;
                maxElf = currentElf;
            }
        }

        System.out.println("Elf number " + maxElf + " has the most calories with " + mostCalories + " calories");
    }

    static void adventOfCodeDay2() throws IOException {
        Path path = Paths.get("C:\\\\Users\\Unterwegs\\IdeaProjects\\WordTask\\Day2.txt");
        String input = Files.readString(path);
        String[] inputLines = input.split("\\r\\n");
        int totalScore = 0;

        for (int i = 0; i < inputLines.length; i++) {
            int score;
            String round = inputLines[i].split(" ")[0] + inputLines[i].split(" ")[1];

            switch (round) {
                case "AX" -> score = 4;
                case "AY" -> score = 8;
                case "AZ" -> score = 3;
                case "BX" -> score = 1;
                case "BY" -> score = 5;
                case "BZ" -> score = 9;
                case "CX" -> score = 7;
                case "CY" -> score = 2;
                case "CZ" -> score = 6;
                default -> score = 0;
            }
            totalScore += score;
        }
        System.out.println(String.valueOf(totalScore));
    }
    static String[] halveString(String input) {
        String[] halvedString = new String[2];
        char[] firstHalf = new char[input.length() / 2];
        char[] secondHalf = new char[input.length() / 2];
        for (int i = 0; i < input.length(); i++) {
            if (i <= (input.length() / 2) - 1) {
                firstHalf[i] = input.toCharArray()[i];
            } else {
                secondHalf[i - input.length() / 2] = input.toCharArray()[i];
            }
        }
        halvedString[0] = String.valueOf(firstHalf);
        halvedString[1] = String.valueOf(secondHalf);
        return halvedString;
    }

    static char findCommonChar(String input1, String input2) {
        char[] input1Arr = input1.toCharArray();
        char[] input2Arr = input2.toCharArray();
        char commonChar = ' ';

        for (int i = 0; i < input1Arr.length; i++) {
            for (int j = 0; j < input2Arr.length; j++) {
                if (input1Arr[i] == input2Arr[j]) {
                    commonChar = input1Arr[i];
                }
            }
        }
        return commonChar;
    }

    static void adventOfCodeDay3() throws IOException {
        String input = "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
                "PmmdzqPrVvPwwTWBwg\n" +
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
                "ttgJtRGJQctTZtZT\n" +
                "CrZsJsPPZsGzwwsLwLmpwMDw";

        Path path = Paths.get("C:\\\\Users\\Unterwegs\\IdeaProjects\\WordTask\\Day3.txt");
        String inputStr = Files.readString(path);


        String[] backpacks = inputStr.split("\\r\\n");
        String[][] backpackCompartments = new String[backpacks.length][2];


        for (int i = 0; i < backpacks.length; i++) {
            backpackCompartments[i] = halveString(backpacks[i]);
        }

        int sum = 0;

        for (int i = 0; i < backpacks.length; i++) {
            char commonChar = findCommonChar(backpackCompartments[i][0], backpackCompartments[i][1]);
            System.out.print(commonChar + " ");
            if (Character.isLowerCase(commonChar)) {
                System.out.println(commonChar - 'a' + 1);
                sum += commonChar - 'a' + 1;
            } else {
                System.out.println(commonChar - 'A' + 27);
                sum += commonChar - 'A' + 27;
            }
        }
        System.out.println("Sum: " + sum);

    }

    static int[] range(int start, int end) {
        ArrayList<Integer> finalList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            finalList.add(i);
        }
        int[] output = new int[finalList.size()];
        for (int i = 0; i < finalList.size(); i++) {
            output[i] = finalList.get(i);
        }
        return output;
    }

    static void adventOfCodeDay4() throws IOException {
        String input = "2-4,6-8\n" +
                "2-3,4-5\n" +
                "5-7,7-9\n" +
                "2-8,3-7\n" +
                "6-6,4-6\n" +
                "2-6,4-8";

        Path path = Paths.get("C:\\\\Users\\Unterwegs\\IdeaProjects\\WordTask\\Day4.txt");
        String inputStr = Files.readString(path);

        String[] pairs = inputStr.split("\\r\\n");
        int pairOverlaps = 0;

        for (int i = 0; i < pairs.length; i++) {
            int ids1Start = Integer.parseInt(pairs[i].split("[-,]")[0]);
            int ids1End = Integer.parseInt(pairs[i].split("[-,]")[1]);
            int ids2Start = Integer.parseInt(pairs[i].split("[-,]")[2]);
            int ids2End = Integer.parseInt(pairs[i].split("[-,]")[3]);

            if ((ids1Start >= ids2Start && ids1End <= ids2End) || (ids2Start >= ids1Start && ids2End <= ids1End)) {
                    pairOverlaps++;
            }
        }
        System.out.println("There is/are " + pairOverlaps + " pair(s) that fully contain each other");
    }

    static String[] removeEmptyString(String[] input) {
        ArrayList<String> noNull = new ArrayList<>(input.length);
        for (String element : input) {
            if (!(element.isEmpty())) {
                noNull.add(element);
            }
        }
        return noNull.toArray(new String[0]);
    }

    static int[] extractInteger(String input) {
        int[] integers = new int[3];
        String[] inputWords = input.split(" ");
        for (int i = 0, j = 0; i < inputWords.length; i++) {
            try {
                int element = Integer.parseInt(inputWords[i]);
                integers[j++] = element;
            }
            catch (Exception e)
            {
                continue;
            }
        }
        return integers;
    }
    static void adventOfCodeDay5() throws IOException {
        String input =  "    [D]    \n" +
                        "[N] [C]    \n" +
                        "[Z] [M] [P]\n" +
                        " 1   2   3 \n" +
                        "\n" +
                        "move 1 from 2 to 1\n" +
                        "move 3 from 1 to 3\n" +
                        "move 2 from 2 to 1\n" +
                        "move 1 from 1 to 2";

        Path path = Paths.get("C:\\\\Users\\Unterwegs\\IdeaProjects\\WordTask\\Day5.txt");
        String inputStr = Files.readString(path);

        String[] inputSplit = inputStr.split("\\r\\n\\r\\n");
        String cargo = inputSplit[0];
        String[] cargoSplit = cargo.split("\\r\\n");
        String stackNumbers = cargoSplit[cargoSplit.length - 1];
        String[] stackNumbersArray = removeEmptyString(stackNumbers.split(" *"));
        String instructions = inputSplit[1];
        String[] instructionsArr = instructions.split("\\r\\n");
        int totalWidth = stackNumbersArray.length * 3 + stackNumbersArray.length - 1;

        //fill end with spaces
        int indexInCargoSplit = 0;
        for (int i = 0; i < cargoSplit.length - 1; i++) {
            String element = cargoSplit[i];
            StringBuilder elementBuilder = new StringBuilder(element);
            while (elementBuilder.length() < totalWidth + 1) {
                int length = elementBuilder.length();
                elementBuilder.append(" ");
                System.out.println(length);
            }
            element = elementBuilder.toString();
            cargoSplit[i] = element;
        }

        char[][] cratesArr = new char[stackNumbersArray.length][cargoSplit.length - 1];
        ArrayList<ArrayList<Character>> allCrates = new ArrayList<ArrayList<Character>>();



        //get crates
        for (int i = 0, k = 0; i < stackNumbersArray.length; i++, k = k + 4) {
            ArrayList<Character> crates = new ArrayList<>();
            for (int j = cargoSplit.length - 2, l = 0; j >= 0; j--, l++) {
                if (cargoSplit[j].toCharArray()[1 + k] != ' ') {
                    crates.add(cargoSplit[j].toCharArray()[1 + k]);
                }
            }
            allCrates.add(crates);
        }

        //loop through instructions
        for (String element : instructionsArr) {
            int[] extracted = extractInteger(element);
            int amountToMove = extracted[0];
            int startIndex = extracted[1] - 1 ;
            int endIndex = extracted[2] - 1;
            char crateToMove;

            for (int i = 0; i < amountToMove; i++) {
                crateToMove = allCrates.get(startIndex).get(allCrates.get(startIndex).size() - 1);
                allCrates.get(endIndex).add(crateToMove);
                allCrates.get(startIndex).remove(allCrates.get(startIndex).size() - 1);
            }
            System.out.println(Arrays.toString(extracted));
        }
        for (int i = 0; i < allCrates.size(); i++) {
            System.out.print(allCrates.get(i).get(allCrates.get(i).size() - 1));
        }


    }

    static void adventOfCodeDay6() throws IOException {
        String input = "bvwbjplbgvbhsrlpgdmjqwftvncz";
        Path path = Paths.get("C:\\\\Users\\Unterwegs\\IdeaProjects\\WordTask\\Day6.txt");
        String inputStr = Files.readString(path);
        char[] signalBuffer = new char[4];
        boolean nonDuplicate = false;
        int firstMarker = 0;
        int nonDuplicatesToReach = 0;
        for (int i = 1; i < signalBuffer.length; i++) {
            nonDuplicatesToReach += signalBuffer.length - i;
        }

        for (int i = 0; i < inputStr.length() - signalBuffer.length + 1; i++) {
            for (int j = 0; j < signalBuffer.length; j++) {
                signalBuffer[j] = inputStr.toCharArray()[i + j];
            }
            int nonDuplicateNumbers = 0;
            for (int j = 0; j < signalBuffer.length; j++) {
                for (int k = j + 1; k < signalBuffer.length; k++) {
                    if (signalBuffer[j] != signalBuffer[k]) {
                        nonDuplicateNumbers++;
                    }
                }
            }
            if (nonDuplicateNumbers == nonDuplicatesToReach) {
                firstMarker = i + signalBuffer.length;
                break;
            }
        }
        System.out.println("First Marker: " + String.valueOf(firstMarker));
    }
}

