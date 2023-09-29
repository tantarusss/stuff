import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class AdventOfCode {
    public static void main(String[] args) throws IOException {
        adventOfCodeDay1();
//        adventOfCodeDay3();
//        adventOfCodeDay4();
        //adventOfCodeDay5();
    }

    static void adventOfCodeDay1() throws IOException {
        String input =  "1000\n" +
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
        
        Path path = Paths.get("C:\\\\Users\\Unterwegs\\IdeaProjects\\WordTask\\inputFile.txt");
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

    static void adventOfCodeDay3() {
        String input =  "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
                        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
                        "PmmdzqPrVvPwwTWBwg\n" +
                        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
                        "ttgJtRGJQctTZtZT\n" +
                        "CrZsJsPPZsGzwwsLwLmpwMDw";
        String[] backpacks = input.split("\\n");
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

    static void adventOfCodeDay4() {
        String input =  "2-4,6-8\n" +
                        "2-3,4-5\n" +
                        "5-7,7-9\n" +
                        "2-8,3-7\n" +
                        "6-6,4-6\n" +
                        "2-6,4-8";
        String[] pairs = input.split("\\n");
        int[] ids1;
        int[] ids2;
        int pairOverlaps = 0;

        for (int i = 0; i < pairs.length; i++) {
//            String startID1Str = pairs[i].split("[-,]")[0];
//            int startID1 = Integer.parseInt(pairs[i].split("[-,]")[0]);
            int ids1Start = Integer.parseInt(pairs[i].split("[-,]")[0]);
            int ids1End = Integer.parseInt(pairs[i].split("[-,]")[1]);
            int ids2Start = Integer.parseInt(pairs[i].split("[-,]")[2]);
            int ids2End = Integer.parseInt(pairs[i].split("[-,]")[3]);

            ids1 = range(ids1Start, ids1End);
            ids2 = range(ids2Start, ids2End);

            boolean start1IsPresent = false;
            boolean end1IsPresent = false;
            boolean start2IsPresent = false;
            boolean end2IsPresent = false;

            for (int j = 0; j < ids1.length; j++) {
                if (ids1[j] == ids2Start) {
                    start2IsPresent = true;
                } else if (ids1[j] == ids2End) {
                    end2IsPresent = true;
                }
            }

            for (int k = 0; k < ids2.length; k++) {
                if (ids2[k] == ids1Start) {
                    start1IsPresent = true;
                } else if (ids2[k] == ids1End) {
                    end1IsPresent = true;
                }
            }
            if ((start2IsPresent && end2IsPresent) || (start1IsPresent && end2IsPresent)) {
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

    static void adventOfCodeDay5() {
        String input =  "    [D]    \n" +
                        "[N] [C]    \n" +
                        "[Z] [M] [P]\n" +
                        " 1   2   3 \n" +
                        "\n" +
                        "move 1 from 2 to 1\n" +
                        "move 3 from 1 to 3\n" +
                        "move 2 from 2 to 1\n" +
                        "move 1 from 1 to 2";

        //regex for crate name: "[\[.\]]"

        String[] inputSplit = input.split("\\n\\n");
        String cargo = inputSplit[0];
        String[] cargoSplit = cargo.split("\\n");
        String stackNumbers = cargoSplit[cargoSplit.length - 1];
        String[] stackNumbersArray = removeEmptyString(stackNumbers.split(" *"));
        String instructions = inputSplit[1];

        String[] cargoRow1 = cargoSplit[0].split("(   )");
        String[] cargoRow2 = cargoSplit[1].split("(   )");
        String[] cargoRow3 = cargoSplit[2].split("\\].\\[");
    }
}
