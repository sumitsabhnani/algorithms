package Coursera_Code.algorithmic_toolbox.week5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimitiveCalculator {

//    private static List<Integer> optimal_sequence_greedy(int n) {
//        List<Integer> sequence = new ArrayList<Integer>();
//        while (n >= 1) {
//            sequence.add(n);
//            if (n % 3 == 0) {
//                n /= 3;
//            } else if (n % 2 == 0) {
//                n /= 2;
//            } else {
//                n -= 1;
//            }
//        }
//        Collections.reverse(sequence);
//        return sequence;
//    }

    private static List<Integer> optimal_sequence_dp(List<Integer> sequence, int n) {
        if (n == 1)
            return sequence;
        if (n % 3 == 0) {
            sequence.add(n / 3);
            return optimal_sequence_dp(sequence, n / 3);
        } else if (n % 2 == 0) {
            List<Integer> op1 = new ArrayList<>();
            List<Integer> op2 = new ArrayList<>();
            List<Integer> resultOp1, resultOp2 = null;
            if ((n & (n - 1)) == 0) {
                op1.add(n / 2);
                resultOp1 = optimal_sequence_dp(op1, n / 2);
            } else {
                op1.add(n / 2);
                resultOp1 = optimal_sequence_dp(op1, n / 2);
                op2.add(n - 1);
                resultOp2 = optimal_sequence_dp(op2, n - 1);
            }
            if (resultOp2 != null && resultOp2.size() < resultOp1.size()) {
                sequence.addAll(resultOp2);
            } else {
                sequence.addAll(resultOp1);
            }
            return sequence;
        } else {
            sequence.add(n - 1);
            return optimal_sequence_dp(sequence, n - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> s = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        s.add(n);
        List<Integer> sequence = optimal_sequence_dp(s, n);
        Collections.reverse(sequence);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }

//    public static void main(String[] args) {
//        for (int i = 1; i < 10000; i++) {
//            List<Integer> s = new ArrayList<Integer>();
//            List<Integer> greedy = optimal_sequence_greedy(i);
//            List<Integer> dp = optimal_sequence_dp(s, i);
//            if (greedy.size() < dp.size()) {
//                System.out.println(i);
//            } else {
//                System.out.println("No:"+i);
//            }
//        }
//    }
}

