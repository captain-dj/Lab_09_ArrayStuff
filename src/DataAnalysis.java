import java.util.Random;
import java.util.Scanner;

public class DataAnalysis {
    public static void main(String[] args) {
        int[] dataPoints = new int[100];
        Random random = new Random();

        // Initialize dataPoints with random values between 1 and 100
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = random.nextInt(100) + 1;
        }

        // Display dataPoints values separated by " | "
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i]);
            if (i != dataPoints.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println();

        // Calculate sum and average of dataPoints
        int sum = 0;
        for (int value : dataPoints) {
            sum += value;
        }
        double average = (double) sum / dataPoints.length;

        // Output sum and average with descriptions
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.println("The average of the random array dataPoints is: " + average);

        // Linear scan (search)
        Scanner scanner = new Scanner(System.in);
        int userValue;
        int count = 0;

        // Prompt user for input between 1 and 100
        userValue = SafeInput.getRangedInt(scanner, "Enter a value between 1 and 100: ", 1, 100);

        // Count occurrences of userValue in dataPoints
        for (int value : dataPoints) {
            if (value == userValue) {
                count++;
            }
        }
        System.out.println("The value " + userValue + " was found " + count + " times in the array.");

        // Prompt user again for a value between 1 and 100
        userValue = SafeInput.getRangedInt(scanner, "Enter another value between 1 and 100: ", 1, 100);

        // Find first position of userValue in dataPoints array
        int position = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                position = i;
                break;
            }
        }

        if (position != -1) {
            System.out.println("The value " + userValue + " was found at array index " + position + ".");
        } else {
            System.out.println("The value " + userValue + " was not found in the array.");
        }

        // Finding minimum and maximum values
        int min = dataPoints[0];
        int max = dataPoints[0];

        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }

        System.out.println("The minimum value in the array is: " + min);
        System.out.println("The maximum value in the array is: " + max);

        // Calculate average of dataPoints
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }

    public static double getAverage(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }
}