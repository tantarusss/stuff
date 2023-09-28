import java.sql.Array;
import java.util.ArrayList;

public class AdventOfCode {
    public static void main(String[] args) {
        adventOfCodeDay3();
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

    static void adventOfCodeDay1() {
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
        String[] inputToArr = input.split("\\n");
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
}
