import java.util.Scanner;

public class lab8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants
        System.out.println("Enter number of states");
        int NUM_STATES = scanner.nextInt();
        int NUM_DAYS = 7;

        // Initialize two-dimensional array to store daily cases
        int[][] dailyCases = new int[NUM_STATES][NUM_DAYS];
        String []states=new String [NUM_STATES];

        // Read daily cases for each state
        for (int i = 0; i < NUM_STATES; i++) {
            System.out.println("Enter states name");
            states[i]=scanner.next();
            System.out.println("Enter daily cases for State " + (i + 1) + ":");
            for (int j = 0; j < NUM_DAYS; j++) {
                System.out.print("Day " + (j + 1) + ": ");
                dailyCases[i][j] = scanner.nextInt();
            }
        }

        // Calculate total cases for each state and overall total cases
        int[] totalCasesPerState = new int[NUM_STATES];
        int overallTotalCases = 0;

        for (int i = 0; i < NUM_STATES; i++) {
            for (int j = 0; j < NUM_DAYS; j++) {
                totalCasesPerState[i] += dailyCases[i][j];
                overallTotalCases += dailyCases[i][j];
            }
        }

        // Display the table to summarize the information
        System.out.println("--------- Covid 19 In a Week ------------------");
        System.out.printf("%-15s%-5s%-5s%-5s%-5s%-5s%-5s%-5s%-5s%n",
                "Disease\\Day", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun", "Total");

        for (int i = 0; i < NUM_STATES; i++) {
            System.out.printf("%-15s", states[i]);
            for (int j = 0; j < NUM_DAYS; j++) {
                System.out.printf("%-5d", dailyCases[i][j]);
            }
            System.out.printf("%-5d%n", totalCasesPerState[i]);
        }

        System.out.println("-----------------------");
        System.out.printf("Overall Total :    %-5d%n", overallTotalCases);

        // Display the line graph based on the percentage
        System.out.println("\nLine Graph >>>>>>>>");
        for (int i = 0; i < NUM_STATES; i++) {
            double percentage = (totalCasesPerState[i] * 100) / overallTotalCases;
            System.out.printf("%-7s:",states[i]);
            for (int j = 0; j < (int)percentage; j++) {
                System.out.print("*");
            }
            System.out.printf(" (%.2f%%)%n", percentage);
        }

        scanner.close();
    }
}
