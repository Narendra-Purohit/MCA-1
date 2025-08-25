/* 2.Write a program that reads five integer numbers from the command line, sorts them, and then displays the minimum and maximum values.*/

public class MinMaxSorter {
    public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println("Please enter 5 numbers.");
            return;
        }

        int[] a = new int[5];
        for (int i = 0; i < 5; i++) {
            try {
                a[i] = Integer.parseInt(args[i]); // check if value is integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: '" + args[i] + "' is not an integer.");
                return;
            }
        }

    
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

 
        System.out.print("Sorted: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        System.out.println("Minimum: " + a[0]);
        System.out.println("Maximum: " + a[4]);
    }
}

