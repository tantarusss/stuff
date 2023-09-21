import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class PracticeTasks {

    public static void main(String[] args) {
        // Separates program selection from program arguments
        ArrayList<String> programArgs = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            programArgs.add(args[i]);
        }

        switch (args[0]) {
            case "--sum":
                sum(programArgs.get(0), programArgs.get(1));
                break;
            case "--even":
                even(programArgs.get(0));
                break;
            case "--uneven":
                uneven(programArgs.get(0));
                break;
            case "--array":
                array(programArgs.toArray(new String[0]));
                break;
            case "--multiple":
                multiple(programArgs.get(0), programArgs.get(1), programArgs.get(2), programArgs.get(3));
                break;
            case "--iterator":
                myiterator();
                break;
            case "--leapyear":
                leapyear(programArgs.get(0));
                break;
            case "--all":
                even(args[0]);
                uneven(args[0]);
                sum(args[0], args[1]);
                leapyear(args[0]);
                myiterator();
                multiple(args[0], args[1], args[2], args[3]);
                array(args);
                break;
            case "--help":
                System.out.print("Compilation of all Projects:\n" +
                        "Usage:\n" +
                        "java PracticeTask.java [COMMAND] + [INPUT]\n"+
                        "\n" +
                        "Commands:\n" +
                        "--even [int]\n" +
                        "--uneven [int]\n" +
                        "--sum [int] [int]\n" +
                        "--leapyear [int]\n" +
                        "--iterator\n" +
                        "--array [int] [int] ...\n" +
                        "--multiple [str] [str] [int] [int]\n");
                break;
            default:
                System.out.print("Invalid option");
                break;
        }


    }

    static void even(String even_arg) {
        System.out.println("\nEven:\n");
        int num = Integer.parseInt(even_arg);
        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    static void uneven(String uneven_arg) {
        System.out.println("\nUneven:\n");
        int num = Integer.parseInt(uneven_arg);
        int i = num;
        while (i >= 0) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
            i--;
        }
    }

    static void sum(String sum_arg1, String sum_arg2) {
        System.out.println("\nSum\n");
        int var1 = Integer.parseInt(sum_arg1);
        int var2 = Integer.parseInt(sum_arg2);
        System.out.println(var1 + var2);
    }

    static void leapyear(String leapyeararg) {
        System.out.println("\nLeap Year:\n");
        int year = Integer.parseInt(leapyeararg);

        for (int i = 0; i <= year; i++) {
            if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) {
                System.out.println(i);
            }
        }
    }

    static void myiterator() {
        System.out.println("\nIterator:\n");
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(50);
        numbers.add(40);
        numbers.add(30);
        numbers.add(20);


        Iterator<Integer> iter = numbers.iterator();

        while (iter.hasNext()) {
            Integer num = iter.next();
            System.out.println(num);

            if (num > 10) {
                iter.remove();
            }
        }
        System.out.println(numbers);
    }

    static void multiple(String multiplestr1, String multiplestr2, String multipleint1, String multipleint2) {
        System.out.println("\nMultiple:\n");
        for (int i = 0; i < Integer.parseInt(multipleint1); i++) {
            System.out.println(multiplestr1);
        }
        for (int i = 0; i < Integer.parseInt(multipleint2); i++) {
            System.out.println(multiplestr2);
        }
    }

    static void array(String[] array) {
        System.out.println("\nArray:\n");
        //init array and parse args
        int length = array.length;
        int[] myArray = new int[length];

        for (int i = 0; i < length; i++) {
            myArray[i] = Integer.parseInt(array[i]);
        }

        //print sum of every array element
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = sum + myArray[i];
        }
        System.out.println("Sum: " + sum);

        //alternate + and -
        int addSubSum = 0;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                addSubSum = addSubSum + myArray[i];
            } else {
                addSubSum = addSubSum - myArray[i];
            }
        }
        System.out.println("Add and subtract: " + addSubSum);

        //alternate / and - after the 1st element
        float mulDivProduct = myArray[0];
        for (int i = 1; i < length; i++) {
            if (i % 2 != 0) {
                mulDivProduct = mulDivProduct / myArray[i];
            } else {
                mulDivProduct = mulDivProduct * myArray[i];
            }
        }
        System.out.println("Multiply and divide: " + mulDivProduct);
    }
}
