import java.util.*;

public class MainProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = {};

        while (true) {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms (performance table)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter numbers separated by space: ");
                    input.nextLine(); // consume leftover newline
                    String[] parts = input.nextLine().split(" ");
                    numbers = new int[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        numbers[i] = Integer.parseInt(parts[i]);
                    }
                    System.out.println("Numbers stored successfully!");
                    break;

                case 2:
                    System.out.print("Enter dataset size: ");
                    int n = input.nextInt();
                    numbers = new int[n];
                    Random rand = new Random();
                    for (int i = 0; i < n; i++) {
                        numbers[i] = rand.nextInt(100);
                    }
                    System.out.println("Random dataset generated successfully!");
                    break;

                case 3:
                    if (numbers.length == 0) {
                        System.out.println("No data available! Please enter or generate numbers first.");
                        break;
                    }
                    int[] bArr = numbers.clone();
                    long bStart = System.nanoTime();
                    int bSteps = BubbleSort.bubbleSort(bArr);
                    long bEnd = System.nanoTime();
                    System.out.println("Bubble Sort Result: " + Arrays.toString(bArr));
                    System.out.println("Time: " + (bEnd - bStart) + " ns | Steps: " + bSteps);
                    break;

                case 4:
                    if (numbers.length == 0) {
                        System.out.println("No data available! Please enter or generate numbers first.");
                        break;
                    }
                    int[] mArr = numbers.clone();
                    long mStart = System.nanoTime();
                    int mSteps = MergeSort.mergeSort(mArr);
                    long mEnd = System.nanoTime();
                    System.out.println("Merge Sort Result: " + Arrays.toString(mArr));
                    System.out.println("Time: " + (mEnd - mStart) + " ns | Steps: " + mSteps);
                    break;

                case 5:
                    if (numbers.length == 0) {
                        System.out.println("No data available! Please enter or generate numbers first.");
                        break;
                    }
                    int[] qArr = numbers.clone();
                    long qStart = System.nanoTime();
                    int qSteps = QuickSort.quickSort(qArr);
                    long qEnd = System.nanoTime();
                    System.out.println("Quick Sort Result: " + Arrays.toString(qArr));
                    System.out.println("Time: " + (qEnd - qStart) + " ns | Steps: " + qSteps);
                    break;

                case 6:
                    if (numbers.length == 0) {
                        System.out.println("No data available! Please enter or generate numbers first.");
                        break;
                    }
                    compareAll(numbers);
                    break;

                case 7:
                    System.out.println("Exiting the program...");
                    input.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void compareAll(int[] numbers) {
        int[] bArr = numbers.clone();
        int[] mArr = numbers.clone();
        int[] qArr = numbers.clone();

        long bStart = System.nanoTime();
        int bSteps = BubbleSort.bubbleSort(bArr);
        long bEnd = System.nanoTime();

        long mStart = System.nanoTime();
        int mSteps = MergeSort.mergeSort(mArr);
        long mEnd = System.nanoTime();

        long qStart = System.nanoTime();
        int qSteps = QuickSort.quickSort(qArr);
        long qEnd = System.nanoTime();

        System.out.println("\n--- Performance Comparison Table ---");
        System.out.println("Algorithm\tTime (ns)\tSteps");
        System.out.println("-----------------------------------------");
        System.out.printf("Bubble Sort\t%d\t%d\n", (bEnd - bStart), bSteps);
        System.out.printf("Merge Sort\t%d\t%d\n", (mEnd - mStart), mSteps);
        System.out.printf("Quick Sort\t%d\t%d\n", (qEnd - qStart), qSteps);
    }
}

