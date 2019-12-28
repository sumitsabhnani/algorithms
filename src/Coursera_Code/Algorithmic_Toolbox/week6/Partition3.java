package Coursera_Code.Algorithmic_Toolbox.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Partition3 {
    public static int partition3(int[] A) {
        if (A.length < 3)
            return 0;
        int souvenirSum = Arrays.stream(A).reduce(0, Integer::sum);
        if (souvenirSum % 3 != 0)
            return 0;
        int souvenirValue = souvenirSum / 3;
        Arrays.sort(A);
        if (A[A.length - 1] > souvenirValue)
            return 0;
        List<Integer> souvenirsTaken = new ArrayList<>();
        int pairs = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (!souvenirsTaken.contains(i)) {
                int remainingValue = souvenirValue - A[i];
                souvenirsTaken.add(i);
                if (remainingValue == 0) {
                    pairs++;
                } else {
                    for (int j = i - 1; j >= 0; j--) {
                        if (!souvenirsTaken.contains(j) && remainingValue >= A[j]) {
                            int temp = remainingValue - A[j];
                            souvenirsTaken.add(j);
                            if (temp == 0) {
                                pairs++;
                                break;
                            } else {
                                remainingValue = temp;
                            }
                        }
                    }
                }
            }
        }
        return pairs == 3 ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

